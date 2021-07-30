package com.example.movie_search_app.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_search_app.R
import com.example.movie_search_app.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MyMovieAdapter(private val context: Context,private val movieList: MutableList<Movie>):RecyclerView.Adapter<MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]
        holder.bind(listItem)

        Picasso.get().load(movieList[position].image.medium).into(holder.image)
        holder.txt_name.text = movieList[position].name
        holder.txt_premiered.text = movieList[position].premiered
        holder.txt_rating.text = movieList[position].rating.average


    }
}

class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
    val image: ImageView = view.image_movie
    val txt_name: TextView = view.txt_name
    val txt_premiered: TextView = view.txt_premiered
    val txt_rating: TextView = view.txt_rating


    fun bind(listItem: Movie) {
        image.setOnClickListener {
            Toast.makeText(it.context, "нажал на ${itemView.image_movie}", Toast.LENGTH_SHORT)
                .show()
        }
        itemView.setOnClickListener {
            Toast.makeText(it.context, "нажал на ${itemView.txt_name.text}", Toast.LENGTH_SHORT).show()
        }

    }

}
