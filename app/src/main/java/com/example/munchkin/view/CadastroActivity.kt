package com.example.munchkin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.munchkin.databinding.ActivityCadastroBinding
import com.example.munchkin.viewmodel.CadastroViewModel

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var cadastroViewModel : CadastroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cadastroViewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)
        setObservers()

        binding.btnSalvar.setOnClickListener {
            var nome = binding.edtNome.text.toString()
            var equip = binding.edtEquip.text.toString()
            var mod = binding.edtMod.text.toString()

            if(cadastroViewModel.salvarUsuario(nome, equip, mod)){
                finish()
            }
        }
    }

    private fun setObservers(){
        cadastroViewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}