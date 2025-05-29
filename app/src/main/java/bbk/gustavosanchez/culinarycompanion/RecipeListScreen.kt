package bbk.gustavosanchez.culinarycompanion

//import all the things !
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import bbk.gustavosanchez.culinarycompanion.ui.theme.CulinaryCompanionTheme
import androidx.compose.material3.Icon
import androidx.compose.foundation.shape.CircleShape


//Recipe List screen
@Composable
fun RecipeListScreen() {
    val mockRecipes = listOf("Recipe 1", "Recipe 2", "Recipe 3")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Recipe List",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Recipe buttons
        mockRecipes.forEach { recipe ->
            Button(
                onClick = { /* TODO: View recipe */ },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = recipe)
            }
        }

        // Spacer to separate from Add button
        Spacer(modifier = Modifier.height(40.dp))

        // Circular Add button + label
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* TODO: Add new recipe */ },
                shape = CircleShape,
                modifier = Modifier.size(56.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Add Recipe",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


//adding so we can preview
@Preview(showBackground = true)
@Composable
fun RecipeListScreenPreview() {
    CulinaryCompanionTheme {
        RecipeListScreen()
    }
}