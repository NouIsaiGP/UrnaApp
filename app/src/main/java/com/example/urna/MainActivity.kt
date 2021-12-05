package com.example.urna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val arrayList = ArrayList<Int>()
    var a = 0
    var b = 0
    var c = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnA = findViewById<Button>(R.id.btnA)
        val btnB = findViewById<Button>(R.id.btnB)
        val btnC = findViewById<Button>(R.id.btnC)


        btnA.setOnClickListener {
            a++
            Log.d("votos",a.toString())
        }

        btnB.setOnClickListener {
            b++
        }

        btnC.setOnClickListener {
            c++
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.votar -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.estadisticas -> {

                arrayList.add(a)
                arrayList.add(b)
                arrayList.add(c)

                val intent = Intent(this, EstadisticasActivity::class.java)
                intent.putIntegerArrayListExtra("arrayList", arrayList)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}