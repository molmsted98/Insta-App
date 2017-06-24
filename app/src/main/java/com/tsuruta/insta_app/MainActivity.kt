package com.tsuruta.insta_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    lateinit var btnGenerate: Button
    lateinit var tvDisplay: TextView
    var random = Random()
    lateinit var appType: Array<String>
    lateinit var peopleType: Array<String>
    lateinit var apps: Array<String>
    lateinit var verbs: Array<String>
    lateinit var verbsIng: Array<String>
    lateinit var nouns: Array<String>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGenerate = findViewById(R.id.btnGenerate) as Button
        tvDisplay = findViewById(R.id.tvOutput) as TextView
        btnGenerate.setOnClickListener(this)
        appType = resources.getStringArray(R.array.app_type)
        peopleType = resources.getStringArray(R.array.people_type)
        apps = resources.getStringArray(R.array.apps)
        verbs = resources.getStringArray(R.array.verbs)
        verbsIng = resources.getStringArray(R.array.verb_ing)
        nouns = resources.getStringArray(R.array.nouns)
    }

    override fun onClick(v: View)
    {
        if(v == btnGenerate)
        {
            val template = getRandom(2,1)
            if(template == 1)
            {
                val one = getRandom(appType.size-1, 0)
                val two = getRandom(peopleType.size-1, 0)
                val three = getRandom(verbs.size-1, 0)
                val four = getRandom(nouns.size-1, 0)
                val result = appType[one] + " for " + peopleType[two] + " to " + verbs[three] + " " + nouns[four] + "."
                tvDisplay.text = result
            }
            else
            {
                val one = getRandom(apps.size-1, 0)
                val two = getRandom(verbsIng.size-1, 0)
                val three = getRandom(nouns.size-1, 0)
                val result = "It's like " + apps[one] + " but for " + verbsIng[two] + " " + nouns[three] + "."
                tvDisplay.text = result
            }
        }
    }

    fun getRandom(max: Int, min: Int): Int
    {
        val randomNumber = random.nextInt(max + 1 - min) + min
        return randomNumber
    }
}