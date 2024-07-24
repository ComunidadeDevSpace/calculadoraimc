package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvresult = findViewById<TextView>(R.id.tv_result)
        val tvclassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvresult.text = result.toString()

        val (classification: String, color: Int) = when {
            result <= 18.5f -> {
                "MAGRO" to R.color.MAGRO
            }

            result > 18.5f && result <= 24.9f -> {
                "NORMAL" to R.color.NORMAL
            }

            result > 25f && result <= 29.9f -> {
                "SOBREPESO" to R.color.SOBREPESO
            }


            result > 30f && result <= 39.9f -> {
                "OBESIDADE" to R.color.OBESIDADE
            }

            else -> {
                "OBESIDADE GRAVE" to R.color.OBESIDADE_GRAVE
            }

        }

        tvclassificacao.setTextColor(ContextCompat.getColor(this, color))
        tvclassificacao.text = classification

    }}
































