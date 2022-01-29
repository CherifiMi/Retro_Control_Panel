package com.example.retro_control_panel.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retro_control_panel.R
import com.example.retro_control_panel.databinding.FragmentAppsBinding
import com.example.retro_control_panel.databinding.FragmentCalanderBinding
import android.widget.Toast

import com.example.retro_control_panel.MainActivity

import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.PackageManagerCompat
import java.util.*
import android.content.ComponentName

import android.content.pm.ActivityInfo

import android.content.pm.ResolveInfo


// TODO: 1/29/2022 work out how to open the app from the btn


class AppsFragment : Fragment() {

    //---------binding
    private var _binding: FragmentAppsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAppsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.phoneBtn.setOnClickListener{
            openApp("com.viber.voip")
        }
        binding.msgBtn.setOnClickListener{

        }
        binding.cameraBtn.setOnClickListener{

        }
        binding.gglBtn.setOnClickListener{

        }
        binding.mapBtn.setOnClickListener{

        }
        binding.ytBtn.setOnClickListener{

        }
        binding.musicBtn.setOnClickListener{

        }

        return view
    }

    private fun openApp(app: String) {
        var i: Intent? = requireContext().packageManager.getLeanbackLaunchIntentForPackage(app)

        try {startActivity(i)}
        catch (e: Exception){Log.d("hillo", e.toString())}

    }
    @SuppressLint("QueryPermissionsNeeded")
    fun launchApp(packageName: String?) {
        val intent = Intent()
        intent.setPackage(packageName)
        val pm: PackageManager = requireActivity().packageManager
        val resolveInfos = pm.queryIntentActivities(intent, 0)
        Collections.sort(resolveInfos, ResolveInfo.DisplayNameComparator(pm))
        if (resolveInfos.size > 0) {
            val launchable = resolveInfos[0]
            val activity = launchable.activityInfo
            val name = ComponentName(
                activity.applicationInfo.packageName,
                activity.name
            )
            val i = Intent(Intent.ACTION_MAIN)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
            i.component = name
            startActivity(i)
        }
    }

}