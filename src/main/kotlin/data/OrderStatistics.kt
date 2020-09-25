package data


import com.google.gson.annotations.SerializedName

data class OrderStatistics(
    @SerializedName("orders_assigned_overall")
    val ordersAssignedOverall: Int,
    @SerializedName("orders_cancelled")
    val ordersCancelled: Int,
    @SerializedName("orders_cancelled_by_client")
    val ordersCancelledByClient: Int,
    @SerializedName("orders_completed")
    val ordersCompleted: Int,
    @SerializedName("orders_failed_to_complete")
    val ordersFailedToComplete: Int
)