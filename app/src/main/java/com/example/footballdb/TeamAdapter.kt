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

class TeamAdapter(val teams: ArrayList<TeamProperty>) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun getItemCount()=teams.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.team_info, parent,false)//sets the view

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.teaminfo.text= teams[position].strTeam
        holder.itemView.setOnClickListener(clickListener)
        Glide.with(holder.itemView.context)
            .load(teams[position].strTeamBadge)
            .into(holder.image)
            //league name in text view
    }
    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.team_images -> gotoXScreen()
        }

    }
    private fun gotoXScreen() {
        val intent = Intent(this, Team_Description::class.java)
        startActivity(intent)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){//intializing view of card
        val teaminfo: TextView=itemView.findViewById(R.id.teaminfo)
        val image: ImageView=itemView.findViewById(R.id.team_images)
        //image from imageview in layout here
}
}