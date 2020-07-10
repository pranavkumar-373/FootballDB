package com.example.footballdb

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL="https://www.thesportsdb.com/api/v1/json/1/"

private val retrofit=Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//implementing interface with get


object SportApi{
    val LEAGUE_SERVICE: LeagueApiService by lazy {
        retrofit.create(LeagueApiService::class.java)
    }
    val TEAM_SERVICE: TeamApiService by lazy {
        retrofit.create(TeamApiService::class.java)
    }
}
