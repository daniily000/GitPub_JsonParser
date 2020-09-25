package data


import com.google.gson.annotations.SerializedName

data class Contractor(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("services")
    val services: List<Service>,
    @SerializedName("statistics")
    val statistics: Statistics,
    @SerializedName("supplementary_conditions")
    val supplementaryConditions: List<SupplementaryConditionX>
)