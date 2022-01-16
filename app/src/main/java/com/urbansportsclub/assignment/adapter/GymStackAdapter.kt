package com.urbansportsclub.assignment.adapter

import android.location.Location
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.urbansportsclub.assignment.R

class GymStackAdapter(
    private var mGyms: List<Gym>,
) : RecyclerView.Adapter<GymStackAdapter.ViewHolder>() {

    private lateinit var mUserCurrentLocation: Location

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.gym_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gym = mGyms[position]
        holder.name.text = "${gym.name}"
        Glide.with(holder.image)
            .load(gym.url)
            .into(holder.image)
        holder.ratingBar.rating = gym.id!!
        holder.address.text = gym.address
    }

    override fun getItemCount(): Int {
        return mGyms.size
    }


    fun clearAdapter() {
        mGyms = emptyList()
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.gym_name)
        var image: ImageView = view.findViewById(R.id.item_image)
        val ratingBar: RatingBar = view.findViewById(R.id.rating)
        val address: TextView = view.findViewById(R.id.address);
        val distance: TextView = view.findViewById(R.id.distance);
    }

}
