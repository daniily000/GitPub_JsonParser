package data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("contractors")
    val contractors: List<Contractor>,
    @SerializedName("geozones")
    val geozones: List<GeozoneX>,
    @SerializedName("order_chains")
    val orderChains: List<OrderChain>,
    @SerializedName("service_types")
    val serviceTypes: List<ServiceType>,
    @SerializedName("services")
    val services: List<ServiceXX>,
    @SerializedName("supplementary_conditions")
    val supplementaryConditions: List<SupplementaryCondition>
)