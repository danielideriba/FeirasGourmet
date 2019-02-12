package br.com.feira.gourmet

import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView


/**
 * Created by danielideriba on 11,February,2019
 */

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var productImage: ImageView
    var productName: TextView

    init {
        productImage = itemView.findViewById(R.id.product_image) as ImageView
        productName = itemView.findViewById(R.id.product_name)
    }
}