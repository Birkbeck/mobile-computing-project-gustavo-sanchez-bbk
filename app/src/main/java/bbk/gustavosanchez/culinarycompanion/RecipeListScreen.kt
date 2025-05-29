package bbk.gustavosanchez.culinarycompanion

//import all the things !
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import bbk.gustavosanchez.culinarycompanion.ui.theme.CulinaryCompanionTheme


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

        // Recipe items - we still dont have recipes
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            items(mockRecipes) { recipe ->
                Button(
                    onClick = { /* TODO: View recipe details */ },
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    Text(text = recipe)
                }
            }
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