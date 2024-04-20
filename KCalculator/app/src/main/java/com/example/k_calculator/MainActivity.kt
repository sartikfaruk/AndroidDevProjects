package com.example.k_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.k_calculator.databinding.ActivityMainBinding


//import kotlinx.android.synthetic.main.activity_main.resultsTextView
//import kotlinx.android.synthetic.main.activity_main.workingsTextView

class MainActivity : AppCompatActivity() {

    private var canAddOperation = false
    private var canAddDecimal = true
    private lateinit var bind

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view: View)
    {
        if(view is Button)
        {
            if(view.text == ".")
                {
                    if (canAddDecimal)
                        workingsTextView.append(view.text)
                    canAddDecimal = false
                }
            else
                workingsTextView.append(view.text)

            canAddOperation = true
        }
    }
    fun operationAction(view: View)
    {
        if(view is Button && canAddOperation)
        {
            workingsTextView.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    fun equalsAction(view: View) {}

    fun deleteAction(view: View)
    {
        val length = workingsTextView.length()
        if (length > 0)
            workingsTextView.text = workingsTextView.text.subSequence(0,length - 1)
    }

    fun allClearAction(view: View)
    {
        workingsTextView.text = ""
        resultsTextView.text = ""

    }
}