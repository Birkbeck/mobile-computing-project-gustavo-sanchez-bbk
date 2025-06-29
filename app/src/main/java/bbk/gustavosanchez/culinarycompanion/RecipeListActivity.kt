package bbk.gustavosanchez.culinarycompanion

//import everything
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import RecipeAdapter but we havent created the class
import bbk.gustavosanchez.culinarycompanion.adapter.RecipeAdapter
import bbk.gustavosanchez.culinarycompanion.viewmodel.RecipeViewModel

class RecipeListActivity : AppCompatActivity() {

    private lateinit var recipeViewModel: RecipeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var addRecipeButton: Button
    // this should result in class not found because we havent created the Recipe Adapter class
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recyclerView = findViewById(R.id.recyclerRecipes)
        addRecipeButton = findViewById(R.id.btnAddRecipe)

        adapter = RecipeAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Initialise ViewModel
        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        // recipes LiveData
        recipeViewModel.allRecipes.observe(this) { recipes ->
            adapter.setRecipes(recipes)
        }

        // Navigate to AddRecipeActivity
        addRecipeButton.setOnClickListener {
            val intent = Intent(this, AddRecipeActivity::class.java)
            startActivity(intent)
        }
    }
}
