package data


import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("order_statistics")
    val orderStatistics: OrderStatistics
)