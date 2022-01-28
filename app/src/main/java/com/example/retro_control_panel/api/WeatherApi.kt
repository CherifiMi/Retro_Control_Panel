package com.example.retro_control_panel.api

import com.example.retro_control_panel.model.Weather
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @QueryMap queries: Map<String, String>
    ): Weather

}