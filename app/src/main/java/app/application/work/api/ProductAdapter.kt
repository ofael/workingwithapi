package app.application.work.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.application.work.api.model.Products
import com.bumptech.glide.Glide

class ProductAdapter(
    private val context: Context,
    private val productList : List<Products>
    ) : RecyclerView.Adapter<ProductViewHolder>(){
    //= ProductViewHolder(Instanciando Layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent,false))

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //passando o list da posição atual para uma variavel item
        val item = productList[position]
        holder.productName.text = item.prName
        holder.productPrice.text = item.prPrice

        //auxilia no carregamento de img, carrega a imagem em background.
        Glide.with(context).load(item.prImage).into(holder.productImage)
    }
}
//instanciando os ids
class ProductViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val productImage : ImageView = itemView.findViewById(R.id.prod_image)
    val productName : TextView = itemView.findViewById(R.id.product_name)
    val productPrice : TextView = itemView.findViewById(R.id.product_price)
}
