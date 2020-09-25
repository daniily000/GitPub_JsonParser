package data

data class ContrServGeoDto(
    val contrServId: String,
    val geozoneId: String,
    val price: Int,
    val averageExecutionTime: Int,
    val providedFrom: String,
    val providedTo: String
)
