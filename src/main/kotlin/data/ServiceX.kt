package data


import com.google.gson.annotations.SerializedName

data class ServiceX(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)