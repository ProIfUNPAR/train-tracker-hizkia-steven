package com.example.hizkia.train_tracker_kv2;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button btnNext;
    protected Spinner spTrains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET ID FROM LAYOUT START
        this.btnNext = this.findViewById(R.id.btnNext);
            //Untuk eksekutif nama-nama keretanya seperti Argo Jati, Argo Wilis, Sembrani, dll
        this.spTrains = this.findViewById(R.id.spinnerTrains);
        //SET ID FROM LAYOUT END

        //SET LISTENER START
        this.btnNext.setOnClickListener(this);
        //SET LISTENER END

        //SET ALL ADAPTER START
            //Adapter for list of Trains
        ArrayAdapter<String> trainsAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listOfTrains));
        trainsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTrains.setAdapter(trainsAdapter);
        //SET ALL ADAPTER END

    }

    //PUT EVERY ONCLICK FUNCTION HERE
    //ONCLICK FUNCTION START
    @Override
    public void onClick(View view) {
        //Button Next Clicked
        if(view.getId() == btnNext.getId()){
            Intent openTracks = new Intent(this, TracksActivity.class);
            startActivity(openTracks);
        }
    }
    //ONCLICK FUNCTION END

}
