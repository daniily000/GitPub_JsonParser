package data


import com.google.gson.annotations.SerializedName

data class ServiceXX(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("service_type")
    val serviceType: ServiceType
)