package com.example.fitapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class GrafikVki extends Activity {


    SeekBar seekbar1;
    TextView text1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitleendeksgrafik);

        Intent intent1 = getIntent();
        float alinanSayi1 = intent1.getFloatExtra("sayiAnahtarindeks", 0);

        seekbar1 = findViewById(R.id.seekBar2);
        text1 = findViewById(R.id.textviewSeek);

        int intValue = (int) alinanSayi1;
        seekbar1.setMax(50);
        seekbar1.setProgress(intValue);
        text1.setText(String.valueOf(intValue));


        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//                int value = progress / 2;
//
//                // İşlemi gerçekleştirin ve sonucu güncelleyin
//                int result = value;
//                text1.setText(String.valueOf(result));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }
            //region Benim method
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
            //endregion
        });








    }


}
