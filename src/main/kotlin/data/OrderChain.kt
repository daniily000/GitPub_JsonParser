package data


import com.google.gson.annotations.SerializedName

data class OrderChain(
    @SerializedName("id")
    val id: String,
    @SerializedName("orders")
    val orders: List<Order>
)