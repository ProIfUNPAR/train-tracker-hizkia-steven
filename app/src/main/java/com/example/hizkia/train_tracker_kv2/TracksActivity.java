package com.example.hizkia.train_tracker_kv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TracksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        Spinner spFrom = (Spinner) findViewById(R.id.spinnerFrom);

        ArrayAdapter<String> fromAdapt = new ArrayAdapter<String>(TracksActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listOfFrom));
        currAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurr.setAdapter(currAdapt);

        Spinner spDest = (Spinner) findViewById(R.id.spinnerDestination);

        ArrayAdapter<String> destAdapt = new ArrayAdapter<String>(TracksActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listOfDestination));
        destAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDest.setAdapter(destAdapt);
    }

    public void btnGoClicked(View view) {
        Intent openMaps = new Intent(this, MapsActivity.class);
        startActivity(openMaps);
    }

    public void btnBackClicked(View view) {
        Intent backToTrains = new Intent(this, MainActivity.class);
        startActivity(backToTrains);
    }
}
