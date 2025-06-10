package com.example.financas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "financas")
data class Financa(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val valor: Double,
    val data: String, // formato: "10/06/2025"
    val recorrente: Boolean
)
