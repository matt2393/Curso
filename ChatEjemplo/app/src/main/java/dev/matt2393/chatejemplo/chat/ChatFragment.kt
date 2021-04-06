package dev.matt2393.chatejemplo.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.matt2393.chatejemplo.Model.Entitys.Chat
import dev.matt2393.chatejemplo.databinding.FragmentChatBinding

class ChatFragment: Fragment() {

    private var adapter: ChatAdapter? = null
    private lateinit var binding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        val arrayChat = arrayListOf(
            Chat("matt"),
            Chat("222"),
            Chat("matt"),
            Chat("222"),
            Chat("222"),
            Chat("matt"),
            Chat("matt"),
            Chat("matt"),
            Chat("222"),
            Chat("222"),
        )
        adapter = ChatAdapter(arrayChat, "matt")
        binding.recyclerChat.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerChat.adapter = adapter


        return binding.root
    }
}