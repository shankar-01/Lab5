package com.example.activity1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.util.prefs.Preferences
import kotlin.collections.ArrayList

class Input : AppCompatActivity() {
    var index:Int = 0;
    var count:Int = 0;
    var text:StringBuilder = StringBuilder("")
    var toReplace:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        val rand : Random = Random()
        index = rand.nextInt(5)
        read()
    }
    fun read(){
        count = 0
        var id:Int = 0
        if(index==0){
            id = R.raw.madlib0
        }
        else if(index==1){
            id = R.raw.madlib1
        }
        else if(index==2){
            id = R.raw.madlib2
        }
        else if(index==3){
            id = R.raw.madlib3
        }
        else if(index==4){
            id = R.raw.madlib4
        }
        text.clear()
        val scan : Scanner = Scanner(resources.openRawResource(id))

        toReplace = ""
        while(scan.hasNextLine()){
            text.append(scan.nextLine())

        }
        var k : Int = text.indexOf('<')
        do{
            count++;
            k = text.indexOf('<', k+1)
        }while(k>=0)
        scan.close()
        next()

    }
    fun next(){

        val remainingWords : TextView = findViewById(R.id.remainingWords)
        remainingWords.text = ""+count+" word(s) left"
        toReplace = text.substring(text.indexOf('<')+1, text.indexOf('>'))
        val txt: TextView = findViewById(R.id.typeText)
        txt.text = "please type a/an " + toReplace;
        val edit: EditText = findViewById(R.id.editTextTextPersonName)
        edit.hint = toReplace
    }
    fun ok(v: View) {
        count--;
        val edit: EditText = findViewById(R.id.editTextTextPersonName)
        text.replace(text.indexOf("<"), text.indexOf(">")+1, edit.text.toString())

        edit.setText("")
        Toast.makeText(this, "Great keep going!", Toast.LENGTH_SHORT).show()
        if (count == 0) {

            val intent: Intent = Intent(this, Output::class.java)
            intent.putExtra("text", text.toString())
            startActivity(intent)
        }
        else {
            next()
        }
    }
}