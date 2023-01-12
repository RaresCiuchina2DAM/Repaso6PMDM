package com.example.repasolisteners6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasolisteners6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Tenga un botón "Comenzar", cuando se pulsa deben aparecer un editText en el que el usuario debe introducir su nombre.
        // Una vez pulsado, el texto del botón se cambia a: "Finalizar". Si el usuario pulsa el botón otra vez, entonces el
        // editText desaparece.

        binding.btnn.setOnClickListener {
            binding.textView.visibility = android.view.View.INVISIBLE
            binding.nombre.visibility = android.view.View.INVISIBLE
            if (binding.btnn.text == "Comenzar") {
                binding.nombre.visibility = android.view.View.VISIBLE
                binding.btnn.text = "Finalizar"
            } else {
                binding.nombre.visibility = android.view.View.INVISIBLE
                binding.btnn.text = "Comenzar"
            }
        }

        //Si el usuario no ha escrito nada, el editText debe mostrar: "Introduce tu nombre".
        // Cuando el usuario pulsa en el editText, el texto se borra y permite la introducción de texto.
        // Si el usuario no ha escrito nada y quita el focus, entonces "Introduce tu nombre" se vuelve a mostrar.

        binding.nombre.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.nombre.setText("")
            } else {
                if (binding.nombre.text.isEmpty()) {
                    binding.nombre.hint = "Introduce tu nombre"
                }
            }
        }

        //Si el nombre del usuario contiene el texto Wayne, entonces debe aparecer una imagen con el logo de batman.
        // Si el texto contiene la palabra Joker entonces los colores de la app deben cambiar, background, color de la letras,
        // etc.

        binding.nombre.setOnKeyListener { _, _, _ ->
            if (binding.nombre.text.contains("Wayne")) {
                binding.textView.visibility = android.view.View.VISIBLE
            } else {
                binding.textView.visibility = android.view.View.INVISIBLE
            }
            if (binding.nombre.text.contains("Joker")) {
                binding.root.setBackgroundColor(android.graphics.Color.BLACK)
                binding.nombre.setTextColor(android.graphics.Color.WHITE)
                binding.btnn.setTextColor(android.graphics.Color.WHITE)
            } else {
                binding.root.setBackgroundColor(android.graphics.Color.WHITE)
                binding.nombre.setTextColor(android.graphics.Color.BLACK)
                binding.btnn.setTextColor(android.graphics.Color.BLACK)
            }
            false
        }

    }
}