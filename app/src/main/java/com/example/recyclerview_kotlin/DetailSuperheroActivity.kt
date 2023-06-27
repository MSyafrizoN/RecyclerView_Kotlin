package com.example.recyclerview_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerview_kotlin.R
import com.example.recyclerview_kotlin.MainActivity
import com.example.recyclerview_kotlin.Superhero

class DetailSuperheroActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_superhero)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val superHero = intent.getParcelableExtra<Superhero>(MainActivity.INTENT_PARCELABLE)

        val imgSuperhero = findViewById<ImageView>(R.id.img_item_photo)
        val nameSuperhero = findViewById<TextView>(R.id.tv_item_name)
        val descSUperhero = findViewById<TextView>(R.id.tv_item_description)

        imgSuperhero.setImageResource(superHero?.imgSuperhero!!)
        nameSuperhero.text = superHero.nameSuperhero
        descSUperhero.text = superHero.descSuperhero
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}