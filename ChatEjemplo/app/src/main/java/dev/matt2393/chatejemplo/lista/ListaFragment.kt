package dev.matt2393.chatejemplo.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.matt2393.chatejemplo.databinding.FragmentListaBinding

class ListaFragment: Fragment() {

    private var adapter: ListaAdapter? = null
    private lateinit var binding: FragmentListaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        adapter = ListaAdapter()
        binding.recyclerLista.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerLista.adapter = adapter

        return binding.root
    }
}