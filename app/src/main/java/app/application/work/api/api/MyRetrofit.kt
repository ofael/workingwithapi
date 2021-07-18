package app.application.work.api.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyRetrofit {
    private val retrofit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    //instanciando o products api
    fun productApi() : ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }

    companion object{
        private const val BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/"

        var myRetrofit : MyRetrofit? = null

        @get:Synchronized
        val instance : MyRetrofit?
        get(){
            if(myRetrofit == null){
                myRetrofit = MyRetrofit()
            }
            return myRetrofit
        }
    }

    init {
        //inicializando a variavel, retorno em gson e converter para classe product, depois um build para instanciar
    }
}