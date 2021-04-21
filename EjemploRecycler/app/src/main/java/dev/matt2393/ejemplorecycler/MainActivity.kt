package dev.matt2393.ejemplorecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.matt2393.ejemplorecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var adapter: MainAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val array = arrayListOf(
            Producto("Pepsi"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),
            Producto("Cocacola"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),
            Producto("Pepsi"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),
            Producto("Pepsi"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),
            Producto("Pepsi"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),Producto("Pepsi"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),
            Producto("Pepsi"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),
            Producto("Pepsi"),
            Producto("Fideos"),
            Producto("Azucar"),
            Producto("helados"),

        )

        adapter = MainAdapter(array)

        binding.recyclerMain.layoutManager = LinearLayoutManager(this)
        binding.recyclerMain.adapter = adapter

    }

    fun observer(array: ArrayList<Producto>) {
        adapter?.setProds(array)
    }
}