package com.example.fitapp2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesSinifi {
     static final String dosyaAdi = "dosya1.dat";

    public void dosyayaStringVeriYaz(Context context, String metin, String key) {
        SharedPreferences shePre = context.getSharedPreferences(dosyaAdi, Context.MODE_PRIVATE);
        SharedPreferences.Editor sheEditor = shePre.edit();
        sheEditor.putString(key, metin);
        sheEditor.apply();

    }


    public String dosyadanStringVeri0ku(Context context, String key) {
        SharedPreferences shePre = context.getSharedPreferences(dosyaAdi, Context.MODE_PRIVATE);
        return shePre.getString(key, null);
    }


    public void dosyayaIntVeriYaz(Context context, int sayi, String key) {
        SharedPreferences shePre = context.getSharedPreferences(dosyaAdi, Context.MODE_PRIVATE);
        SharedPreferences.Editor sheEditor = shePre.edit();
        sheEditor.putInt(key, sayi);
        sheEditor.apply();
    }



    public int dosyadanIntVeriOku(Context context,String key) {

        SharedPreferences shePre = context.getSharedPreferences(dosyaAdi, Context.MODE_PRIVATE);
        return shePre.getInt(key,0);
    }


    public void dosyayaFloatVeriYaz(Context context, float sayi, String key) {
        SharedPreferences shePre = context.getSharedPreferences(dosyaAdi, Context.MODE_PRIVATE);
        SharedPreferences.Editor sheEditor = shePre.edit();
        sheEditor.putFloat(key, sayi);
        sheEditor.apply();
    }



    public float dosyadanFloatVeriOku(Context context,String key) {

        SharedPreferences shePre = context.getSharedPreferences(dosyaAdi, Context.MODE_PRIVATE);
        return shePre.getFloat(key,0);
    }




}
