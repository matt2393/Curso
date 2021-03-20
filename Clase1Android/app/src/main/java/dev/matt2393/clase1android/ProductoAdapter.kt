package dev.matt2393.clase1android

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.matt2393.clase1android.databinding.ItemProductoBinding

class ProductoAdapter(var esAdmin: Boolean, var arrayChat: ArrayList<String>): RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>()  {
    inner class ProductoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemProductoBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder =
        ProductoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_producto, parent, false)
        )

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.binding.textItemProd.text = "dsadad"
        if(esAdmin) {
            holder.binding.textItemProd.setTextColor(Color.BLUE)
        } else {

        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onViewRecycled(holder: ProductoViewHolder) {

        super.onViewRecycled(holder)
    }
}