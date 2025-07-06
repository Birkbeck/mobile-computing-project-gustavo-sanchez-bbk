package bbk.gustavosanchez.culinarycompanion.viewmodel

import android.app.Application
import androidx.lifecycle.*
import bbk.gustavosanchez.culinarycompanion.data.RecipeDatabase
import bbk.gustavosanchez.culinarycompanion.data.RecipeRepository
import bbk.gustavosanchez.culinarycompanion.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RecipeRepository
    val allRecipes: LiveData<List<Recipe>>

    init {
        val recipeDao = RecipeDatabase.getDatabase(application).recipeDao()
        repository = RecipeRepository(recipeDao)
        allRecipes = repository.allRecipes
    }

    fun insert(recipe: Recipe) = viewModelScope.launch {
        repository.insert(recipe)
    }

    fun update(recipe: Recipe) = viewModelScope.launch {
        repository.update(recipe)
    }

    fun delete(recipe: Recipe) = viewModelScope.launch {
        repository.delete(recipe)
    }

}
