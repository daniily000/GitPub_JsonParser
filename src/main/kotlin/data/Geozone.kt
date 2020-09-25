package data


import com.google.gson.annotations.SerializedName

data class Geozone(
    @SerializedName("average_execution_time")
    val averageExecutionTime: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("provided_from")
    val providedFrom: String,
    @SerializedName("provided_to")
    val providedTo: String,
    @SerializedName("service_price")
    val servicePrice: Int
)