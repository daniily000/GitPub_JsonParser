package data

import java.util.*

data class ContrServDto(
    val id: String = UUID.randomUUID().toString(),
    val contractorId: String,
    val serviceIdType: String,
    val name: String,
    val minWeight: Int,
    val maxWeight: Int,
    val supplementaryConditions: List<SupplementaryConditionX>,
    val geozones: List<Geozone>
)