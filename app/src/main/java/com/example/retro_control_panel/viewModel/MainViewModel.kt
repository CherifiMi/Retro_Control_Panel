package com.example.retro_control_panel.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retro_control_panel.api.Repository
import com.example.retro_control_panel.model.Weather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
): AndroidViewModel(application){

    val myResponse: MutableLiveData<Weather> = MutableLiveData()
    fun getWeather(queries: Map<String, String>){
        viewModelScope.launch {
            myResponse.value = repository.remote.getWeather(queries)
        }
    }
}