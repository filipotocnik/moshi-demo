package si.um.feri.moshi.data

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import si.um.feri.moshi.R

class MovieRepository(private val context: Context) {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun loadMovies(): List<Movie> {
        val jsonString = context.resources.openRawResource(R.raw.movies)
            .bufferedReader()
            .use { it.readText() }

        val type = Types.newParameterizedType(List::class.java, Movie::class.java)
        val adapter = moshi.adapter<List<Movie>>(type)

        return adapter.fromJson(jsonString) ?: emptyList()
    }
}