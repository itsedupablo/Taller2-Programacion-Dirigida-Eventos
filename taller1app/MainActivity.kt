package com.edupablo.taller1app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.edupablo.taller1app.ui.theme.Taller1AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller1AppTheme {
                // Estados para el nombre y si el nombre ha sido guardado
                var name by remember { mutableStateOf("") }
                var isNameSaved by remember { mutableStateOf(false) }
                var savedName by remember { mutableStateOf("") } // Nuevo estado para mostrar el nombre guardado

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Mostrar TextField y Botón de guardar solo si no se ha guardado el nombre
                    if (!isNameSaved) {
                        // Campo de texto para ingresar el usuario
                        OutlinedTextField(
                            value = name,
                            onValueChange = { newName -> name = newName },
                            label = { Text("Ingresa tu usuario") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Botón para guardar el nombre
                        Button(onClick = {
                            savedName = name  // Guardar el nombre ingresado
                            isNameSaved = true  // Cambiar estado a guardado
                        }) {
                            Text("Guardar")
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                    } else {
                        // Mostrar el nombre ingresado después de presionar "Guardar"
                        Text(text = "Nombre ingresado: $savedName")

                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    // Mostrar el botón de configuración siempre
                    Button(onClick = {
                        // Aquí deberías agregar la lógica para navegar a la tercera pantalla
                    }) {
                        Text("Configuración")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Taller1AppTheme {
        // Previsualización de la interfaz.
    }
}
