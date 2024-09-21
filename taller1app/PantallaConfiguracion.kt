package com.edupablo.taller1app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.edupablo.taller1app.ui.theme.Taller1AppTheme

class ConfiguracionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recuperar el color actual de SharedPreferences
        var currentColor by mutableStateOf(getSavedBackgroundColor())

        setContent {
            Taller1AppTheme {
                var selectedColor by remember { mutableStateOf(currentColor) }

                ConfiguracionScreen(
                    selectedColor = selectedColor,
                    onColorSelected = { color ->
                        selectedColor = color  // Cambia el color seleccionado
                    },
                    onVolverClick = {
                        saveColorInPreferences(selectedColor)  // Guardar color en SharedPreferences
                        val resultIntent = Intent().apply {
                            putExtra("selectedColor", selectedColor.toArgb())  // Pasamos el color como entero
                        }
                        setResult(Activity.RESULT_OK, resultIntent)
                        finish()  // Volver a la pantalla principal
                    }
                )
            }
        }
    }

    // Guardar el color seleccionado en SharedPreferences
    private fun saveColorInPreferences(color: Color) {
        val sharedPref = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("background_color", color.toArgb())
            apply()
        }
    }

    // Obtener el color desde SharedPreferences
    private fun getSavedBackgroundColor(): Color {
        val sharedPref = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val colorInt = sharedPref.getInt("background_color", Color.White.toArgb())
        return Color(colorInt)
    }
}

@Composable
fun ConfiguracionScreen(
    selectedColor: Color,
    onColorSelected: (Color) -> Unit,
    onVolverClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selecciona el color de fondo:")

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Botones para seleccionar colores
            ColorButton(Color.Red) { onColorSelected(it) }
            ColorButton(Color.Green) { onColorSelected(it) }
            ColorButton(Color.Blue) { onColorSelected(it) }
            ColorButton(Color.Yellow) { onColorSelected(it) }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para volver a la pantalla principal
        Button(onClick = { onVolverClick() }) {
            Text("Volver a la pantalla de inicio")
        }
    }
}

@Composable
fun ColorButton(color: Color, onClick: (Color) -> Unit) {
    Button(
        onClick = { onClick(color) },
        modifier = Modifier
            .size(50.dp)
            .background(color)
    ) {
        // El botón se ve del color correspondiente
    }
}
