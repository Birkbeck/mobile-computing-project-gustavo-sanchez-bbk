package bbk.gustavosanchez.culinarycompanion
//import everything
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import bbk.gustavosanchez.culinarycompanion.model.Recipe
import bbk.gustavosanchez.culinarycompanion.viewmodel.RecipeViewModel

// This is our Edit Recipe Activity Kotlin file
class EditRecipeActivity : AppCompatActivity() {

    private lateinit var inputTitle: EditText
    private lateinit var inputIngredients: EditText
    private lateinit var inputSteps: EditText
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button

    private lateinit var recipeViewModel: RecipeViewModel
    private var recipeId: Int = 0 // to track which recipe we edit

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe) // Reuse the same layout for editing

        // Initialize ViewModel
        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        inputTitle = findViewById(R.id.inputTitle)
        inputIngredients = findViewById(R.id.inputIngredients)
        inputSteps = findViewById(R.id.inputSteps)
        updateButton = findViewById(R.id.btnSave)

        // Change button text to 'Update'
        updateButton.text = "Update Recipe"

        // Create Delete button dynamically below Update (or add in XML)
        deleteButton = Button(this).apply {
            text = "Delete Recipe"
            setBackgroundColor(resources.getColor(android.R.color.holo_red_dark))
            setTextColor(resources.getColor(android.R.color.white))
        }
        (updateButton.parent as? LinearLayout)?.addView(deleteButton)

        // Retrieve recipe data from Intent
        val recipe = intent.getSerializableExtra("recipe") as? Recipe
        recipe?.let {
            recipeId = it.id
            inputTitle.setText(it.title)
            inputIngredients.setText(it.ingredients)
            inputSteps.setText(it.instructions)
        }

        updateButton.setOnClickListener {
            updateRecipe()
        }

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
            category = "Other" // Extend with category selection if needed
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
            category = "Other"
        )
        recipeViewModel.delete(recipeToDelete)
        Toast.makeText(this, "Recipe deleted!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
