package com.example.myfragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myfragments2.fragments.fragmentOne
import com.example.myfragments2.fragments.fragmentTwo

class MainActivity : AppCompatActivity(), Communicate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragOneButton = findViewById<Button>(R.id.button1)
        val fragTwoButton = findViewById<Button>(R.id.button2)

        val frag1 = fragmentOne()
        val frag2 = fragmentTwo()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, frag1)
            commit()
        }

        fragOneButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, frag1)
                addToBackStack(null)
                commit()
            }
        }

        fragTwoButton.setOnClickListener {
            val nameEdit = findViewById<EditText>(R.id.edit1)
            frag2.arguments = passTheData(nameEdit.text.toString())

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, frag2)
                addToBackStack(null)
                commit()
            }
        }

    }

    override fun passTheData(PassingText: String): Bundle {
        val bundle = Bundle()
        bundle.putString("frag1_to_frag2", PassingText)

        return bundle
    }

}