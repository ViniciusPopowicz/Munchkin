package com.example.munchkin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.munchkin.services.models.Usuario
import com.example.munchkin.services.models.UsuarioModel
import com.example.munchkin.services.repository.UsuarioRepository

class UsuarioViewModel(application: Application) : AndroidViewModel(application){

    private var repository = UsuarioRepository(application.applicationContext)
    private var txtToast = MutableLiveData<String>()
    private var usuarioFromDB = MutableLiveData<Usuario>()
    private var validacao = UsuarioModel()

    /*private var nivel = MutableLiveData<Int>()
    private var equip = MutableLiveData<Int>()
    private var mod = MutableLiveData<Int>()
    private var forca = MutableLiveData<Int>()*/

    fun getUsuarioFromDB() : LiveData<Usuario> {
        return usuarioFromDB
    }

    fun getTxtToast() : LiveData<String> {
        return txtToast
    }

    fun atualizarUsuario(usuario: Usuario) : Boolean{
        repository.atualizarUsuario(usuario)
        txtToast.value = "Usuário atualizado"
        return true
    }
    fun buscarUsuario(id : Int){
        usuarioFromDB.value = repository.listarUsuario(id)
    }

    fun maisAtributo(atr : Int) : String{
        var resultado = atr + 1
        return resultado.toString()
    }

    fun menosAtributo(atr : Int) : String{
        var resultado = atr - 1
        return resultado.toString()
    }

    fun setForca(nivel : Int, equip : Int, mod : Int) : String{
        var forca = validacao.calculaForca(nivel, equip, mod)
        return forca.toString()
    }
}