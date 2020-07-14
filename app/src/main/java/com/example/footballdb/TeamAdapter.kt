package com.example.footballdb

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.team_info.*
import kotlin.coroutines.coroutineContext

class TeamAdapter(val teams: ArrayList<TeamProperty>) : RecyclerView.Adapter<TeamAdapter.CustomViewHolder>() {

    override fun getItemCount() = teams.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_info, parent, false)//sets the view

        return CustomViewHolder(view)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.teaminfo.text = teams[position].strTeam
        holder.bind(teams[position])

        Glide.with(holder.itemView.context)
            .load(teams[position].strTeamBadge)
            .into(holder.image)

    }


    class CustomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(teamProperty: TeamProperty) {
            itemView.setOnClickListener {
                println("CLIQUE")
                val intent=Intent(itemView.context,Team_Description::class.java)

                intent.putExtra("bpic",teamProperty.strTeamBadge)
                Log.e("banner",teamProperty.strTeamBadge)
                intent.putExtra("jpic",teamProperty.strTeamJersey)
                Log.e("jersey",teamProperty.strTeamJersey)
                intent.putExtra("desc",teamProperty.strDescriptionEN)
                Log.e("dy",teamProperty.strDescriptionEN)

                itemView.context.startActivity(intent)
            }

        }
//intializing view of card

        val teaminfo: TextView = itemView.findViewById(R.id.teaminfo)
        val image: ImageView = itemView.findViewById(R.id.team_images)

    }
}
