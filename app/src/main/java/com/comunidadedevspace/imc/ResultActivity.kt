package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

//minha chave para o intent
const val KEY_RESULT_IMC = "Resultado.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 1f )

        val bloco1 = findViewById<TextView>(R.id.bloco_1)
        bloco1.text = result.toString()

        val bloco2 = findViewById<TextView>(R.id.bloco_2)
        bloco2.text = "A classificacao do seu IMC é: "

        val bloco3 = findViewById<TextView>(R.id.bloco_3)

        val classificacao = if(result <= 18.5f){
            "MAGREZA"
        }else if(result > 18.5f && result <= 24.9f){
            "NORMAL"
        }else if (result > 24.9f && result <= 29.9f){
            "SOBREPESO"
        }else if(result > 29.9f && result <= 34.9f){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }

        bloco3.text = classificacao

    }
}