package data


import com.google.gson.annotations.SerializedName

data class ServiceType(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)