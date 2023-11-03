package com.example.munchkin.services.models

class UsuarioModel {
    fun camposVazios(nome : String, equip : String, mod : String) : Boolean{
        return nome.isEmpty() || equip.isEmpty() || mod.isEmpty()
    }

    fun calculaForca(nivel : Int, equip : Int, mod : Int) : Int{
        var forca = nivel + equip + mod
        return forca
    }
}