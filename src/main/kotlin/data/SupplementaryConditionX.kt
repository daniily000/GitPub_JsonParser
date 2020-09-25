package data


import com.google.gson.annotations.SerializedName

data class SupplementaryConditionX(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)