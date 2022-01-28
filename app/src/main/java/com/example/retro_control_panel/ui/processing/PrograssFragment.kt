package com.example.retro_control_panel.ui.processing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retro_control_panel.R
import processing.android.CompatUtils
import processing.android.PFragment


class PrograssFragment : Fragment() {

    //-----------------values
    private lateinit var sketch : PrograssScreen

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_prograss, container, false)

        view.id = CompatUtils.getUniqueViewId()


        sketch = PrograssScreen()
        val fragment = PFragment(sketch)
        fragment.setView(view, requireActivity())

        return view
    }
    override fun onDestroy() {
        super.onDestroy()
        sketch.pause()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        sketch.onRequestPermissionsResult(
            requestCode, permissions, grantResults
        )
    }

}