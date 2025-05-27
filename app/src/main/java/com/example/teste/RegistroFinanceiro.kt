package com.example.teste

import java.time.LocalDate

data class RegistroFinanceiro(
    val nome: String,
    val valor: Double,
    val categoria: String,
    val imagemResId: Int,
    val recorrente: Boolean,
    val data: LocalDate,
    val observacao: String?,
    val tipo: Tipo
)

enum class Tipo {
    ENTRADA, SAIDA
}
