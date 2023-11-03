package com.example.munchkin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.munchkin.databinding.ActivityUsuarioBinding
import com.example.munchkin.services.models.Usuario
import com.example.munchkin.viewmodel.UsuarioViewModel

class UsuarioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsuarioBinding
    private lateinit var usuarioViewModel : UsuarioViewModel
    private lateinit var usuarioFromDB : Usuario
    private var idUsuario = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        idUsuario = intent.getIntExtra("idUsuario", idUsuario)
        usuarioViewModel.buscarUsuario(idUsuario)
        setObservers()

        binding.btnMenosNivel.setOnClickListener {
            if(binding.txtNivel.text.toString().toInt() > 0){
                binding.txtNivel.text = usuarioViewModel
                    .menosAtributo(binding.txtNivel.text.toString().toInt())

                binding.txtForca.text = usuarioViewModel
                    .setForca(binding.txtNivel.text.toString().toInt(),
                        binding.txtEquip.text.toString().toInt(),
                        binding.txtMod.text.toString().toInt())
            }
        }

        binding.btnMaisNivel.setOnClickListener {
            binding.txtNivel.text = usuarioViewModel
                .maisAtributo(binding.txtNivel.text.toString().toInt())

            binding.txtForca.text = usuarioViewModel
                .setForca(binding.txtNivel.text.toString().toInt(),
                    binding.txtEquip.text.toString().toInt(),
                    binding.txtMod.text.toString().toInt())
        }

        binding.btnMenosEquip.setOnClickListener {
            if(binding.txtEquip.text.toString().toInt() > 0){
                binding.txtEquip.text = usuarioViewModel
                    .menosAtributo(binding.txtEquip.text.toString().toInt())
            }

            binding.txtForca.text = usuarioViewModel
                .setForca(binding.txtNivel.text.toString().toInt(),
                    binding.txtEquip.text.toString().toInt(),
                    binding.txtMod.text.toString().toInt())
        }

        binding.btnMaisEquip.setOnClickListener {
            binding.txtEquip.text = usuarioViewModel
                .maisAtributo(binding.txtEquip.text.toString().toInt())

            binding.txtForca.text = usuarioViewModel
                .setForca(binding.txtNivel.text.toString().toInt(),
                    binding.txtEquip.text.toString().toInt(),
                    binding.txtMod.text.toString().toInt())
        }

        binding.btnMenosMod.setOnClickListener {
                binding.txtMod.text = usuarioViewModel
                    .menosAtributo(binding.txtMod.text.toString().toInt())

            binding.txtForca.text = usuarioViewModel
                .setForca(binding.txtNivel.text.toString().toInt(),
                    binding.txtEquip.text.toString().toInt(),
                    binding.txtMod.text.toString().toInt())
        }

        binding.btnMaisMod.setOnClickListener {
            binding.txtMod.text = usuarioViewModel
                .maisAtributo(binding.txtMod.text.toString().toInt())

            binding.txtForca.text = usuarioViewModel
                .setForca(binding.txtNivel.text.toString().toInt(),
                    binding.txtEquip.text.toString().toInt(),
                    binding.txtMod.text.toString().toInt())
        }

        binding.btnAtualizar.setOnClickListener {
            usuarioFromDB.nivel = binding.txtNivel.text.toString().toInt()
            usuarioFromDB.equip = binding.txtEquip.text.toString().toInt()
            usuarioFromDB.mod = binding.txtMod.text.toString().toInt()
            usuarioFromDB.forca = binding.txtForca.text.toString().toInt()

            if(usuarioViewModel.atualizarUsuario(usuarioFromDB)){
                finish()
            }
        }

    }

    private fun setObservers(){
        usuarioViewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        usuarioViewModel.getUsuarioFromDB().observe(this){
            usuarioFromDB = it
            binding.txtForca.text = usuarioFromDB.forca.toString()
            binding.txtNivel.text = usuarioFromDB.nivel.toString()
            binding.txtEquip.text = usuarioFromDB.equip.toString()
            binding.txtMod.text = usuarioFromDB.mod.toString()
        }
    }
}