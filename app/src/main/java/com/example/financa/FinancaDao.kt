package com.example.financas.data

import androidx.room.*

@Dao
interface FinancaDao {
    @Insert
    suspend fun inserir(financa: Financa)

    @Query("SELECT * FROM financas")
    suspend fun listarTodas(): List<Financa>

    @Update
    suspend fun atualizar(financa: Financa)

    @Delete
    suspend fun deletar(financa: Financa)

    @Query("UPDATE financas SET valor = :novoValor, data = :novaData, recorrente = :novoRecorrente WHERE nome = :nome")
    suspend fun atualizarPorNome(
        nome: String,
        novoValor: Double,
        novaData: String,
        novoRecorrente: Boolean
    )

    @Query("DELETE FROM financas WHERE nome = :nome")
    suspend fun deletarPorNome(nome: String)
}
