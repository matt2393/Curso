package dev.matt2393.ejemplorecycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.matt2393.ejemplorecycler.databinding.ItemMainBinding

class MainAdapter(var arrayProds: ArrayList<Producto> = arrayListOf()): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    /**
     * Array parelelo para mantener datos de check
     * (no necesario si el modelo producto tiene ya un datos para esto
     */
    private var arrayCheck = arrayListOf<Boolean>()

    init {
        /**
         * forEach recorre todo el array del principio al fin
         */
        arrayProds.forEach {
            /**
             * adiciona un "false" paralelo por cada producto
             */
            arrayCheck.add(false)
        }
    }

    /**
     * cambia todos los datos del array productos
     * y tambien añade el array paralelo de checks
     * (si se usa esta forma, se debe usar estsa funcion para
     * cambiar datos)
     */
    fun setProds(array: ArrayList<Producto>) {
        arrayProds = array
        arrayCheck.clear()
        arrayProds.forEach {
            arrayCheck.add(false)
        }
    }


    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemMainBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main, parent, false)
        )

    /**
     * funcion se ejecuta varias veces, no declarar variables locales dentro
     * si se desea consistencia de datos durante la ejecucion
     * este funcion cambia de valores constantemente
     */
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val prod = arrayProds[position]
        var check = arrayCheck[position]
        holder.binding.textMain.text = prod.nombre

        /**
         * para cambiar el color o estado de un item
         * en caso de scroll y evitar que el reciclaje de vistas
         * cambie o no los colores o estados del item
         */
        if(check){
            holder.binding.cardMain.setCardBackgroundColor(Color.CYAN)
        }else {
            holder.binding.cardMain.setCardBackgroundColor(Color.WHITE)
        }



        holder.binding.cardMain.setOnLongClickListener {
          /*
            if(prod.isCheck) {
                holder.binding.cardMain.setCardBackgroundColor(Color.CYAN)
            }else{
                holder.binding.cardMain.setCardBackgroundColor(Color.WHITE)
            }
            prod.isCheck = !prod.isCheck
            arrayProds[position] = prod
            */
            /**
             * cambia color y estado del item
             */
            holder.binding.cardMain.setCardBackgroundColor(Color.CYAN)

            check = true
            arrayCheck[position] = check

            true
        }
        holder.binding.cardMain.setOnClickListener {
            /**
             * cambia color y estado del item
             */
            holder.binding.cardMain.setCardBackgroundColor(Color.WHITE)
            check = false
            arrayCheck[position] = check
        }

    }

    override fun getItemCount(): Int = arrayProds.size
}