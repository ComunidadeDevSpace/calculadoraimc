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


        //Recuperar os valores digitados pelo usuário na EditText
        //Criar variavel e associar o componente de UI<textInputEditText>

        val edtPeso: TextInputEditText = findViewById(R.id.edit_peso)
        val edtAltura: TextInputEditText = findViewById(R.id.edit_altura)

        val btnCalcular: Button = findViewById(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val stringPeso: String = edtPeso.text.toString()
            val stringAltura: String = edtAltura.text.toString()

            if (stringPeso == "" || stringAltura == "") {
                // Mostrar messagem para usuario
                Snackbar.make(
                    btnCalcular,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                //Recuperar os valores digitados pelo usuário na EditText
                val peso = stringPeso.toFloat()
                val altura = stringAltura.toFloat()


                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                //Navegar para Proxima Tela
                //Criar Layout
                //Passar dados de uma tela para outra

                // Intent Explícita

                val intent= Intent(this, ResultActivity::class.java)
                //Passar dados (usamos o putExtra, e deve ter uma chave)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)


            }


        }

    }


}