package com.example.munchkin.services.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @ColumnInfo @PrimaryKey(autoGenerate = true) var id : Int,
    @ColumnInfo var nome : String,
    @ColumnInfo var forca : Int,
    @ColumnInfo var nivel : Int,
    @ColumnInfo var equip : Int,
    @ColumnInfo var mod : Int
)