package com.example.financas.data  // ajuste para seu pacote

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FinancaRepository(private val dao: FinancaDao) {

    suspend fun inserir(financa: Financa) = withContext(Dispatchers.IO) {
        dao.inserir(financa)
    }

    suspend fun listar(): List<Financa> = withContext(Dispatchers.IO) {
        dao.listarTodas()
    }

    suspend fun atualizar(financa: Financa) = withContext(Dispatchers.IO) {
        dao.atualizar(financa)
    }

    suspend fun deletar(financa: Financa) = withContext(Dispatchers.IO) {
        dao.deletar(financa)
    }
    suspend fun atualizarPorNome(
        nome: String,
        novoValor: Double,
        novaData: String,
        novoRecorrente: Boolean
    ) {
        dao.atualizarPorNome(nome, novoValor, novaData, novoRecorrente)
    }

    suspend fun deletarPorNome(nome: String) {
        dao.deletarPorNome(nome)
    }
}