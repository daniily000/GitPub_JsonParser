package data


import com.google.gson.annotations.SerializedName

data class SupplementaryCondition(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)