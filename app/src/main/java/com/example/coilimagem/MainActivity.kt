package com.example.coilimagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.coilimagem.ui.theme.CoilImagemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CoilImagemTheme {
                Scaffold { innerPadding ->
                    // Aplicar o padding corretamente
                    Box(modifier = Modifier.padding(innerPadding)) {
                        BrainrotScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun BrainrotScreen() {
    // Lista de URLs das imagens de brainrot italiano
    val brainrotUrls = listOf(
        "https://static.wikia.nocookie.net/brainrotnew/images/f/fc/Piccione_Macchina.png/revision/latest?cb=20250411000814",
        "https://static.wikia.nocookie.net/brainrotnew/images/a/ac/Tralalero_tralala.jpg/revision/latest?cb=20250321131418",
        "https://static.wikia.nocookie.net/brainrotnew/images/0/0b/BallerinaCapuchina.png/revision/latest?cb=20250408120319",
        "https://static.wikia.nocookie.net/brainrotnew/images/0/07/Bombardiro_crocodilo_.webp/revision/latest?cb=20250321132902",
        "https://static.wikia.nocookie.net/brainrotnew/images/e/e0/Bombombini_Gusini.png/revision/latest?cb=20250325155049",
        "https://static.wikia.nocookie.net/brainrotnew/images/3/3a/Bombardiere.png/revision/latest?cb=20250410174750",
        "https://static.wikia.nocookie.net/brainrotnew/images/1/14/640.jpg/revision/latest?cb=20250408114336",
        "https://static.wikia.nocookie.net/brainrotnew/images/f/f2/Burbaloni.png/revision/latest?cb=20250331105445",
        "https://static.wikia.nocookie.net/brainrotnew/images/3/38/Hq720.jpg/revision/latest?cb=20250405141658",
        "https://static.wikia.nocookie.net/brainrotnew/images/5/5a/D28146d6115611f0a74582963e3c41a8_1.jpg/revision/latest?cb=20250404143052",
        "https://static.wikia.nocookie.net/brainrotnew/images/7/7a/Tractor.png/revision/latest?cb=20250331110636",
        "https://static.wikia.nocookie.net/brainrotnew/images/f/f1/Lirili_rili_ralila.png/revision/latest?cb=20250324152453",
        "https://static.wikia.nocookie.net/brainrotnew/images/f/f7/Brr_Brr_Patapim.png/revision/latest?cb=20250326180223",
        "https://static.wikia.nocookie.net/brainrotnew/images/2/26/Trulimero_Trulichina.png/revision/latest?cb=20250403115127",
        "https://static.wikia.nocookie.net/brainrotnew/images/6/62/Saturno_Saturnita.png/revision/latest?cb=20250404072301",
        "https://static.wikia.nocookie.net/brainrotnew/images/6/68/Rantasanta_Chinaranta.jpg/revision/latest?cb=20250330224147"
    )

    // Lista dos nomes dos brainrots
    val brainrotNames = listOf(
        "Piccione Macchina",
        "Tralalero Tralala",
        "Ballerina Capuchina",
        "Bombardino Crocodillo",
        "Bombombini Gusini",
        "Bombardiere Lucertola",
        "Trippi Troppi",
        "Burbaloni Luliloli",
        "Capuchino Assassino",
        "Talpa Di Ferro",
        "Tracotocutulo",
        "Lirilì Larilà",
        "Brr brr Patapim",
        "Brr brr Tarflem",
        "La vaca Saturno Saturnita"
    )

    // Estado para controlar o índice da imagem e nome
    var currentIndex by remember { mutableStateOf(0) }

    // Exibe o nome do brainrot acima da imagem
    val currentName = brainrotNames[currentIndex]
    val currentImageUrl = brainrotUrls[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Exibe o nome do brainrot
        Text(
            text = currentName,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Exibe a imagem atual
        AsyncImage(
            model = currentImageUrl,
            contentDescription = "Brainrot Italiano",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
        )

        // Botões para navegação entre as imagens
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    // Ir para a imagem anterior (se possível)
                    if (currentIndex > 0) {
                        currentIndex -= 1
                    }
                }
            ) {
                Text(text = "Último Brainrot")
            }

            Button(
                onClick = {
                    // Ir para a próxima imagem (se possível)
                    if (currentIndex < brainrotUrls.size - 1) {
                        currentIndex += 1
                    }
                }
            ) {
                Text(text = "Próximo Brainrot")
            }
        }
    }
}

@Preview
@Composable
fun PreviewBrainrotScreen() {
    BrainrotScreen()
}
