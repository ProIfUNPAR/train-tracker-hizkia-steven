package com.example.hizkia.train_tracker_kv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDir = (Button) findViewById(R.id.btnDirections);
        btnDir.setEnabled(false);

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

    public void btnRoutesClicked(View view) {
        Intent openRoutes = new Intent(this, Routes.class);
        startActivity(openRoutes);
    }
}
