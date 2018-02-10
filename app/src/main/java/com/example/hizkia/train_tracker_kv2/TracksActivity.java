package com.example.hizkia.train_tracker_kv2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class TracksActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TracksActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    protected Button btnGoMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        this.btnGoMap = this.findViewById(R.id.btnGoMap);

        Spinner spCurr = (Spinner) findViewById(R.id.spinnerFrom);

        ArrayAdapter<String> currAdapt = new ArrayAdapter<String>(TracksActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listCurrent));
        currAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurr.setAdapter(currAdapt);

        Spinner spDest = (Spinner) findViewById(R.id.spinnerDestination);

        ArrayAdapter<String> destAdapt = new ArrayAdapter<String>(TracksActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.listDestination));
        destAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDest.setAdapter(destAdapt);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnGoMap.getId()) {
            Intent intent = new Intent(TracksActivity.this, MapsActivity.class);
            startActivity(intent);
        }
    }

    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(TracksActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //no error, user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //error occured, but we can fix it
            Log.d(TAG, "isServicesOK: an error occured");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(TracksActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void btnBackClicked(View view) {
        Intent backToTrains = new Intent(this, MainActivity.class);
        startActivity(backToTrains);
    }
}
