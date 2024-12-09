package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


const val  KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classificacao: String
        val cor: Int
        when {
            result <= 18.5f -> {
                classificacao = "MAGREZA"
                cor = Color.BLUE
            }
            result in 18.6f..24.9f -> {
                classificacao = "NORMAL"
                cor = Color.GREEN
            }
            result in 25f..29.9f -> {
                classificacao = "SOBREPESO"
                cor = Color.YELLOW
            }
            result in 30f..39.9f -> {
                classificacao = "OBESIDADE"
                cor = Color.parseColor("#FFA500")
            }
            else -> {
                classificacao = "OBESIDADE GRAVE"
                cor = Color.RED
            }
        }

        tvClassificacao.text= classificacao
        tvClassificacao.setTextColor(cor)



    }
}