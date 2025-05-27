package com.example.teste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teste.ui.theme.TesteTheme
import java.time.LocalDate
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import android.graphics.Color
import android.widget.TextView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.tela_inicial)

        val pieChart = findViewById<PieChart>(R.id.pieChart)

        val registrosFake = listOf(
            RegistroFinanceiro(
                nome = "Salário",
                valor = 3000.0,
                categoria = "Renda",
                imagemResId = R.drawable.payments_24px,
                recorrente = true,
                data = LocalDate.of(2025, 4, 10),
                observacao = "Transferência bancária",
                tipo = Tipo.ENTRADA
            ),
            RegistroFinanceiro(
                nome = "Mercado",
                valor = 250.75,
                categoria = "Alimentação",
                imagemResId = R.drawable.payments_24px,
                recorrente = false,
                data = LocalDate.now(),
                observacao = null,
                tipo = Tipo.SAIDA
            ),
            RegistroFinanceiro(
                nome = "Mercado",
                valor = 20.55,
                categoria = "Alimentação",
                imagemResId = R.drawable.payments_24px,
                recorrente = false,
                data = LocalDate.now(),
                observacao = null,
                tipo = Tipo.SAIDA
            ),
            RegistroFinanceiro(
                nome = "Água",
                valor = 100.12,
                categoria = "Casa",
                imagemResId = R.drawable.payments_24px,
                recorrente = false,
                data = LocalDate.now(),
                observacao = null,
                tipo = Tipo.SAIDA
            )
        )

        //Parte 2

        val saldoTextView = findViewById<TextView>(R.id.saldoTotal)

        val totalEntradas = registrosFake
            .filter { it.tipo == Tipo.ENTRADA }
            .sumOf { it.valor }

        val totalSaidas = registrosFake
            .filter { it.tipo == Tipo.SAIDA }
            .sumOf { it.valor }

        val saldoTotal = totalEntradas - totalSaidas

        val saldo = getString(R.string.saldo)
        val saldoFormatado = getString(R.string.saldo_formatado, saldoTotal)
        val titulo = "$saldo\n$saldoFormatado"

        saldoTextView.text = titulo

        //Parte 1

        val saidas = registrosFake.filter { it.tipo == Tipo.SAIDA }

        val entradasPie = saidas
            .groupBy { it.categoria }
            .map { (categoria, lista) ->
                PieEntry(lista.sumOf { it.valor }.toFloat(), categoria)
            }

        if (entradasPie.isNotEmpty()) {
            val dataSet = PieDataSet(entradasPie, "")
            dataSet.setColors(
                Color.rgb(66, 133, 244),
                Color.rgb(219, 68, 55),
                Color.rgb(244, 180, 0),
                Color.rgb(15, 157, 88)
            )
            dataSet.valueTextColor = Color.WHITE
            dataSet.valueTextSize = 14f

            val pieData = PieData(dataSet)

            pieChart.data = pieData
            pieChart.isDrawHoleEnabled = true
            pieChart.holeRadius = 60f
            pieChart.setHoleColor(Color.TRANSPARENT)
            pieChart.transparentCircleRadius = 0f
            pieChart.setUsePercentValues(true)
            pieChart.setCenterTextSize(18f)
            pieChart.description.isEnabled = false
            pieChart.invalidate() // renderiza
        } else {
            pieChart.setNoDataText("Nenhuma saída registrada.")
        }

    }
}