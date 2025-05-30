//Culinary Companion - Add or Edit a Recipe Screen

package bbk.gustavosanchez.culinarycompanion

//import everything
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import bbk.gustavosanchez.culinarycompanion.ui.theme.CulinaryCompanionTheme

@Composable
fun AddEditRecipeScreen(onBackClick: () -> Unit = {}) {
    // State variables for form inputs (static for Coursework 1)
    var name by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back arrow
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        // Title
        Text(
            text = "Add / Edit Recipe",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        )

        // Name field
        Text(text = "Name", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Ingredients field
        Text(text = "Ingredients", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = ingredients,
            onValueChange = { ingredients = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Instructions field
        Text(text = "Instructions", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = instructions,
            onValueChange = { instructions = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 32.dp),
            maxLines = 6
        )

        // Save Recipe Button with icon
        Button(
            onClick = { /* TODO: Save logic */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(imageVector = Icons.Default.Check, contentDescription = "Save")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Save Recipe")
        }
    }
}
//Preview the screen
@Preview(showBackground = true)
@Composable
fun AddEditRecipeScreenPreview() {
    CulinaryCompanionTheme {
        AddEditRecipeScreen()
    }
}