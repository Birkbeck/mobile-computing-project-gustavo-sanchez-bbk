package bbk.gustavosanchez.culinarycompanion

//import all the things
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Our buttons / menus
        val categories = listOf(
            R.id.btnBreakfast to "Breakfast",
            R.id.btnBrunch to "Brunch",
            R.id.btnLunch to "Lunch",
            R.id.btnDinner to "Dinner",
            R.id.btnDesserts to "Desserts",
            R.id.btnOther to "Other"
        )

        categories.forEach { (buttonId, name) ->
            findViewById<Button>(buttonId).setOnClickListener {
                val intent = Intent(this, RecipeListActivity::class.java)
                intent.putExtra("CATEGORY", name)
                startActivity(intent)
            }
        }
    }
}
