package bbk.gustavosanchez.culinarycompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bbk.gustavosanchez.culinarycompanion.ui.theme.CulinaryCompanionTheme


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

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Culinary Companion by Gustavo",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(categories.size) { index ->
                Button(
                    onClick = { /* TODO: navigate to recipe list */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = categories[index])
                }
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