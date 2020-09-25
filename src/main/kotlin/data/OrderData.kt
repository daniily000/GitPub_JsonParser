package data


import com.google.gson.annotations.SerializedName

data class OrderData(
    @SerializedName("timeslot")
    val timeslot: Timeslot,
    @SerializedName("weight")
    val weight: Int
)