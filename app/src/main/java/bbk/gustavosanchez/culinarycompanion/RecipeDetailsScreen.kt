// Culinary Companion

//package
package bbk.gustavosanchez.culinarycompanion

//import all the things !
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
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.tooling.preview.Preview
import bbk.gustavosanchez.culinarycompanion.ui.theme.CulinaryCompanionTheme

@Composable
fun RecipeDetailsScreen(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back button
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack, //why is this throwing an error?
                contentDescription = "Back"
            )
        }

        // Title
        Text(
            text = "Recipe Details",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        )

        // Recipe name
        Button(
            onClick = { /* Not needed until cw2 */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            Text("Guacamole") // Obviously to be changed when functionality is needed for CW2
        }

        // Ingredients section
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "• 2 ripe avocados\n• 1 lime\n• Salt\n• 1/2 cup diced onion\n• 2 tbsp chopped cilantro",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Instructions section
        Text(
            text = "Instructions",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "1. Scoop out the avocados into a bowl.\n2. Add lime juice and salt.\n3. Mash with a fork.\n4. Stir in onion and cilantro.\n5. Serve fresh.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Edit and Delete buttons in a row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Edit
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /* TODO: Edit */ }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit"
                    )
                }
                Text("Edit")
            }

            // Delete
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /* TODO: Delete */ }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
                Text("Delete")
            }
        }
    }
}
//Add preview function for Android sgtudio
@Preview(showBackground = true)
@Composable
fun RecipeDetailsScreenPreview() {
    CulinaryCompanionTheme {
        RecipeDetailsScreen()
    }
}
