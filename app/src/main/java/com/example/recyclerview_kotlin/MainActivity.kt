package com.example.recyclerview_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.liu_kang,
                "liu",
                "Menggunakan Kekuatan Taijutsu & elemen Api"
            ),
            Superhero(
                R.drawable.raiden   ,
                "Master",
                "Menggunakan Kekuatan elemen Listrik"
            ),
            Superhero(
                R.drawable.reptile,
                "reptile",
                "Menggunakan Racun/Bisa Ular"
            ),
            Superhero(
                R.drawable.scorpio,
                "scorpio",
                "Menggunakan Kekuatan elemen Api"
            ),
            Superhero(
                R.drawable.sub_zero,
                "sub_zero",
                "Menggunakan Kekuatan elemen Air & Es"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rvHero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this,superheroList){
            val intent = Intent(this,DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)

        }
    }
}