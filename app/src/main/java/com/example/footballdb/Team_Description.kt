package com.example.footballdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.team_desc.*


class Team_Description() : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val pos=intent.getIntExtra("position",0)
        var teams2: ArrayList<TeamProperty> = ArrayList()
        teams2= intent.getSerializableExtra("teamarraylist") as ArrayList<TeamProperty>

        teamdesc.text=teams2[pos].strDescriptionEN
        setContentView(R.layout.team_desc)
        Glide.with(this)
            .load(teams2[pos].strTeamJersey)
            .into(jerseyimageView)

        Glide.with(this)
            .load(teams2[pos].strTeamBanner)
            .into(bannerimageView)

    }
}