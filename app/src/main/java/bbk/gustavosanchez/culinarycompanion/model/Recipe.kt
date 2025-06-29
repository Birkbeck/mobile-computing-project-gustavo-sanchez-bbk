package bbk.gustavosanchez.culinarycompanion.model

import androidx.room.Entity
import androidx.room.PrimaryKey
// do we still need this ?
import java.io.Serializable

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val ingredients: String,
    val instructions: String,
    val category: String
) : Serializable

