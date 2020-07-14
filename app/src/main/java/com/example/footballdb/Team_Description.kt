package com.example.footballdb

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.team_desc.*


class Team_Description() : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val jerseypic=intent.getStringExtra("jpic")
        val bannerpic=intent.getStringExtra("bpic")
        val teamdescc=intent.getStringExtra("desc")


        setContentView(R.layout.team_desc)
        teamdesc.text=teamdescc

        Glide.with(this)
            .load(jerseypic)
            .into(jerseyimageView)

        Glide.with(this)
            .load(bannerpic)
            .into(bannerimageView)

    }
}