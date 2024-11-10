# TALLER 3: Programación Dirigida Por Eventos
#### Link repositorio: https://github.com/itsedupablo/Taller2-Programacion-Dirigida-Eventos
### >>> ESTE REPOSITORIO SE IRÁ ACTUALIZANDO CON CADA TALLER NUEVO YA QUE SON ACTUALIZACIONES DE LA MISMA APP
## Índice
- Descripción de la app.
- Características de diseño: Pantalla de Inicio, Pantalla Principal, Pantalla de Configuración.
## Descripción de la app
Esta aplicación ha sido desarrollada en lenguaje de programación Kotlin en Android Studio. 
Tiene un diseño simple en que un usuario puede introducir su nombre e interactuar con diferentes botones para pasar de una a otra de las diferentes pantallas y configurar los colores de fondo de las pantallas.
## Características de diseño
Está compuesta por tres pantallas: De inicio, principal y de configuración, cuyo funcionamiento ha sido programado en archivos separados y cuyo flujo es manejado a través de el archivo xml AndroidManifest. Se ha utilizado Jetpack Compose por lo que los elementos de cada pantalla, tales como: botones, cuadros de texto, etc se han creado a partir de elementos "composables".
### **Pantalla de Inicio**
En esta pantalla aparecen los siguientes elementos: 
- Un mensaje que cambia dependiendo de la hora del día.
- Un botón que dirige al usuario a la pantalla inicial tras presionarlo.
En el código de el archivo *PantallaInicio.kt* puede verse la configuración de características de esta pantalla como el tamaño del botón, del texto o que el color se corresponda con el que se cambia en la pantalla de configuración.
### **Pantalla Principal**
En esta pantalla aparecen los siguientes elementos: 
- Un cuadro de texto donde el usuario debe escribir su nombre.
- Un botón que permite al usuario guardar su nombre de usuario durante toda la ejecución de la app. No existe una base de datos de usuarios puesto que no tendría sentido al no ser necesario un loging en la aplicación, por lo que el nombre de usuario guardado se pierde tras cerrarla.
- Un botón que dirige al usuario a la pantalla de configuración tras presionarlo (puede utilizarse antes y después de guardar el usuario).
- Un mensaje dando la bienvenida a la aplicación al usuario (aparece únicamenete tras presionar el botón de guardar)
En el código de el archivo *PantallaPrincipal.kt* puede verse la configuración de características de esta pantalla de la misma forma que en la inicial.
### **Pantalla de Configuración**
En esta pantalla aparecen los siguientes elementos: 
- Un mensaje que indica al usuario que puede cambiar el color de fondo presionando los botones.
- Varios botones para cambiar el color de fondo. 
- Un botón que dirige de nuevo al usuario a la pantalla inicial una vez hechos los cambios.
En el código de el archivo *PantallaConfiguracion.kt* puede verse la configuración de características de esta pantalla de la misma forma que en la inicial.




