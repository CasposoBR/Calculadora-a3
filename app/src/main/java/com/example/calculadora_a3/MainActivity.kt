package com.example.calculadora_a3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora_a3.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        //criando e importando os bindings dos gradles para cá, agora é inserir aqui
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calculo = binding.calculo

        //Cada botão da calculadora, quando o usuario clicar nesse botão, ele vai exibir no texto acima
        binding.um.setOnClickListener{
           calculo.text = "${calculo.text}1"
        }
        binding.dois.setOnClickListener{
            calculo.text = "${calculo.text}2"
        }
        binding.tres.setOnClickListener{
            calculo.text = "${calculo.text}3"
        }
        binding.quatro.setOnClickListener{
            calculo.text = "${calculo.text}4"
        }
        binding.cinco.setOnClickListener{
            calculo.text = "${calculo.text}5"
        }
        binding.seis.setOnClickListener{
            calculo.text = "${calculo.text}6"
        }
        binding.sete.setOnClickListener{
            calculo.text = "${calculo.text}7"
        }
        binding.oito.setOnClickListener{
            calculo.text = "${calculo.text}8"
        }
        binding.nove.setOnClickListener{
            calculo.text = "${calculo.text}9"
        }
        binding.zero.setOnClickListener{
            calculo.text = "${calculo.text}0"
        }
        binding.C.setOnClickListener{
            calculo.text = "${calculo.text}C"
        }
        binding.parenteseAbrindo.setOnClickListener{
            calculo.text = "${calculo.text}("
        }
        binding.parenteseFechando.setOnClickListener{
            calculo.text = "${calculo.text})"
        }
        binding.divisao.setOnClickListener{
            calculo.text = "${calculo.text}/"
        }
        binding.multiplicacao.setOnClickListener{
            calculo.text = "${calculo.text}x"
        }
        binding.menos.setOnClickListener{
            calculo.text = "${calculo.text}-"
        }
        binding.mais.setOnClickListener{
            calculo.text = "${calculo.text}+"
        }
        binding.ponto.setOnClickListener{
            calculo.text = "${calculo.text},"
        }

        binding.apagar.setOnClickListener{
            calculo.text= calculo.text.dropLast(1)

        }
//botão C vai apagar tudo
binding.C.setOnClickListener{
    calculo.text= ("")
    binding.resultado.text = ""

}

binding.igual.setOnClickListener{
    val expressaoComPonto = binding.calculo.text.toString().replace(',','.') //substitui , pelo .
        .replace('x', '*')  // Substitui o 'x' por '*'


  val resultadoCalculado= Expression(expressaoComPonto).calculate()

  if (resultadoCalculado.isNaN()){
binding.resultado.text = "invalido!"
  }else{
      binding.resultado.text = resultadoCalculado.toString()

  }


}

    }
}