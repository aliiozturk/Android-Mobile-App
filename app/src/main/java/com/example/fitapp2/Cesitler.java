package com.example.fitapp2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Cesitler extends Activity {

    Button temelGidagecis;
    Button kaydetKaloribtn;
    LinearLayout linearLayout;

    SharedPreferencesSinifi shePre = new SharedPreferencesSinifi();
    CheckBox yumurta,yumurta2,yumurta3,patates1,salatalik,domates,kasarpey,kasartost,
    ekmek,nutella,patatespogaca,siyahzeytin,beyazpeynir,omlet,karısıktost,menemen,yesilzeytin;
    TextView yemekSonucTextDegiskeni;
    TextView kaloriSonucTextDegiskeni;

    Context context=this;
    String yemekSonuc="";
    Integer kalori = 0,sabahKalori = 0,ogleKalori =0,aksamKalori = 0;
    boolean isVisible = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cesitler);

        Button temelGidagecis = (Button)findViewById(R.id.buttonBasicFood);
        Button sebzegecis = (Button)findViewById(R.id.buttonVegetables);
        Button kaydetKaloribtn = (Button)findViewById(R.id.KaydetKalori);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear1);
        LinearLayout linearLayout2 = (LinearLayout)findViewById(R.id.linear2);


        yumurta=(CheckBox) findViewById(R.id.checkBox1);
        yumurta2=(CheckBox) findViewById(R.id.checkBox2);
        yumurta3=(CheckBox) findViewById(R.id.checkBox3);
        patates1=(CheckBox) findViewById(R.id.checkBox4);
        salatalik=(CheckBox) findViewById(R.id.checkBox5);
        domates=(CheckBox) findViewById(R.id.checkBox6);
        kasarpey=(CheckBox) findViewById(R.id.checkBox7);
        kasartost=(CheckBox) findViewById(R.id.checkBox8);

        ekmek=(CheckBox) findViewById(R.id.checkBox9);
        nutella=(CheckBox) findViewById(R.id.checkBox10);
        patatespogaca=(CheckBox) findViewById(R.id.checkBox11);
        siyahzeytin=(CheckBox) findViewById(R.id.checkBox12);
        beyazpeynir=(CheckBox) findViewById(R.id.checkBox13);
        omlet=(CheckBox) findViewById(R.id.checkBox14);
        karısıktost=(CheckBox) findViewById(R.id.checkBox15);
        menemen=(CheckBox) findViewById(R.id.checkBox16);
        yesilzeytin=(CheckBox) findViewById(R.id.checkBox17);

        yemekSonucTextDegiskeni=(TextView) findViewById(R.id.yemekSonucText);
        kaloriSonucTextDegiskeni =(TextView)findViewById(R.id.kaloriSonucTextDegiskeni);


        kaydetKaloribtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cesitler.this, MainActivity.class);
//                intent.putExtra("sayiAnahtar", kalori);
                int controlSabah = shePre.dosyadanIntVeriOku(context,"intKeyControlSabah");
                if(controlSabah == 1) {
                    shePre.dosyayaStringVeriYaz(context, yemekSonuc, "sKey1");
                    sabahKalori = kalori;
                    shePre.dosyayaIntVeriYaz(context, sabahKalori, "intSabahKaloriKey1");
                }
                int controlOgle = shePre.dosyadanIntVeriOku(context,"intKeyControlOgle");
                if(controlOgle == 2) {
                    shePre.dosyayaStringVeriYaz(context, yemekSonuc, "sKey2");
                    ogleKalori = kalori;
                    shePre.dosyayaIntVeriYaz(context, ogleKalori, "intOgleKaloriKey2");
                }
                int controlAksam = shePre.dosyadanIntVeriOku(context,"intKeyControlAksam");
                if(controlAksam == 3) {
                    shePre.dosyayaStringVeriYaz(context, yemekSonuc, "sKey3");
                    aksamKalori = kalori;
                    shePre.dosyayaIntVeriYaz(context, aksamKalori, "intAksamKaloriKey3");
                }
                startActivity(intent);
            }
        });

        temelGidagecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVisible) {
                    linearLayout.setVisibility(View.GONE);
                    isVisible = false;
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                    isVisible = true;
                }
            }
        });

        sebzegecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVisible) {
                    linearLayout2.setVisibility(View.GONE);
                    isVisible = false;
                } else {
                    linearLayout2.setVisibility(View.VISIBLE);
                    isVisible = true;
                }
            }
        });

        yumurta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    yemekSonuc += "-Haş.Yumurta";
                    kalori +=78;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Haş.Yumurta"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Haş.Yumurta")+12);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=78;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));

            }
        });

        yumurta2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Sah.Yumurta";
                    kalori +=120;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Sah.Yumurta"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Sah.Yumurta")+12);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=120;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });

        yumurta3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Suc.Yumurta";
                    kalori +=242;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Suc.Yumurta"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Suc.Yumurta")+12 );
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=242;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });

        patates1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Pat.Kızartması";
                    kalori +=312;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Pat.Kızartması"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Pat.Kızartması")+15);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=312;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });

        salatalik.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Salatalık";
                    kalori +=10;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Salatalık"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Salatalık")+10);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=10;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });


        domates.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Domates";
                    kalori +=10;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Domates"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Domates")+8);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=10;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });



        kasarpey.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Kaşar Peynir";
                    kalori +=106;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Kaşar Peynir"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Kaşar Peynir")+13);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=106;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });


        kasartost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Kaşarlı Tost";
                    kalori +=212;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Kaşarlı Tost"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Kaşarlı Tost")+13);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=212;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });








        ekmek.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    yemekSonuc += "-Ekmek";
                    kalori +=132;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Ekmek"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Ekmek")+6);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=132;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));

            }
        });

        nutella.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Nutella";
                    kalori +=120;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Nutella"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Nutella")+8);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=120;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });

        patatespogaca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Pat.Poğaça";
                    kalori +=246;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Pat.Poğaça"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Pat.Poğaça")+11);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=246;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });

        siyahzeytin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Siyah Zeytin";
                    kalori +=25;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Siyah Zeytin"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Siyah Zeytin")+12);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=25;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });

        beyazpeynir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Beyaz Peynir";
                    kalori +=200;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Beyaz Peynir"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Beyaz Peynir")+13);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=200;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });


        omlet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Omlet";
                    kalori +=154;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Omlet"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Omlet")+6);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=154;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });



        karısıktost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Karışık Tost";
                    kalori +=256;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Karışık Tost"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Karışık Tost")+13);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=256;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });


        menemen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Menemen";
                    kalori +=106;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Menemen"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Menemen")+8);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=106;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });


        yesilzeytin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    yemekSonuc += "-Yeşil Zeytin";
                    kalori +=40;
                    buttonView.setTextColor(Color.GREEN);
                }
                else
                {
                    String oncesi=yemekSonuc.substring(0,yemekSonuc.indexOf("-Yeşil Zeytin"));
                    String sonrasi=yemekSonuc.substring(yemekSonuc.indexOf("-Yeşil Zeytin")+13);
                    yemekSonuc=oncesi+sonrasi;
                    kalori -=40;
                    buttonView.setTextColor(Color.BLACK);
                }
                yemekSonucTextDegiskeni.setText(yemekSonuc);
                kaloriSonucTextDegiskeni.setText(String.valueOf(kalori+" kcal"));
            }
        });





    }
}
