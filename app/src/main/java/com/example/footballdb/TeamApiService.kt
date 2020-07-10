package com.example.footballdb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamApiService {
        @GET("lookup_all_teams.php")
        fun getProperties(@Query("id") id: Int): Call<TeamObjects>
}