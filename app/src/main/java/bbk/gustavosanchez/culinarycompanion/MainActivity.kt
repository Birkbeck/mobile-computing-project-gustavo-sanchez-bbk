package co.uk.bbk.culinarycompanionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.uk.bbk.culinarycompanionapp.ui.theme.CulinaryCompanionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CulinaryCompanionAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val categories = listOf("Breakfast", "Brunch", "Lunch", "Dinner", "Dessrts", "Other")

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Culinary Companion",
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
    CulinaryCompanionAppTheme {
        Greeting("Android")
    }
}