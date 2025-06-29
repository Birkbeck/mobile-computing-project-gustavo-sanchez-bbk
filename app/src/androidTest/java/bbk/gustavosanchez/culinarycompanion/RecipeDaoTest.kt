package bbk.gustavosanchez.culinarycompanion

import com.google.common.truth.Truth.assertThat
import bbk.gustavosanchez.culinarycompanion.getOrAwaitValue
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import bbk.gustavosanchez.culinarycompanion.data.RecipeDao
import bbk.gustavosanchez.culinarycompanion.data.RecipeDatabase
import bbk.gustavosanchez.culinarycompanion.model.Recipe
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule



@SmallTest
class RecipeDaoTest {

    @get:Rule
    var instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var database: RecipeDatabase
    private lateinit var dao: RecipeDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = database.recipeDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    // As per coursework guidelines, four tests each test Class should be pretty descriptive
    @Test
    fun insertRecipeAndGetAll() = runBlocking {
        val recipe = Recipe(
            title = "Test Recipe",
            ingredients = "Test Ingredients",
            instructions = "Test Instructions",
            category = "Lunch"
        )
        dao.insert(recipe)

        val allRecipes = dao.getAllRecipes().getOrAwaitValue()
        assertThat(allRecipes).contains(recipe)
    }

    @Test
    fun updateRecipe() = runBlocking {
        val recipe =
            Recipe(title = "Test", ingredients = "I1", instructions = "Steps", category = "Dinner")
        dao.insert(recipe)

        val inserted = dao.getAllRecipes().getOrAwaitValue()[0]
        val updated = inserted.copy(title = "Updated Title")

        dao.update(updated)

        val allRecipes = dao.getAllRecipes().getOrAwaitValue()
        assertThat(allRecipes[0].title).isEqualTo("Updated Title")
    }

    @Test
    fun deleteRecipe() = runBlocking {
        val recipe = Recipe(
            title = "Delete Test",
            ingredients = "I1",
            instructions = "Steps",
            category = "Brunch"
        )
        dao.insert(recipe)

        val inserted = dao.getAllRecipes().getOrAwaitValue()[0]
        dao.delete(inserted)

        val allRecipes = dao.getAllRecipes().getOrAwaitValue()
        assertThat(allRecipes).doesNotContain(inserted)
    }

    @Test
    fun getAllRecipesEmptyReturnsEmptyList() = runBlocking {
        val allRecipes = dao.getAllRecipes().getOrAwaitValue()
        assertThat(allRecipes).isEmpty()
    }
}