package com.example.jorgecarrillo.paciente_medicina

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Button
import android.widget.TextView

class LibroAdapter(private val librosList: List<Medicina>) : RecyclerView.Adapter<LibroAdapter.MyViewHolder>() {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {
        var nombre: TextView
        var fechaCaducidad: TextView
        var composicion: TextView
        var usadaPara: Button
        lateinit var medicina: Medicina

        init {
            nombre = view.findViewById(R.id.text) as TextView
            fechaCaducidad = view.findViewById(R.id.txt_2) as TextView
            composicion = view.findViewById(R.id.txt_3) as TextView
            usadaPara = view.findViewById(R.id.btn_1)as Button
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            menu?.add(Menu.NONE, R.id.item_menu_compartir1, Menu.NONE, R.string.menu_share)
            menu?.add(Menu.NONE, R.id.item_menu_editar, Menu.NONE, R.string.menu_edit)
            menu?.add(Menu.NONE, R.id.item_menu_borrar, Menu.NONE, R.string.menu_delete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_layout, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val medicinas = librosList[position]
        holder.nombre.text = medicinas.nombre
        holder.fechaCaducidad.text = medicinas.fechaCaducidad
        holder.composicion.text = medicinas.composicion
        holder.medicina = medicinas
        holder.usadaPara.setOnClickListener{
            v: View ->
            val intent = Intent(v.context, DetailsMedicinaActivity::class.java)
            intent.putExtra("medicina", medicinas)
            v.context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {
            setPosition(holder.adapterPosition)
            false
        }
    }

    override fun getItemCount(): Int {
        return librosList.size
    }

}