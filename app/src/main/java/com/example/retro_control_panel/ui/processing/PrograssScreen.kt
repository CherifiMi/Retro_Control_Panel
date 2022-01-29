package com.example.retro_control_panel.ui.processing

import android.content.Context
import android.os.BatteryManager
import processing.core.PApplet

class PrograssScreen: PApplet() {
    override fun setup() {

    }

    override fun draw() {

        background(0f, 100f)

        //-----get battery level
        val bm = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        val p: Int = width*batLevel/100

        frameRate(1f)
        for (i in 0..width step 15){
            fill(55f,209f,123f,77f)
            noStroke()
            rect(i.toFloat(), 0f, 12f, height.toFloat())
        }
        for (i in 0..p step 15){
            fill(55f,209f,123f,160f)
            noStroke()
            rect(i.toFloat(), 0f, 12f, height.toFloat())
        }
    }
}