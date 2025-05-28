package bbk.gustavosanchez.culinarycompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bbk.gustavosanchez.culinarycompanion.ui.theme.CulinaryCompanionTheme
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CulinaryCompanionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val categories = listOf("Breakfast", "Brunch", "Lunch", "Dinner", "Desserts", "Other")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        // I think we should add a logo to make it look neater
        Text(
            text = "Culinary Companion by Gustavo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // One button per line as per our wireframe - looks neater
        categories.forEach { category ->
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth(0.8f) // center the button
                    .padding(vertical = 8.dp)
            ) {
                Text(text = category)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CulinaryCompanionTheme {
        HomeScreen()
    }
}