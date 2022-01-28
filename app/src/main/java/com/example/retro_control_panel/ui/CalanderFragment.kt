package com.example.retro_control_panel.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.retro_control_panel.databinding.FragmentCalanderBinding
import com.example.retro_control_panel.util.Constants.Companion.API_KEY
import com.example.retro_control_panel.util.Constants.Companion.QUERY_API_KEY
import com.example.retro_control_panel.util.Constants.Companion.QUERY_SEARCH
import com.example.retro_control_panel.viewModel.MainViewModel
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import kotlin.collections.HashMap

class CalanderFragment : Fragment() {

    //---------binding
    private var _binding: FragmentCalanderBinding? = null
    private val binding get() = _binding!!

    //............values
    private lateinit var mainViewModel: MainViewModel
    lateinit var city: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalanderBinding.inflate(inflater, container, false)
        val view = binding.root

        city = "london"
        // TODO: 1/28/2022 get user city 


        setTime()
        readApi()
        countDown()

        return view
    }

    private fun countDown() {
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //var millisec : Long = millisUntilFinished / 1000
                setTime()
            }
            override fun onFinish() {
                setTime()
            }
        }.start()
    }
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setTime(){
        if(LocalDateTime.now().second<=9){
            binding.sec.text = "0" + LocalDateTime.now().second.toString()
        }else{binding.sec.text =  LocalDateTime.now().second.toString() }
        if(LocalDateTime.now().hour<=9){
            binding.hour.text = "0" + LocalDateTime.now().hour.toString()
        }else{ binding.hour.text = LocalDateTime.now().hour.toString()}
        if(LocalDateTime.now().minute<=9){
            binding.min.text = "0" + LocalDateTime.now().minute.toString()
        }else{ binding.min.text = LocalDateTime.now().minute.toString()}
    }


    @SuppressLint("SetTextI18n")
    fun readApi(){
        mainViewModel.getWeather(applyQueries())
        mainViewModel.myResponse.observe(viewLifecycleOwner, Observer {

            //---------view bind
            val t: Float = it.coord.lat.toFloat()
            val n: Float = it.coord.lon.toFloat()
            setMap(t,n, binding.smallImg,8f)
            setMap(t,n, binding.bigImg,4f)
            binding.cityName.text = it.sys.country+"/"+it.name

            binding.thp.text = it.main.temp.toString()+"°C"
            binding.wind.text = it.wind.speed.toString()+"m/s"
            binding.hum.text = it.main.humidity.toString()+"%"
            binding.lat.text = it.coord.lat.toString()
            binding.lon.text = it.coord.lon.toString()

        })
    }

    private fun applyQueries(): HashMap<String, String>{

        val queries: HashMap<String, String> = HashMap()

        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_SEARCH] = city

        return queries

    }

    fun setMap(clat: Float, clon: Float, image: ImageView, zoom: Float){


        val ww = 1024
        val hh = 512


        val url = "https://api.mapbox.com/styles/v1/mito2003/ckyxvkazg006h14t827gq7u74/static/" +
                clon + "," + clat + "," + zoom + "/" +
                ww + "x" + hh +
                "?access_token=pk.eyJ1IjoibWl0bzIwMDMiLCJhIjoiY2t5N2N4Y2N4MDdzajJvbGp6cTV3Z211byJ9.1Zx7fdH3vx1BCepLE8safA"



        image.load(url)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}