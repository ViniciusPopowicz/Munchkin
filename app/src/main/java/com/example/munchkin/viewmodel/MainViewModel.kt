package com.example.munchkin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.munchkin.services.models.Usuario
import com.example.munchkin.services.repository.UsuarioRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var listaUsuarios = MutableLiveData<List<Usuario>>()
    private var repository = UsuarioRepository(application.applicationContext)
    private var txtToast = MutableLiveData<String>()

    fun listarUsuarios() : LiveData<List<Usuario>>{
        return listaUsuarios
    }

    fun getTxtToast() : LiveData<String>{
        return txtToast
    }

    fun getUsuariosFromDB(){
        listaUsuarios.value = repository.listarUsuarios()
    }

    fun deletarUsuario(usuario: Usuario){
        repository.deletarUsuario(usuario)
        txtToast.value = "Usuario excluido com sucesso"
    }
}