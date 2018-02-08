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

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    private Button btnGoMap;
    
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

        if(isServicesOK()){
            btnGoMap = this.findViewById(R.id.btnGoMap);
            btnGoMap.setOnClickListener(this);
        }

    }

    public void btnRoutesClicked(View view) {
        Intent openRoutes = new Intent(this, Routes.class);
        startActivity(openRoutes);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnGoMap.getId()) {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        }
    }

    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //no error, user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //error occured, but we can fix it
            Log.d(TAG, "isServicesOK: an error occured");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}
