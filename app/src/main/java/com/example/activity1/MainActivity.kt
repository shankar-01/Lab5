package com.example.activity1

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import java.util.Objects
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)//task 1
        setContentView(R.layout.task2)//task2
        //setContentView(R.layout.october_8)
        if(intent.getBooleanExtra("h_data", false)){
            Toast.makeText(this, "Hello World",Toast.LENGTH_SHORT).show();
        }
    }
    fun clickOct8(v: View){
        val alarmManager : AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val myIntent :Intent = Intent(this, MainActivity::class.java)
        myIntent.putExtra("h_data", true)

        val pendingIntent:PendingIntent = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_IMMUTABLE)


        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis()+10000, pendingIntent)
    }
    fun moveForward(v: View){
        val intent:Intent = Intent(this, Input::class.java)
        startActivity(intent);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.task2_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.i1){
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, PhoneBook1())
        }
        return true
    }
}
