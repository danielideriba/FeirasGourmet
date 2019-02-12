package br.com.feira.gourmet

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup


/**
 * Created by danielideriba on 11,February,2019
 */

class ProductAdapter(private val context: Context, private val productList: List<ProductObject>) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_custom, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productObject = productList[position]
        val imageRes = getResourceId(context, productObject.imagePath, "drawable", context.getPackageName())
        holder.productImage.setImageResource(imageRes)
        holder.productName.setText(productObject.categoria)

        holder.productImage.tag = position

        holder.itemView.setOnClickListener {
            if(holder.layoutPosition == 0) {
                val intent = CategoriaActivity.newIntent(it!!.context)
                it!!.context.startActivity(intent)
            }
//            } else if(holder.layoutPosition == 1){
//                val intent = Ofertas.newIntent(it!!.context)
//                it!!.context.startActivity(intent)
//            } else if(holder.layoutPosition == 2){
//                val intent = Listas.newIntent(it!!.context)
//                it!!.context.startActivity(intent)
//            }
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    companion object {
        @Throws(RuntimeException::class)
        fun getResourceId(context: Context, pVariableName: String, pResourcename: String, pPackageName: String): Int {
            try {
                return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName)
            } catch (e: Exception) {
                throw RuntimeException("Error getting Resource ID.", e)
            }

        }
    }
}