package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recupear os componetes EditText
        //criar uma variavel e associar ao componente de UI<editText>
        //recuperar bottun da tela
        //coloar acao no button
        //recuperar texto digitado no peso


        val edt_peso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edt_altura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        val pesoIN  = edt_peso.text.toString()
        val alturaIN = edt_altura.text.toString()

        btn_calcular.setOnClickListener {
            if(pesoIN == " " || alturaIN == " "){
                Snackbar.make(edt_altura,"Prencha todos os campos", Snackbar.LENGTH_LONG).show()


            }else{
                val peso : Float = edt_peso.text.toString().toFloat()
                val altura : Float = edt_altura.text.toString().toFloat()
                val media: Float = peso / (altura * altura)

                val AintecaoDeTrocarDeTela = Intent(this, ResultActivity::class.java)

                AintecaoDeTrocarDeTela.putExtra(KEY_RESULT_IMC, media)

                startActivity(AintecaoDeTrocarDeTela)

            }
        }
    }
}