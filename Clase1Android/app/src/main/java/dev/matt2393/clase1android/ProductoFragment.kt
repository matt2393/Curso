package dev.matt2393.clase1android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.matt2393.clase1android.databinding.FragmentProductoBinding

class ProductoFragment: Fragment() {
    private lateinit var binding: FragmentProductoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductoBinding.inflate(inflater, container, false)
        binding.textProd.text = "dsada"
        return binding.root
    }
}