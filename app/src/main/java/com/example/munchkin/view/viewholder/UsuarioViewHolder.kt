package com.example.munchkin.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.munchkin.R

class UsuarioViewHolder(usuarioLayout : View) : RecyclerView.ViewHolder(usuarioLayout) {
    var txtDadosUsuario = usuarioLayout.findViewById<TextView>(R.id.txtDadosUsuario)
}