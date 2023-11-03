package com.example.munchkin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.munchkin.databinding.ActivityMainBinding
import com.example.munchkin.view.adapter.UsuarioAdapter
import com.example.munchkin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: UsuarioAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UsuarioAdapter(this)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.rcvUsuario.layoutManager = LinearLayoutManager(this)

        setAdapter()
        setObservers()

        binding.btnNovoUsuario.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }

    private fun setObservers(){
        mainViewModel.listarUsuarios().observe(this){
            adapter.atualizarUsuarios(it)
        }

        mainViewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAdapter(){
        binding.rcvUsuario.adapter = adapter

        adapter.onItemLongClick = {
            var usuarioTemp = adapter.listaUsuario[it]
            mainViewModel.deletarUsuario(usuarioTemp)
            mainViewModel.getUsuariosFromDB()
        }

        adapter.onItemClick = {
            var usuarioTemp = adapter.listaUsuario[it]
            var intent = Intent(this, UsuarioActivity::class.java)
                .putExtra("idUsuario", usuarioTemp.id)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getUsuariosFromDB()
    }
}