package app.application.work.api.api

import app.application.work.api.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface ProductsApi {
    @GET("getdata.php")
    fun getProductsApi() : Call<List<Products>>
}