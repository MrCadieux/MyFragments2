package com.example.myfragments2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myfragments2.R

class fragmentTwo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        var displayMessage = arguments?.getString("frag1_to_frag2")
        val txtReceived = view.findViewById<TextView>(R.id.textReceived)
        txtReceived.setText(displayMessage)

        return view
    }



}