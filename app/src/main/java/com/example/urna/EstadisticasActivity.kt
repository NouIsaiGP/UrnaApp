package com.example.urna

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidplot.pie.PieChart
import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter

class EstadisticasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        val arrayList = intent.getIntegerArrayListExtra("arrayList")
        val pieChart = findViewById<PieChart>(R.id.pieChart)


        val s1 = Segment("A votos:" + arrayList?.get(0), arrayList?.get(0))
        val s2 = Segment("B votos:" + arrayList?.get(1), arrayList?.get(1))
        val s3 = Segment("C votos:" + arrayList?.get(2), arrayList?.get(2))

        val sf1 = SegmentFormatter(Color.BLUE)
        val sf2 = SegmentFormatter(Color.RED)
        val sf3 = SegmentFormatter(Color.GREEN)

        pieChart.addSegment(s1,sf1)
        pieChart.addSegment(s2,sf2)
        pieChart.addSegment(s3,sf3)
    }
}