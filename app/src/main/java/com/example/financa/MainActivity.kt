package com.example.financa

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.financas.data.AppDatabase
import com.example.financas.data.FinancaDao
import com.example.financas.data.Financa
import com.example.financas.data.FinancaRepository
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var dao: FinancaDao
    private lateinit var repository: FinancaRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "financa.db"
        ).build()
        dao = db.financaDao()
        repository = FinancaRepository(db.financaDao())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }}

/*
        REGISTRAR NOVA FINANÇA PADRÃO*********************************************
        lifecycleScope.launch {
            val novaFinanca = Financa(
                nome = "Netflix",
                valor = 50.00,
                data = "30/12/2025",
                recorrente = true
            )
            repository.inserir(novaFinanca)
        }
        LER TODAS AS FINANÇAS***************************************************
        lifecycleScope.launch {
            val todasFinancas = repository.listar()
        }
        DELETAR*****************************************************
         lifecycleScope.launch {
            repository.deletarPorNome("Disney+")
            }


         ATUALIZAR************************************************

        lifecycleScope.launch {
            // Atualizar uma financa com nome "Spotify"
            repository.atualizarPorNome(
                nome = "Netflix",
                novoValor = 35000.00,
                novaData = "05/01/2026",
                novoRecorrente = false
            )

        }
        MOSTRAR TODAS AS FINANÇAS NO LOGCAT*****************************************************************
                lifecycleScope.launch {
            val todasFinancas = repository.listar()

            todasFinancas.forEach { financa ->
                Log.d(
                    "FinancaLog",
                    "ID: ${financa.id}, Nome: ${financa.nome}, Valor: R$${financa.valor}, " +
                            "Data: ${financa.data}, Recorrente: ${financa.recorrente}"
                )
            }
        }




        */