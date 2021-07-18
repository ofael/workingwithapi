package app.application.work.api.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("id")
    val id : String,
    @SerializedName("prname")
    val prName : String,
    @SerializedName("primage")
    val prImage : String,
    @SerializedName("prprice")
    val prPrice : String
)