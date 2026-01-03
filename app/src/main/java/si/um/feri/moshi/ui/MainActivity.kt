package si.um.feri.moshi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import si.um.feri.moshi.data.MovieRepository
import si.um.feri.moshi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: MovieRepository
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = MovieRepository(this)
        setupRecyclerView()
        loadMovies()
    }

    private fun setupRecyclerView() {
        adapter = MovieAdapter()
        binding.rvMovies.apply {
            this.adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun loadMovies() {
        val movies = repository.loadMovies()
        adapter.submitList(movies)

        binding.tvMovieCount.text = "Total Movies: ${movies.size}"
    }
}