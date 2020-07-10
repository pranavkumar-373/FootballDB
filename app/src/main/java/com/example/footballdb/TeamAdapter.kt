package com.example.footballdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.coroutines.coroutineContext

class TeamAdapter(val teams: ArrayList<TeamProperty>) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun getItemCount()=teams.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.team_info, parent,false)//sets the view
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.teaminfo.text= teams[position].strTeam
        Glide.with(holder.itemView.context)
            .load(teams[position].strTeamBadge)
            .into(holder.image)
            //league name in text view
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){//intializing view of card
        val teaminfo: TextView=itemView.findViewById(R.id.teaminfo)
        val image: ImageView=itemView.findViewById(R.id.team_images)
        //image from imageview in layout here
}
}