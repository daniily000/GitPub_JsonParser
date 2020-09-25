package data


import com.google.gson.annotations.SerializedName

data class Timeslot(
    @SerializedName("date")
    val date: String,
    @SerializedName("from")
    val from: String,
    @SerializedName("to")
    val to: String
)