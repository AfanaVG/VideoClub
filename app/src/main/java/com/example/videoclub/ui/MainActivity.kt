package com.example.videoclub.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import com.example.videoclub.R
import com.example.videoclub.adapter.MoviesAdapter
import com.example.videoclub.model.Movie
import com.example.videoclub.utils.getJsonFromAssets
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val TAG = ":::TAG"

    private lateinit var adapter :MoviesAdapter
    private  val copyList = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MoviesAdapter(::onMovieClicked)
        recyclerview.adapter = adapter

        adapter.refreshList(getListFromJson())

        searchField.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {


                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let{
                    val filteredList = copyList.filter {
                        it.name?.toLowerCase(Locale.getDefault()).contains(newText) }
                    adapter.filterByName(filteredList)
                }
                return false
            }

        })

        btSort.setOnClickListener(){

            adapter.orderByName()
        }

    }

    fun getListFromJson():ArrayList<Movie>{
        var movieList = arrayListOf<Movie>()
        val json = getJsonFromAssets("movies.json")
        json?.let {
             movieList = ArrayList(Gson().fromJson(json,Array<Movie>::class.java).toList())
            copyList.addAll(movieList)
        }

        return  ArrayList(movieList)
    }

    private fun onMovieClicked(movie:Movie){

        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("movie",movie)
        startActivity(intent)

    }


}