package com.example.aprendeprogramando.apijuegos.components


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.aprendeprogramando.apijuegos.models.VideoJuegosLista
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextLayoutResult


// Función composable que muestra la barra superior de la aplicación
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(titulo: String) {
    TopAppBar(
        title = {
            Text(
                text = titulo,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold as FontWeight,
                onTextLayout = { layoutResult: TextLayoutResult -> }
            )
        },
//        backgroundColor = Color(Constantes.COLOR_NEGRO),
//        contentColor = Color.White
    )
}

// Función composable que muestra un card de juego
@Composable
fun CardJuego(juego: VideoJuegosLista, onClick: () -> Unit) {
    val context = LocalContext.current // Se obtiene el contexto actual

    // Card con forma redondeada y sombra, con posibilidad de hacer clic
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .shadow(40.dp)
            .clickable {
                Toast.makeText(context, "Estamos trabajando", Toast.LENGTH_SHORT).show() // Se muestra un mensaje al hacer clic
                onClick() // Se ejecuta la acción onClick
            }
    ) {
        Column {
            InicioImagen(imagen = juego.imagen) // Se muestra la imagen del juego
        }
    }
}

// Función composable que muestra una imagen de inicio
@Composable
fun InicioImagen(imagen: String) {
    val painter = rememberImagePainter(data = imagen) // Se carga la imagen con rememberImagePainter

    // Imagen con contenido recortado y altura fija
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .height(250.dp)
    )
}

