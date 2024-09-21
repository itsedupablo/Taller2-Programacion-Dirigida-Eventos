package com.edupablo.taller1app

import android.app.Activity
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
    private val defaultColor = Color.White // Color predeterminado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Taller1AppTheme {
                var selectedColor by remember { mutableStateOf(defaultColor) }

                ConfiguracionScreen(
                    selectedColor = selectedColor,
                    onColorSelected = { color ->
                        // Cambiar el color seleccionado o restablecer a default
                        if (color == selectedColor) {
                            selectedColor = defaultColor // Restablecer a color predeterminado
                        } else {
                            selectedColor = color // Cambiar al nuevo color
                        }
                    },
                    onVolverClick = {
                        val resultIntent = Intent().apply {
                            putExtra("selectedColor", selectedColor.toArgb())
                        }
                        setResult(Activity.RESULT_OK, resultIntent)
                        finish()  // Volver a la pantalla principal
                    }
                )
            }
        }
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
            ColorButton(selectedColor) { onColorSelected(selectedColor) } // Para visualizar el color seleccionado
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
