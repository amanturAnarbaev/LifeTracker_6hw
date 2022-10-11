package com.example.a1hw4monthlifetracker

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a1hw4monthlifetracker.databinding.FragmentStartRegistrationBinding
import kotlin.properties.Delegates


class StartRegistrationFragment : Fragment() {

lateinit var binding: FragmentStartRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentStartRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferencesRegistere=requireContext().getSharedPreferences("registre",Context.MODE_PRIVATE)
        val isRegistered:Boolean=preferencesRegistere.getBoolean("isRegistered", false)

        if(isRegistered){
            findNavController().navigate(R.id.homeFragment2)

        }

        binding.registrationBtn.setOnClickListener{
            val preferencesRegistere=requireContext().getSharedPreferences("registre",Context.MODE_PRIVATE)
            preferencesRegistere.edit().putBoolean("isRegistered",true).apply()
            findNavController().navigate(R.id.registrationNumberFragment)
        }

    }

}