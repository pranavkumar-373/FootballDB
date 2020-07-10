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
    class TeamDescAdapter(val teams: ArrayList<TeamProperty>) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

        override fun getItemCount()=teams.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.team_desc, parent,false)//sets the view
            return ViewHolder(view)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.teamdescc.text= teams[position].strDescriptionEN
            Glide.with(holder.teamdescc)
                .load(teams[position].strTeamBanner)
                .into(holder.bannerimage)

            //league name in text view
        }

        class ViewHolder(itemView: View){//intializing view of card
            val teamdescc: TextView =itemView.findViewById(R.id.teamdesc)
            val bannerimage: ImageView =itemView.findViewById(R.id.bannerimageView)
            val jerseyimage:ImageView =itemView.findViewById(R.id.jerseyimageView)
            //image from imageview in layout here
        }
    }
}