# TALLER 4: Programación Dirigida Por Eventos
#### Link repositorio: https://github.com/itsedupablo/Taller2-Programacion-Dirigida-Eventos
### >>> ESTE REPOSITORIO SE IRÁ ACTUALIZANDO CON CADA TALLER NUEVO YA QUE SON ACTUALIZACIONES DE LA MISMA APP
## Índice
- Descripción de la app.
- Arquitectura del proyecto (clases).
  
-------
## Descripción de la app
Esta app, con un diseño inicial simple, permitía a un usuario introducir su nombre e interactuar con diferentes botones para pasar de una a otra de las diferentes pantallas y configurar los colores de fondo de las pantallas. Ahora, también permite al usuario visualizar una lista de elementos, crear un widget en la pantalla de inicio del dispositivo android e interctuar con el entorno para cambiar el color de fondo de la app (a través del sensor de movimiento del dispositivo).

-------
## Arquitectura de la app
Está compuesta por tres pantallas: De inicio, principal y de configuración, cuyo funcionamiento ha sido programado en archivos separados y cuyo flujo es manejado a través de el archivo xml AndroidManifest. En un inicio se ha utilizado Jetpack Compose por lo que los elementos de cada pantalla, tales como: botones, cuadros de texto, etc se han creado a partir de elementos "composables" pero se ha actualizado el código a java y se ha pasado toda la parte de diseño de las pantallas y sus elementos a los ficheros xml.
También cuenta con 2 fragments que ocupan la totalidad de la pantalla principal, una clase que permite habilitar widgets y una interfaz que permite almacenar el cambio de color para los fragments.
### **Pantalla de Inicio**
En esta pantalla aparecen los siguientes elementos: 
- Un mensaje que cambia dependiendo de la hora del día.
- Un botón que dirige al usuario a la pantalla inicial tras presionarlo.
### **Pantalla Principal**
Contiene 2 contenedores que almacenan los siguientes elementos:
#### **IngresarUsuarioFragment**
- Un cuadro de texto donde el usuario debe escribir su nombre.
- Un botón que permite al usuario guardar su nombre de usuario durante toda la ejecución de la app. No existe una base de datos de usuarios puesto que no tendría sentido al no ser necesario un loging en la aplicación, por lo que el nombre de usuario guardado se pierde tras cerrarla.
- Un botón que dirige al usuario a la pantalla de configuración tras presionarlo (puede utilizarse antes y después de guardar el usuario).
- Un mensaje dando la bienvenida a la aplicación al usuario (aparece únicamenete tras presionar el botón de guardar).
#### **ListaFragment**
- Una lista de elementos añadidos manualmente
### **Pantalla de Configuración**
En esta pantalla aparecen los siguientes elementos: 
- Un mensaje que indica al usuario que puede cambiar el color de fondo presionando los botones.
- Varios botones para cambiar el color de fondo. 
- Un botón que dirige de nuevo al usuario a la pantalla inicial una vez hechos los cambios.




