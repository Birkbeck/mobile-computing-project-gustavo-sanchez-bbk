package bbk.gustavosanchez.culinarycompanion.adapter

//import all
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bbk.gustavosanchez.culinarycompanion.R
import bbk.gustavosanchez.culinarycompanion.model.Recipe

class RecipeAdapter(private val onItemClick: (Recipe) -> Unit) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    private var recipeList = emptyList<Recipe>()

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textRecipeTitle)
        val subtitle: TextView = itemView.findViewById(R.id.textRecipeSubtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.title.text = recipe.title
        holder.subtitle.text = recipe.category // Or recipe.ingredients for preview

        // Add click listener for each item
        holder.itemView.setOnClickListener {
            onItemClick(recipe)
        }
    }


    override fun getItemCount() = recipeList.size

    fun setRecipes(recipes: List<Recipe>) {
        this.recipeList = recipes
        notifyDataSetChanged()
    }
}
