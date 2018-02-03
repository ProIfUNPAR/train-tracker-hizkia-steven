package com.example.hizkia.train_tracker_kv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Routes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        Button btnRou = (Button) findViewById(R.id.btnRoutes);
        btnRou.setEnabled(false);
    }

    public void btnDirectionsClicked(View view) {
        Intent openDirections = new Intent(this, MainActivity.class);
        startActivity(openDirections);
    }
}
