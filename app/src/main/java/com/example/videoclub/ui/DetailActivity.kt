package com.example.videoclub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.videoclub.R
import com.example.videoclub.model.Movie
import com.example.videoclub.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail.*
import kotlin.math.log

class DetailActivity : AppCompatActivity() {

    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        retrieveMovie()
        renderUi()

    }

    private fun retrieveMovie(){

        movie = intent.getSerializableExtra("movie") as Movie?

    }

    private fun renderUi(){

        Log.d(":::TAG","fegegeg" )
        detailName.text = movie?.name
        detailDescription.text = movie?.description
        movie?.cover?.let { mCover ->
            detailImage.loadImage(mCover)
        }
    }
}