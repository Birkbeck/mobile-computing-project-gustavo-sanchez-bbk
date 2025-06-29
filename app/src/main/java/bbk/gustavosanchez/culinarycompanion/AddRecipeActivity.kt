package bbk.gustavosanchez.culinarycompanion

//import everything
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import bbk.gustavosanchez.culinarycompanion.model.Recipe
import bbk.gustavosanchez.culinarycompanion.viewmodel.RecipeViewModel

class AddRecipeActivity : AppCompatActivity() {

    private lateinit var inputTitle: EditText
    private lateinit var inputIngredients: EditText
    private lateinit var inputSteps: EditText
    private lateinit var saveButton: Button
    private lateinit var spinnerCategory: Spinner

    private lateinit var recipeViewModel: RecipeViewModel

    // Categories will go here
    private val categories = listOf("Breakfast", "Brunch", "Lunch", "Dinner", "Desserts", "Other")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        // Initialise ViewModel
        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        // Link to views
        inputTitle = findViewById(R.id.inputTitle)
        inputIngredients = findViewById(R.id.inputIngredients)
        inputSteps = findViewById(R.id.inputSteps)
        saveButton = findViewById(R.id.btnSave)
        spinnerCategory = findViewById(R.id.spinnerCategory)

        // Populate Spinner inside onCreate
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        saveButton.setOnClickListener {
            saveRecipe()
        }
    }

    private fun saveRecipe() {
        val title = inputTitle.text.toString().trim()
        val ingredients = inputIngredients.text.toString().trim()
        val steps = inputSteps.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()

        //is the field empty ?
        if (title.isEmpty() || ingredients.isEmpty() || steps.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val recipe = Recipe(
            title = title,
            ingredients = ingredients,
            instructions = steps,
            category = category
        )

        // Insert the recipe using ViewModel
        recipeViewModel.insert(recipe)

        //success
        Toast.makeText(this, "Recipe saved!", Toast.LENGTH_SHORT).show()
        finish() // Close activity and return to previous screen
    }
}
