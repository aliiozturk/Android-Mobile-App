package com.example.fitapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

public class BarChartActivity extends AppCompatActivity {


    SharedPreferencesSinifi shePre = new SharedPreferencesSinifi();
    Context context =this;

    Button gunlukkayitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphicmain);

        gunlukkayitbtn = findViewById(R.id.günlükKaloriKayit);



        BarChart barChart = findViewById(R.id.barchart);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(2014,520));
        visitors.add(new BarEntry(2015,620));
        visitors.add(new BarEntry(2016,720));
        visitors.add(new BarEntry(2017,820));
        visitors.add(new BarEntry(2018,920));
        visitors.add(new BarEntry(2019,520));
        visitors.add(new BarEntry(2020,420));



        gunlukkayitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int toplam = shePre.dosyadanIntVeriOku(context,"toplamKey1");
                float toplamFLT =toplam;

                Calendar calendar = Calendar.getInstance();
                int currentMonth = calendar.get(Calendar.MONTH) + 1; // Ay indeksi 0'dan başlar, bu yüzden 1 ekliyoruz
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

                // X değerlerini cihazın gün ve ayına göre ayarla
                float startXValue = currentMonth + (float)currentDay/100; // Günü yüzdelik olarak ekliyoruz



                if (visitors.size() >= 7) {
                    // İlk veriyi sil ve yeni veriyi eklemek için diğer verileri kaydır
                    visitors.remove(0); // İlk indexteki veriyi sil

                    for (int i = 0; i < visitors.size(); i++) {
                        BarEntry currentEntry = visitors.get(i);
                        float newXValue = currentEntry.getX() - 1f; // İndeks değerini bir azalt
                        float newYValue = currentEntry.getY(); // Y değerini değiştirmeye gerek yok
                        visitors.set(i, new BarEntry(newXValue, newYValue)); // Güncellenmiş veriyi ayarla
                    }

                    barChart.invalidate();
                }

                // Yeni veriyi ekle
                visitors.add(new BarEntry(startXValue, toplamFLT));
                barChart.invalidate();


            }
        });



        BarDataSet barDataSet = new BarDataSet(visitors, "Visitors");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);


        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);




//        int yeniYil = 2021; // Yeni verinin yılı, örnek olarak 2021 varsayalım
//        int yeniVeri = 621; // Yeni veri miktarı, örnek olarak 620 varsayalım
//
//// Yeni verinin gelip gelmediğini kontrol edelim
//        boolean yeniVeriGeldi = false;
//
//        for (BarEntry entry : visitors) {
//            if (entry.getX() == yeniYil) {
//                yeniVeriGeldi = true;
//                break;
//            }
//        }
//
//// Yeni veri gelmediyse listeye ekleyelim
//        if (!yeniVeriGeldi) {
//            visitors.add(new BarEntry(yeniYil, yeniVeri));
//        }









    }
}