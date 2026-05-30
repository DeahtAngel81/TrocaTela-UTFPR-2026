package com.marcioposgraduacao.trocatelamarcio

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCod: TextView
    private lateinit var tvQtd: TextView
    private lateinit var tvValor: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvCod = findViewById(R.id.tvCod)
        tvQtd = findViewById(R.id.tvQtd)
        tvValor = findViewById(R.id.tvValor)

        tvCod.text = intent.getStringExtra("cod")
        tvQtd.text = intent.getStringExtra("qtd")
        tvValor.text = intent.getStringExtra("valor")
    }


    fun btEnviarSMS(view: View) {
        val phone_dest = "5511972369091"
        val sms_body = "Codigo: ${tvCod.text} Quantidade: ${tvQtd.text} Valor: ${tvValor.text}"

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("sms:" + phone_dest))
        intent.putExtra("sms_body", sms_body)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)


            /* val smsBody = "Cod: ${tvCod.text}, Qtd: ${tvQtd.text}, Valor: ${tvValor.text}"
            val smsUri = Uri.parse("smsto:$phone_dest")
            val smsIntent = Intent(Intent.ACTION_SENDTO, smsUri).apply {
                putExtra("sms_body", smsBody)
            }

            startActivity(smsIntent)
*/
            /* val smsBody = "Cod: ${tvCod.text}, Qtd: ${tvQtd.text}, Valor: ${tvValor.text}"
        val smsUri = Uri.parse("smsto:$phone")
        val smsIntent = Intent(Intent.ACTION_SENDTO, smsUri).apply {
            putExtra("sms_body", smsBody)
        }
        startActivity(smsIntent)


        startActivity(smsIntent)

        }*/
        }
    }
}
