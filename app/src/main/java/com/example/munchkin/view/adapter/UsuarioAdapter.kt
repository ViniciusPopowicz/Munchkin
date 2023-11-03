package com.example.munchkin.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.munchkin.R
import com.example.munchkin.services.models.Usuario
import com.example.munchkin.view.viewholder.UsuarioViewHolder

class UsuarioAdapter(var context: Context) : RecyclerView.Adapter<UsuarioViewHolder>() {

    lateinit var listaUsuario : List<Usuario>
    var onItemClick: ((Int) -> Unit)?=null
    var onItemLongClick: ((Int) -> Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val usuarioLayout = LayoutInflater.from(context).inflate(R.layout.usuario_layout, parent, false)
        var holder = UsuarioViewHolder(usuarioLayout)
        return holder
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.txtDadosUsuario.text = listaUsuario[position].nome

        holder.itemView.setOnLongClickListener {
            onItemLongClick?.invoke(position)
            true
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
            true
        }
    }

    override fun getItemCount(): Int {
        return listaUsuario.size
    }

    fun atualizarUsuarios(lista : List<Usuario>){
        listaUsuario = lista
        notifyDataSetChanged()
    }
}