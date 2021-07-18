package app.application.work.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.application.work.api.api.MyRetrofit
import app.application.work.api.model.Products
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recycleProducts : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleProducts = findViewById(R.id.recycle_products)
        recycleProducts.layoutManager = LinearLayoutManager(this)
        getData()

    }

    private fun getData(){
        //variavel responsavel por se comunicar com o servidor
        val call : retrofit2.Call<List<Products>> =
            MyRetrofit.instance?.productApi()?.getProductsApi() as retrofit2.Call<List<Products>>

        //criando uma fila de requisição
        call.enqueue(object : retrofit2.Callback<List<Products>> {
            override fun onFailure(call: retrofit2.Call<List<Products>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: retrofit2.Call<List<Products>>,
                response: Response<List<Products>>
            ) {
                val adapter = ProductAdapter(this@MainActivity,response.body()?.toList() as List<Products>)
                recycleProducts.adapter = adapter
            }

        })
    }
}