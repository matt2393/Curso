package dev.matt2393.chatejemplo.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.matt2393.chatejemplo.R
import dev.matt2393.chatejemplo.databinding.ItemListaBinding

class ListaAdapter: RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {
    inner class ListaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemListaBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder =
        ListaViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_lista, parent, false)
        )

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 10
}