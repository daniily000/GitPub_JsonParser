package data


import com.google.gson.annotations.SerializedName

data class Service(
    @SerializedName("geozones")
    val geozones: List<Geozone>,
    @SerializedName("id")
    val id: String,
    @SerializedName("max_weight")
    val maxWeight: Int,
    @SerializedName("min_weight")
    val minWeight: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("service_type")
    val serviceType: ServiceType,
    @SerializedName("supplementary_conditions")
    val supplementaryConditions: List<SupplementaryCondition>
)