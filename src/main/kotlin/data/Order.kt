package data


import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("index")
    val index: Int,
    @SerializedName("order")
    val order: OrderX
)