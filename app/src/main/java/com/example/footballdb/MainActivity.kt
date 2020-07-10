package com.example.footballdb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {


    val teams: ArrayList<String> = ArrayList()
    var leaguelistar: ArrayList<LeaguesProperty> = ArrayList()
    var teamlistar: ArrayList<TeamProperty> = ArrayList()

    private val callBack: Callback<ArrayList<LeaguesProperty>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        for(i in 1..leaguelistar.size){
//        teams.add("Team #$i")
//
//    }
        recyclerView.layoutManager=LinearLayoutManager(this)
        callLeagues()



//        recyclerView.layoutManager=LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
//        recyclerView.adapter=TeamAdapter(teams)


//        val teams2: ArrayList<String> = ArrayList()
//        for(i in 1..25){
//            teams2.add("Team2 #$i")
//        }

//        recyclerView.adapter=LeagueAdapter(leaguelistar)

//        recyclerView2.layoutManager=LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
//        recyclerView2.adapter=TeamAdapter(teams2)

    }

    private fun callLeagues() {
// Fetch a list of the Github repositories.
        SportApi.LEAGUE_SERVICE.getProperties().enqueue(object : Callback<League?> {
            override fun onResponse(
                call: Call<League?>?,
                response: Response<League?>?
            ) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                 leaguelistar =
                     response?.body()?.leagues?.filter { it.strSport=="Soccer"}?.let { ArrayList(it) }!!//ENTIRE JSON model from api ARRAYLIST OF TEAM PROPERTY
//pass to league adapter and set league name in text view
                recyclerView.adapter=LeagueAdapter(leaguelistar)//
                Log.e("success",leaguelistar.toString());


            }

            override fun onFailure(call: Call<League?>, t: Throwable) {
                // the network call was a failure
                // TODO: handle error
               Log.e("league list",t.localizedMessage.toString())
            }
        })
    }

}
