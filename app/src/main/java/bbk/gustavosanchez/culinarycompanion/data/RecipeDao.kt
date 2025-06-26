package bbk.gustavosanchez.culinarycompanion.data

import androidx.lifecycle.LiveData
import androidx.room.*
import bbk.gustavosanchez.culinarycompanion.model.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)

    @Update
    suspend fun update(recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("SELECT * FROM recipes ORDER BY id DESC")
    fun getAllRecipes(): LiveData<List<Recipe>>
}
