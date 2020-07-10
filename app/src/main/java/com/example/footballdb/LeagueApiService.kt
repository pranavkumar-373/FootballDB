package com.example.footballdb

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Query



interface LeagueApiService{
    @GET("all_leagues.php")
     fun getProperties(): Call<League>
}

