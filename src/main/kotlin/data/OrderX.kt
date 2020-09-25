package data


import com.google.gson.annotations.SerializedName

data class OrderX(
    @SerializedName("id")
    val id: String,
    @SerializedName("order_data")
    val orderData: OrderData,
    @SerializedName("service")
    val service: ServiceX
)