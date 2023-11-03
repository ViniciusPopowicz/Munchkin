package com.example.munchkin.services.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.munchkin.services.models.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDatabase : RoomDatabase() {
    abstract fun getDAO() : UsuarioDAO

    companion object{
        private lateinit var INSTANCE : UsuarioDatabase

        fun getInstance(context: Context) : UsuarioDatabase{
            if(!Companion::INSTANCE.isInitialized){
                INSTANCE = Room.databaseBuilder(context, UsuarioDatabase::class.java, "usuario_db")
                    .allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}