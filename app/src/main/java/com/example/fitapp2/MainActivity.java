package com.example.fitapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnHesapla,hakkimizdagecis,sabahgecis,oglengecis,aksamgecis,gunlukgecis,vkigecis,sabahogun,ogleogun,aksamogun,grafikbtn;

    LinearLayout linearLayout1,linearLayout2,linearLayout3;
    Integer saat,sonucAlınan =0 ,sonucGereken,kalandeger ;
    EditText edittextBoy,edittextKilo;
    String alinanyemek,alinanyemekSABAH,alinanyemekOGLEN,alinanyemekAKSAM;
    TextView textViewSonuc,sabahyemekTxt,oglenyemekTxt,aksamyemekTxt;
    Integer sabahcontrol=0,oglecontrol=0,aksamcontrol=0,sabahKalori=0,ogleKalori =0,aksamKalori=0,toplam=0,gerekenKalori=0;
    boolean isVisible = false;
    float   indeksonuc;


    SharedPreferencesSinifi shePre = new SharedPreferencesSinifi();
    Context context =this;
    private static final String PREF_NAME = "MyPref";
    private static final String PREF2_NAME = "MyPref";

    private static final String KEY_VARIABLE1  = "value1",KEY_VARIABLE2  = "value2",KEY_VARIABLE3  = "value3",KEY_VARIABLE4  = "value4",KEY_VARIABLE5  = "value5";
    private static final String  KEY_STRING1 = "deger1",KEY_STRING2 = "deger1",KEY_STRING3 = "deger1";

    private SharedPreferences sharedPreferences,sharedPreferences2,sharedPreferences3,sharedPreferences4,sharedPreferences5,sharedPreferences6,sharedPreferences7,sharedPreferences8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edittextBoy = findViewById(R.id.editTextBoy);
        edittextKilo = findViewById(R.id.editTextKilo);
        btnHesapla = findViewById(R.id.SonucEndeks);
        textViewSonuc = findViewById(R.id.sonucEndeksTextView);
        gunlukgecis = findViewById(R.id.gerekenKalori);

        vkigecis = (Button) findViewById(R.id.grafik2);


        sabahogun = (Button) findViewById(R.id.buttonMorningEdit);
        ogleogun = (Button) findViewById(R.id.buttonAfternoonEdit);
        aksamogun = (Button) findViewById(R.id.buttonEveningEdit);

        linearLayout1 = (LinearLayout) findViewById(R.id.linear1ogun);
        linearLayout2 = (LinearLayout) findViewById(R.id.linear2ogun);
        linearLayout3 = (LinearLayout) findViewById(R.id.linear3ogun);

        sabahgecis = (Button) findViewById(R.id.buttonMorning);
        sabahyemekTxt = (TextView) findViewById(R.id.yemekSonucText);
        oglengecis = (Button) findViewById(R.id.buttonAfternoon);
        oglenyemekTxt = (TextView) findViewById(R.id.yemekSonucText2);
        aksamgecis = (Button) findViewById(R.id.buttonEvening);
        aksamyemekTxt = (TextView) findViewById(R.id.yemekSonucText3);
        hakkimizdagecis = (Button) findViewById(R.id.gec);
        grafikbtn = (Button) findViewById(R.id.grafik);


//        Intent intent = getIntent();
//        Intent intentz1 = getIntent();
//        Intent intentz2 = getIntent();
//        Intent intentz3 = getIntent();
//        int alinanSayi = intent.getIntExtra("sayiAnahtar", 0);
//        int sonucAlınan = alinanSayi;
//
//
//        Intent intent1 = getIntent();
//        int alinanSayi1 = intent1.getIntExtra("anahtarİndeks", 0);
//        int sonucGereken = alinanSayi1;
//
//        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
//        if (alinanSayi != 0) {
//            saveData(alinanSayi);
//
//        }
//        int value = getData();
//
//        sharedPreferences2 = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
//        if (alinanSayi1 != 0) {
//            saveData2(alinanSayi1);
//        }
//        int value2 = getData2();

        sabahKalori = shePre.dosyadanIntVeriOku(context,"intSabahKaloriKey1");
        ogleKalori = shePre.dosyadanIntVeriOku(context,"intOgleKaloriKey2");
        aksamKalori = shePre.dosyadanIntVeriOku(context,"intAksamKaloriKey3");

        gerekenKalori = shePre.dosyadanIntVeriOku(context,"intGerekenKaloriKey1");




        Button button = findViewById(R.id.GünlükKaloriTakip);
        toplam = sabahKalori+ogleKalori+aksamKalori;
        shePre.dosyayaIntVeriYaz(context,toplam,"toplamKey1");
        String strSayi2 = Integer.toString(toplam);
        button.setText(String.valueOf(strSayi2+"  kcal"));



        Button button2 = findViewById(R.id.AlinmasiGereken);
        String strSayi3 = Integer.toString(gerekenKalori);
        button2.setText(String.valueOf(strSayi3+"  kcal"));


        Button button3 = findViewById(R.id.KalanKaloriTakip);
        kalandeger = gerekenKalori - toplam;
        String strSayi1 = Integer.toString(kalandeger);
        button3.setText(String.valueOf(strSayi1+"  kcal"));






        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String boytextcontrol = edittextBoy.getText().toString().trim();
                String kilotextcontrol = edittextKilo.getText().toString().trim();
                if (boytextcontrol.isEmpty() & kilotextcontrol.isEmpty()) {
                    // EditText boş, kullanıcıya uyarı ver
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Uyarı");
                    builder.setMessage("Lütfen Boyunuzu ve Kilonuz için değer giriniz !");
                    builder.setPositiveButton("Tamam", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }

                else {
                    float boyDeger = Float.parseFloat(edittextBoy.getText().toString().trim());
                    float kiloDeger = Float.parseFloat(edittextKilo.getText().toString().trim());
                    boyDeger = boyDeger/100;
                    float degerSonuc = kiloDeger/(boyDeger*boyDeger);
                    indeksonuc = degerSonuc;
                    if ( degerSonuc <= 18){
                        textViewSonuc.setText(degerSonuc + " "+ "Zayıfsınız");
                        textViewSonuc.setBackgroundColor(Color.GREEN);

                    }
                    if (degerSonuc > 19){
                        textViewSonuc.setText(degerSonuc+" "+"Kilonuz İdeal");
                        textViewSonuc.setBackgroundColor(Color.GREEN);
                    }
                    if (degerSonuc > 30){
                        textViewSonuc.setText(degerSonuc + " " + "Kilonuz Fazla");
                        textViewSonuc.setBackgroundColor(Color.GREEN);
                    }
                }

            }
        });

       gunlukgecis.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentObj2 = new Intent(MainActivity.this,GunlukKalori.class);
               startActivity(intentObj2);
           }
       });

        sabahgecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj2 = new Intent(MainActivity.this,Cesitler.class);
                sabahcontrol = 1;
                shePre.dosyayaIntVeriYaz(context,sabahcontrol,"intKeyControlSabah");
                shePre.dosyayaIntVeriYaz(context,0,"intKeyControlOgle");
                shePre.dosyayaIntVeriYaz(context,0,"intKeyControlAksam");

//                saveData3(sabahcontrol);
                startActivity(intentObj2);
            }
        });

        sabahogun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sabahKayit = shePre.dosyadanStringVeri0ku(context,"sKey1");
                sabahyemekTxt.setText(sabahKayit);
                if (isVisible) {
                    linearLayout1.setVisibility(View.GONE);
                    isVisible = false;
                    sabahogun.setText(String.valueOf("<"));


                } else {
                    linearLayout1.setVisibility(View.VISIBLE);
                    isVisible = true;
                    sabahogun.setText(String.valueOf("v"));
                }
            }
        });



        oglengecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj2 = new Intent(MainActivity.this,Cesitler.class);
                oglecontrol = 2;
                shePre.dosyayaIntVeriYaz(context,0,"intKeyControlSabah");
                shePre.dosyayaIntVeriYaz(context,oglecontrol,"intKeyControlOgle");
                shePre.dosyayaIntVeriYaz(context,0,"intKeyControlAksam");

//                saveData3(sabahcontrol);
                startActivity(intentObj2);
            }
        });

        ogleogun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ogleKayit = shePre.dosyadanStringVeri0ku(context,"sKey2");
                oglenyemekTxt.setText(ogleKayit);
                if (isVisible) {
                    linearLayout2.setVisibility(View.GONE);
                    isVisible = false;
                    sabahogun.setText(String.valueOf("<"));

                } else {
                    linearLayout2.setVisibility(View.VISIBLE);
                    isVisible = true;
                    sabahogun.setText(String.valueOf("v"));
                }
            }
        });

        aksamgecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj2 = new Intent(MainActivity.this,Cesitler.class);
                aksamcontrol = 3;
                shePre.dosyayaIntVeriYaz(context,0,"intKeyControlSabah");
                shePre.dosyayaIntVeriYaz(context,0,"intKeyControlOgle");
                shePre.dosyayaIntVeriYaz(context,aksamcontrol,"intKeyControlAksam");
//                saveData3(sabahcontrol);
                startActivity(intentObj2);
            }
        });

        aksamogun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aksamKayit = shePre.dosyadanStringVeri0ku(context,"sKey3");
                aksamyemekTxt.setText(aksamKayit);
                if (isVisible) {
                    linearLayout3.setVisibility(View.GONE);
                    isVisible = false;
                    sabahogun.setText(String.valueOf("<"));

                } else {
                    linearLayout3.setVisibility(View.VISIBLE);
                    isVisible = true;
                    sabahogun.setText(String.valueOf("v"));
                }
            }
        });

        hakkimizdagecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj1 = new Intent(MainActivity.this,deneme.class);
                startActivity(intentObj1);

            }
        });

        vkigecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj1 = new Intent(MainActivity.this,GrafikVki.class);
                intentObj1.putExtra("sayiAnahtarindeks", indeksonuc);
                startActivity(intentObj1);
            }
        });

        grafikbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj1 = new Intent(MainActivity.this,BarChartActivity.class);
                startActivity(intentObj1);
            }
        });


    }

    private void saveData(int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_VARIABLE1, value);
        editor.apply();
    }

    private int getData() {

        return sharedPreferences.getInt(KEY_VARIABLE1, 0);
    }

    private void saveData2(int value2) {
        SharedPreferences.Editor editor = sharedPreferences2.edit();
        editor.putInt(KEY_VARIABLE2, value2);
        editor.apply();
    }

    private int getData2() {
        return sharedPreferences2.getInt(KEY_VARIABLE2, 0);
    }

    private void saveData3(int value3) {
        SharedPreferences.Editor editor = sharedPreferences3.edit();
        editor.putInt(KEY_VARIABLE3, value3);
        editor.apply();
    }

    private int getData3() {
        return sharedPreferences3.getInt(KEY_VARIABLE3, 0);
    }

    private void saveData4(int value4) {
        SharedPreferences.Editor editor = sharedPreferences4.edit();
        editor.putInt(KEY_VARIABLE4, value4);
        editor.apply();
    }

    private int getData4() {
        return sharedPreferences4.getInt(KEY_VARIABLE4, 0);
    }
    private void saveData5(int value5) {
        SharedPreferences.Editor editor = sharedPreferences5.edit();
        editor.putInt(KEY_VARIABLE5, value5);
        editor.apply();
    }

    private int getData5() {
        return sharedPreferences5.getInt(KEY_VARIABLE5, 0);
    }


    private void saveData6(String text1) {
        SharedPreferences.Editor editor = sharedPreferences6.edit();
        editor.putString(KEY_STRING1, text1);
        editor.apply();
    }

    private String getData6() {
        return sharedPreferences6.getString(KEY_STRING1,"");
    }

    private void saveData7(String text2) {
        SharedPreferences.Editor editor = sharedPreferences7.edit();
        editor.putString(KEY_STRING2, text2);
        editor.apply();
    }

    private String getData7() {
        return sharedPreferences7.getString(KEY_STRING2,"");
    }

    private void saveData8(String text3) {
        SharedPreferences.Editor editor = sharedPreferences8.edit();
        editor.putString(KEY_STRING3, text3);
        editor.apply();
    }

    private String getData8() {
        return sharedPreferences8.getString(KEY_STRING3,"");
    }




}

