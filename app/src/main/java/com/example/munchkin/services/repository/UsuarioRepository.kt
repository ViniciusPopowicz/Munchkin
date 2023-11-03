package com.example.munchkin.services.repository

import android.content.Context
import androidx.room.Database
import com.example.munchkin.services.models.Usuario

class UsuarioRepository(var context : Context) {

    private val database = UsuarioDatabase.getInstance(context)
    private var DAO = database.getDAO()

    fun salvarUsuario(usuario: Usuario) : Boolean{
        return DAO.salvarUsuario(usuario) > 0
    }

    fun deletarUsuario(usuario: Usuario){
        DAO.deletarUsuario(usuario)
    }

    fun atualizarUsuario(usuario: Usuario){
        DAO.atualizarUsuario(usuario)
    }

    fun listarUsuario(id : Int) : Usuario{
        return DAO.listarUsuario(id)
    }

    fun listarUsuarios() : List<Usuario>{
        return DAO.listarUsuarios()
    }
}