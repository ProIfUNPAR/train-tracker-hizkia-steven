package com.example.hizkia.train_tracker_kv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Untuk eksekutif nama-nama keretanya seperti Argo Jati, Argo Wilis, Sembrani, dll
        Spinner spTrains = (Spinner) findViewById(R.id.spinnerTrains);

        //Adapter for list of Trains
        ArrayAdapter<String> trainsAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listOfTrains));
        trainsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTrains.setAdapter(trainsAdapter);
    }

    public void btnNextClicked(View view) {
        Intent openTracks = new Intent(this, TracksActivity.class);
        startActivity(openTracks);
    }

}
