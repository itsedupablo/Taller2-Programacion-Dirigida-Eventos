package com.edupablo.taller1app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp  // Para definir el tamaño del texto
import com.edupablo.taller1app.ui.theme.Taller1AppTheme

class MainActivity : ComponentActivity() {
    private lateinit var configuracionLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var backgroundColor by mutableStateOf(Color.White)

        configuracionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val selectedColorInt = result.data?.getIntExtra("selectedColor", Color.White.toArgb())
                selectedColorInt?.let {
                    backgroundColor = Color(it)
                    saveColorInPreferences(backgroundColor)
                }
            }
        }

        setContent {
            Taller1AppTheme {
                var name by remember { mutableStateOf("") }
                var isNameSaved by remember { mutableStateOf(false) }
                var savedName by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .background(backgroundColor),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (!isNameSaved) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { newName -> name = newName },
                            label = { Text("Ingresa tu usuario") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(onClick = {
                            savedName = name
                            isNameSaved = true
                        }) {
                            Text("Guardar")
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                    } else {
                        // Texto "Bienvenid@ usuario" con tamaño más grande y en negrita
                        Text(
                            text = "Bienvenid@: $savedName",
                            fontSize = 28.sp,  // Tamaño del texto
                            fontWeight = FontWeight.Bold  // Negrita
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, ConfiguracionActivity::class.java)
                        configuracionLauncher.launch(intent)
                    }) {
                        Text("Configuración")
                    }

                }
            }
        }
    }

    private fun saveColorInPreferences(color: Color) {
        val sharedPref = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("background_color", color.toArgb())
            apply()
        }
    }
}

