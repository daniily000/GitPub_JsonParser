import com.google.gson.GsonBuilder
import data.*
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File
import java.io.FileReader
import java.io.FileWriter

const val INPUT_FILE = "resources/raw/input.json"
const val OUTPUT_FILE = "resources/raw/output.sql"

fun main() {
    println("App initialized")
    val gson = GsonBuilder().create()
    val jsonReader = FileReader(File(INPUT_FILE))
    val jsonConverter = { gson.fromJson(jsonReader, InputData::class.java) }
    val resultWriter = FileWriter(File(OUTPUT_FILE).apply { if (exists()) delete(); createNewFile() })
    val write = { text: String -> resultWriter.write(text); resultWriter.flush() }

    println("Ready for conversion")
    println("Reading...")
    Single
        .fromSupplier(jsonConverter)
        .subscribeOn(Schedulers.io())
        .doOnError {
            it.printStackTrace()
            println("Read failed")
        }
        .blockingSubscribe { result ->
            println("Read succeeded")
            val data = result.data
            write("/* SERVICE_TYPE */\n")
            write(
                data.serviceTypes
                    .joinToString(separator = "\n", transform = ServiceType::toSqlInit)
            )

            write("\n\n/* SERVICE */\n")
            write(
                data.services
                    .joinToString(separator = "\n", transform = ServiceXX::toSqlInit)
            )

            write("\n\n/* CONTRACTOR */\n")
            write(
                data.contractors
                    .joinToString(separator = "\n", transform = Contractor::toSqlInit)
            )

            write("\n\n/* SUPPLEMENTARY */\n")
            write(
                data.supplementaryConditions
                    .joinToString(separator = "\n", transform = SupplementaryCondition::toSqlInit)
            )

            write("\n\n/* SUPPLEMENTARY */\n")
            write(
                data.supplementaryConditions
                    .joinToString(separator = "\n", transform = SupplementaryCondition::toSqlInit)
            )

            write("\n\n/* GEOZONE */\n")
            write(data.geozones.joinToString(separator = "\n", transform = GeozoneX::toSqlInit))

            write("\n\n/* CONTR_SERV */\n")
            val contrServList = data.contractors.flatMap { contractor -> contractor.toContServ() }
            write(contrServList.joinToString(separator = "\n", transform = ContrServDto::toSqlInit))

            write("\n\n/* CONTR_SERV_SUPPL */\n")
            write(contrServList.flatMap { item -> item.toContrServSuppl() }
                .joinToString(separator = "\n", transform = ContrServSupplDto::toSqlInit))

            write("\n\n/* CONTR_SERV_GEO */\n")
            write(
                contrServList.flatMap(ContrServDto::toContrServGeo)
                    .joinToString(separator = "\n", transform = ContrServGeoDto::toSqlInit)
            )
        }
}

private fun ServiceType.toSqlInit() =
    """
        INSERT INTO SERVICE_TYPE (id, name) VALUES ('$id', '$name')
    """.trimIndent()

private fun ServiceXX.toSqlInit() =
    """
        INSERT INTO SERVICE (id, name, descr, type) VALUES ('$id', '$name', '$description', '${serviceType.id}')
    """.trimIndent()

private fun Contractor.toSqlInit() =
    """
        INSERT INTO CONTRACTOR (id, name) VALUES ('$id', '$name')
    """.trimIndent()

private fun SupplementaryCondition.toSqlInit() =
    """
        INSERT INTO SUPPLEMENTARY (id, name) VALUES ('$id', '$name')
    """.trimIndent()

private fun GeozoneX.toSqlInit() =
    """
        INSERT INTO GEOZONE (id, name) VALUES ('$id', '$name')
    """.trimIndent()

private fun Contractor.toContServ(): List<ContrServDto> = services.map {
    ContrServDto(
        contractorId = id,
        serviceIdType = it.serviceType.id,
        name = it.name,
        minWeight = it.minWeight,
        maxWeight = it.maxWeight,
        supplementaryConditions = supplementaryConditions,
        geozones = it.geozones
    )
}

private fun ContrServDto.toSqlInit() =
    """
        INSERT INTO CONTR_SERV (id, contractor_id, service_type_id, name, weight_min, weight_max) VALUES ('$id', '$contractorId', '$serviceIdType', '$name', '$minWeight', '$maxWeight')
    """.trimIndent()

private fun ContrServDto.toContrServSuppl() = supplementaryConditions.map { ContrServSupplDto(id, it.id) }
private fun ContrServDto.toContrServGeo() = geozones.map {
    ContrServGeoDto(
        contrServId = contractorId,
        geozoneId = it.id,
        price = it.servicePrice,
        averageExecutionTime = it.averageExecutionTime,
        providedFrom = it.providedFrom,
        providedTo = it.providedTo
    )
}

private fun ContrServSupplDto.toSqlInit() =
    """
        INSERT INTO CONTR_SERV_SUPPL (contr_serv_id, supplementary_id) VALUES ('$contrServId', '$supplementaryId')
    """.trimIndent()

private fun ContrServGeoDto.toSqlInit() =
    """
        INSERT INTO CONTR_SERV_GEO (contr_serv_id, geozone_id, price, avg_exec_time, provided_from, private_to) VALUES ('$contrServId', '$geozoneId', '$price', '$averageExecutionTime', '$providedFrom', '$providedTo')
    """.trimIndent()
