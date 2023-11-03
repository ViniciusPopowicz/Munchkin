package com.example.munchkin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.munchkin.services.models.Usuario
import com.example.munchkin.services.models.UsuarioModel
import com.example.munchkin.services.repository.UsuarioRepository

class CadastroViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = UsuarioRepository(application.applicationContext)
    private var txtToast = MutableLiveData<String>()
    private var validacao = UsuarioModel()

    fun getTxtToast() : LiveData<String>{
        return txtToast
    }

    fun salvarUsuario(nome : String, equip : String, mod : String) : Boolean {
        if(repository.listarUsuarios().size >= 6){
            txtToast.value = "Número máximo de usuários atingido"
            return false
        }
        if(validacao.camposVazios(nome, equip, mod)){
            txtToast.value = "Preencha todos os campos"
            return false
        }

        var forca = validacao.calculaForca(1, equip.toInt(), mod.toInt())
        var usuario = Usuario(0, nome, forca, 1, equip.toInt(), mod.toInt())

        if (repository.salvarUsuario(usuario)){
            txtToast.value = "Usuario cadastrado"
            return true
        }

        txtToast.value = "Erro ao salvar"
        return false
    }
}