package com.example.recyclerview_kotlin

import android.content.Context
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_kotlin.R

class SuperheroAdapter (private val context: Context,private val superHero:List<Superhero> ,
val listener: (Superhero) -> Unit) : RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>(){
    class SuperheroViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imgSuperhero = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameSuperhero = view.findViewById<TextView>(R.id.tv_item_name)
        val descSuperhero = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindview(superhero:Superhero,listener: (Superhero) -> Unit){
            imgSuperhero.setImageResource(superhero.imgSuperhero)
            nameSuperhero.text = superhero.nameSuperhero
            descSuperhero.text = superhero.descSuperhero
            itemView.setOnClickListener{
                listener(superhero)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_superhero,parent,false)
        )
    }

    override fun getItemCount(): Int = superHero.size


    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bindview(superHero[position],listener)
    }

}