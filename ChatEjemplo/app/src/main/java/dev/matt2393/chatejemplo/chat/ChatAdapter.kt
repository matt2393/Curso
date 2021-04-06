package dev.matt2393.chatejemplo.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.matt2393.chatejemplo.Model.Entitys.Chat
import dev.matt2393.chatejemplo.R
import dev.matt2393.chatejemplo.databinding.ItemMessEmisorBinding
import dev.matt2393.chatejemplo.databinding.ItemMessReceptorBinding

class ChatAdapter(var arrayChat: ArrayList<Chat> = arrayListOf(), var uid: String): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ChatEmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMessEmisorBinding.bind(itemView)
    }
    inner class ChatReViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemMessReceptorBinding.bind(itemView)
    }

    private val EMISOR = 1
    private val RECEPTOR = 2
    override fun getItemViewType(position: Int): Int {
        val chat = arrayChat[position]
        return if(chat.uidEmisor == uid) { EMISOR } else { RECEPTOR }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if(viewType ==  EMISOR) {
            ChatEmViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mess_emisor, parent, false)
            )
        } else {
            ChatReViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mess_receptor, parent, false)
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ChatEmViewHolder -> {
                //holder.binding.textHoraItemEmisor.text = "dasdsad"
            }
            is ChatReViewHolder -> {
                //holder.binding.textHoraItemReceptor.text = "dasdsad"
            }
        }
    }

    override fun getItemCount(): Int = arrayChat.size
}