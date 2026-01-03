package si.um.feri.moshi.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    val id: Int,
    val title: String,
    val director: String,
    val year: Int,
    val rating: Double,
    val genre: String,
    @Json(name = "runtime_minutes")
    val runtimeMinutes: Int,
    val description: String?
)