package com.example.footballdb

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeagueAdapter(val leagues: ArrayList<LeaguesProperty>) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>()  {
    override fun getItemCount()=leagues.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.league_item, parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.leaguetextview.text=leagues[position].strLeague
        holder.recyclev.layoutManager= LinearLayoutManager(holder.itemView.context, RecyclerView.HORIZONTAL,false)
        callTeams(leagues[position].idLeague,holder.recyclev)



    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val leaguetextview: TextView =itemView.findViewById(R.id.leaguetextView)
        val recyclev: RecyclerView=itemView.findViewById(R.id.recyclerView2)
        //image from imageview in layout here
    }
    private fun callTeams(leagueid: Int,recyclev:RecyclerView) {
// Fetch a list of the Github repositories.
        SportApi.TEAM_SERVICE.getProperties(leagueid).enqueue(object : Callback<TeamObjects?> {
            
            override fun onResponse(
                call: Call<TeamObjects?>?,
                response: Response<TeamObjects?>?
            ) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                var teamlistar =
                    response?.body()?.teams?.let { ArrayList(it) }!!//ENTIRE JSON model from api ARRAYLIST OF TEAM PROPERTY

                recyclev.adapter = TeamAdapter(teamlistar)
                Log.e("success",teamlistar.toString());


            }

            override fun onFailure(call: Call<TeamObjects?>, t: Throwable) {
                // the network call was a failure
                // TODO: handle error
                Log.e("team list",t.localizedMessage.toString())
            }
        })
    }
}