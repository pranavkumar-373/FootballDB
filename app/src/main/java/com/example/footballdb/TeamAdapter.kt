package com.example.footballdb

import android.content.Context
import android.content.Intent
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
    var teamarraylist: ArrayList<TeamProperty> = ArrayList()
    override fun getItemCount() = teams.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_info, parent, false)//sets the view

        return CustomViewHolder(view,teams)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.teaminfo.text = teams[position].strTeam
        teamarraylist = teams
        Glide.with(holder.itemView.context)
            .load(teams[position].strTeamBadge)
            .into(holder.image)

    }


    class CustomViewHolder(itemView: View,teamarr: ArrayList<TeamProperty>) :
        RecyclerView.ViewHolder(itemView) {//intializing view of card

        val teaminfo: TextView = itemView.findViewById(R.id.teaminfo)
        val image: ImageView = itemView.findViewById(R.id.team_images)

        //
        init {
            itemView.setOnClickListener {
                println("CLIQUE")
                val intent=Intent(itemView.context,Team_Description::class.java)
                intent.putExtra("teamarraylist",teamarr)
                itemView.context.startActivity(intent)
            }
        }
        //image from imageview in layout here
    }
}
