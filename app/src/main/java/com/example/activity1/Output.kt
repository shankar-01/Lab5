package com.example.activity1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Output : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)
        val story:TextView = findViewById(R.id.story)
        story.text = intent.getStringExtra("text")
    }
    fun back(v: View){
        val intent : Intent = Intent(this, Input::class.java)
        startActivity(intent)

    }
}