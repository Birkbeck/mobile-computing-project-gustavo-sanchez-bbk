package bbk.gustavosanchez.culinarycompanion

//import everything
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import bbk.gustavosanchez.culinarycompanion.model.Recipe
import bbk.gustavosanchez.culinarycompanion.viewmodel.RecipeViewModel

class EditRecipeActivity : AppCompatActivity() {

    private lateinit var inputTitle: EditText
    private lateinit var inputIngredients: EditText
    private lateinit var inputSteps: EditText
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button
    private lateinit var spinnerCategory: Spinner

    private lateinit var recipeViewModel: RecipeViewModel
    private var recipeId: Int = 0

    private val categories = listOf("Breakfast", "Brunch", "Lunch", "Dinner", "Desserts", "Other")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe) // Reuse the same layout

        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        inputTitle = findViewById(R.id.inputTitle)
        inputIngredients = findViewById(R.id.inputIngredients)
        inputSteps = findViewById(R.id.inputSteps)
        updateButton = findViewById(R.id.btnSave)
        spinnerCategory = findViewById(R.id.spinnerCategory)

        // Change button text to 'Update Recipe'
        updateButton.text = "Update Recipe"

        // Populate Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        // Retrieve recipe data
        val recipe = intent.getSerializableExtra("recipe") as? Recipe
        recipe?.let {
            recipeId = it.id
            inputTitle.setText(it.title)
            inputIngredients.setText(it.ingredients)
            inputSteps.setText(it.instructions)

            // Set Spinner selection to existing category
            val categoryPosition = categories.indexOf(it.category)
            spinnerCategory.setSelection(if (categoryPosition >= 0) categoryPosition else 0)
        }

        updateButton.setOnClickListener {
            updateRecipe()
        }

        // ✅ Delete button (optional – add in XML or dynamically if needed)
        deleteButton = Button(this).apply {
            text = "Delete Recipe"
            setBackgroundColor(resources.getColor(android.R.color.holo_red_dark))
            setTextColor(resources.getColor(android.R.color.white))
        }
        (updateButton.parent as? LinearLayout)?.addView(deleteButton)

        deleteButton.setOnClickListener {
            deleteRecipe()
        }
    }

    private fun updateRecipe() {
        val updatedRecipe = Recipe(
            id = recipeId,
            title = inputTitle.text.toString(),
            ingredients = inputIngredients.text.toString(),
            instructions = inputSteps.text.toString(),
            category = spinnerCategory.selectedItem.toString()
        )
        recipeViewModel.update(updatedRecipe)
        Toast.makeText(this, "Recipe updated!", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun deleteRecipe() {
        val recipeToDelete = Recipe(
            id = recipeId,
            title = inputTitle.text.toString(),
            ingredients = inputIngredients.text.toString(),
            instructions = inputSteps.text.toString(),
            category = spinnerCategory.selectedItem.toString()
        )
        recipeViewModel.delete(recipeToDelete)
        Toast.makeText(this, "Recipe deleted!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
