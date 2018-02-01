package com.example.hizkia.train_tracker_kv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner curr = (Spinner) findViewById(R.id.spinnerCurrent);

        ArrayAdapter<String> currAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listCurrent));
        currAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        curr.setAdapter(currAdapter);

        Spinner dest = (Spinner) findViewById(R.id.spinnerDestination);

        ArrayAdapter<String> destAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listDestination));
        destAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dest.setAdapter(destAdapter);
    }
}
