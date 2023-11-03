package com.example.munchkin.services.repository

import androidx.room.*
import com.example.munchkin.services.models.Usuario

@Dao
interface UsuarioDAO {

    @Insert
    fun salvarUsuario(usuario : Usuario) : Long

    @Delete
    fun deletarUsuario(usuario: Usuario)

    @Update
    fun atualizarUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun listarUsuario(id : Int) : Usuario

    @Query("SELECT * FROM usuarios")
    fun listarUsuarios() : List<Usuario>
}