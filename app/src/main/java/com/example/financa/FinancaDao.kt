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
}
