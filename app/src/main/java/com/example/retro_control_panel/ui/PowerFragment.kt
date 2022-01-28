package com.example.retro_control_panel.ui

import android.content.Context.BATTERY_SERVICE
import android.os.BatteryManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.example.retro_control_panel.R


class PowerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_power, container, false)

        val power: TextView = view.findViewById(R.id.power_num)

        //-----get battery level
        val bm = requireContext().getSystemService(BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

        power.text = "${batLevel}%"


        return view
    }

}