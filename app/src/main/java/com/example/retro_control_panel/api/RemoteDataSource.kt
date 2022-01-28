package com.example.retro_control_panel.api

import com.example.retro_control_panel.model.Weather
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val weatherApi: WeatherApi) {
    suspend fun getWeather(queries: Map<String, String>): Weather {
        return weatherApi.getWeather(queries)
    }
}