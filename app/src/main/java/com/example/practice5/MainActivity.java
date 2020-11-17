package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TimePicker tp;
    DatePicker datePicker;
    Chronometer meter;
    NumberPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tp = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.dp);
        meter = findViewById(R.id.cm);
        picker = findViewById(R.id.np);
        picker.setMinValue(1);
        picker.setMaxValue(100);

        int value = picker.getValue();


    }

    public void showTime(View view){
        int hours= tp.getCurrentHour();
        int mins = tp.getCurrentMinute();
         if( hours > 12){
             hours = hours-12;
             String h= Integer.toString(hours);
             String m= Integer.toString(mins);
             Toast.makeText(this, h + ":"+ m+"PM", Toast.LENGTH_SHORT).show();
         }
         else{
             String h= Integer.toString(hours);
             String m= Integer.toString(mins);
             Toast.makeText(this, h + ":"+ m+"AM", Toast.LENGTH_SHORT).show();
         }


    }

    public void showDate(View view){
        int day = datePicker.getFirstDayOfWeek();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Toast.makeText(this, day+"-"+month+"-"+year, Toast.LENGTH_SHORT).show();
    }

    public void Operations(View view){
        if ( view == findViewById(R.id.btn1)){
            meter.start();
        }
        if ( view == findViewById(R.id.btn2)){
            meter.stop();
        }
        if ( view == findViewById(R.id.btn3)){
            meter.setBase(SystemClock.elapsedRealtime());
            meter.start();
        }
        if ( view == findViewById(R.id.btn1)){
            meter.setFormat("Stop watch (%s)");

        }

    }

}