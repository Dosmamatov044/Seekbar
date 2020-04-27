package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {




    private TextView  textView1, textView2, textView3;

    int everyTimeOn=10;
    boolean one=false;


    private SeekBar seekBar;
    private TextView textView;


    private Button falsee;
    private Button truee;



    private static final String LOGTAG = "SeekBarDemo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //
        this.seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.textView = (TextView) findViewById(R.id.textView);




        this.falsee = (Button) findViewById(R.id.button_decrease);
        this.truee = (Button) findViewById(R.id.button_increase);

        this.seekBar.setMax(100);
        this.seekBar.setProgress(50);

        this.textView.setText("Progress: " + seekBar.getProgress() + "/" + seekBar.getMax());



        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;


            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                textView.setText("Progress: " + progressValue + "/" + seekBar.getMax());

                Toast.makeText(getApplicationContext(), "нажимай еще быстрее", Toast.LENGTH_LONG).show();



                ;
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Progress: " + progress + "/" + seekBar.getMax());

                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

            }
        });





        this.falsee.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                falseProgress();
            }
        });

        this.truee.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                trueProgress();
            }
        });
    }


    private void falseProgress() {
        int progress = this.seekBar.getProgress();
        if (progress - everyTimeOn < 0) {
            this.seekBar.setProgress(0);

        } else {
            this.seekBar.setProgress(progress - everyTimeOn);


        }
        textView.setText("Progress: " + seekBar.getProgress() + "/" + seekBar.getMax());

    }

    private void trueProgress() {
        int progress = this.seekBar.getProgress();
        if (progress + everyTimeOn > this.seekBar.getMax()) {
            this.seekBar.setProgress(0);
        } else {
            this.seekBar.setProgress(progress + everyTimeOn);
        }
        textView.setText("Progress: " + seekBar.getProgress() + "/" + seekBar.getMax());
    }





    }






