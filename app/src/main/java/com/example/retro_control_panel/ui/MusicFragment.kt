package com.example.retro_control_panel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.example.retro_control_panel.R
import com.example.retro_control_panel.databinding.FragmentCalanderBinding
import com.example.retro_control_panel.databinding.FragmentMusicBinding


class MusicFragment : Fragment() {

    //---------binding
    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    //-----values
    var checked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        val view = binding.root

        var img: ImageView = binding.playStopBtn

        binding.playStopBtn.setOnClickListener{
            checked = !checked
            animate(img, checked)
        }

        return view
    }

    private fun animate(img: ImageView, b: Boolean){
        if(b){
            val stateSet = intArrayOf(android.R.attr.state_checked)
            img.setImageState(stateSet, true)
        }else{
            val stateSet = intArrayOf(-android.R.attr.state_checked)
            img.setImageState(stateSet, true)
        }

    }

}