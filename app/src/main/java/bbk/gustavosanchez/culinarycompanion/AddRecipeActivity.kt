//import all the things


package bbk.gustavosanchez.culinarycompanion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import bbk.gustavosanchez.culinarycompanion.model.Recipe
import bbk.gustavosanchez.culinarycompanion.viewmodel.RecipeViewModel

class AddRecipeActivity : AppCompatActivity() {

    private lateinit var inputTitle: EditText
    private lateinit var inputIngredients: EditText
    private lateinit var inputSteps: EditText
    private lateinit var saveButton: Button

    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        // Initialise ViewModel
        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        // Link to VIEWS
        inputTitle = findViewById(R.id.inputTitle)
        inputIngredients = findViewById(R.id.inputIngredients)
        inputSteps = findViewById(R.id.inputSteps)
        saveButton = findViewById(R.id.btnSave)

        saveButton.setOnClickListener {
            saveRecipe()
        }
    }

    private fun saveRecipe() {
        val title = inputTitle.text.toString().trim()
        val ingredients = inputIngredients.text.toString().trim()
        val steps = inputSteps.text.toString().trim()

        if (title.isEmpty() || ingredients.isEmpty() || steps.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Default category for now
        val category = "Other"

        val recipe = Recipe(
            title = title,
            ingredients = ingredients,
            instructions = steps,
            category = category
        )

        // Insert the recipe using ViewModel
        recipeViewModel.insert(recipe)

        Toast.makeText(this, "Recipe saved!", Toast.LENGTH_SHORT).show()
        finish() // Close activity and return to previous screen
    }
}
