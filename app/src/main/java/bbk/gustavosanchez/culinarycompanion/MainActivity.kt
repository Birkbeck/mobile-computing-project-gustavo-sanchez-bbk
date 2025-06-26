package bbk.gustavosanchez.culinarycompanion

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                Toast.makeText(this, "$name clicked!", Toast.LENGTH_SHORT).show()
                // TODO: Navigate to category screen or filter list
            }
        }
    }
}
