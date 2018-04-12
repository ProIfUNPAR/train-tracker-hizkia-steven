package com.example.hizkia.train_tracker_kv2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener{

    private static final String TAG = "TracksActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    private Button btnGoMap;
    private Button btnBack;
    protected Spinner spCurr, spDest;
    protected static String sourceStation, destStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);


        //SET ID FROM LAYOUT START
        this.btnGoMap = this.findViewById(R.id.btnGoMap);
        this.btnBack = this.findViewById(R.id.btnBack);
        this.spCurr = this.findViewById(R.id.spinnerCurrent);
        this.spDest = this.findViewById(R.id.spinnerDestination);
        //SET ID FROM LAYOUT END

        //SET ON CLICK LISTERNER FOR SPINNER START
        this.spCurr.setOnItemSelectedListener(this);
        this.spDest.setOnItemSelectedListener(this);
        //SET ON CLICK LISTERNER FOR SPINNER END

        //SET LISTENER START
        btnGoMap.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        //SET LISTENER END

        //GET list of stations from the chosen train
        Database db = new Database();
        ArrayList<Station>  listStations;
        if(MainActivity.isArrival){
            listStations = db.getTrainInfo(MainActivity.activeTrain).arrivalTrack;
        }else{
            listStations = db.getTrainInfo(MainActivity.activeTrain).departureTrack;
        }

        //move each name of station on list stations to array of string
        String[] arrStation = new String[listStations.size()];
        String[] sourceStation = new String[listStations.size()-1];
        String[] destStation = new String[listStations.size()-1];
        int i;
        for(i=0; i<arrStation.length; i++){
            arrStation[i] = listStations.get(i).getNamaStasiun();
            if(i!=arrStation.length-1)sourceStation[i] = arrStation[i];
            if(i!=0)destStation[i-1] = arrStation[i];
        }

        //SET ALL ADAPTER START
            //Adapter for current station
        ArrayAdapter<String> currAdapt = new ArrayAdapter<String>(TracksActivity.this,
                android.R.layout.simple_spinner_item,sourceStation);
        currAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurr.setAdapter(currAdapt);

            //Adapter for destination station
        final ArrayAdapter<String> destAdapt = new ArrayAdapter<String>(TracksActivity.this,
                android.R.layout.simple_spinner_item,destStation);
        destAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDest.setAdapter(destAdapt);

        final ArrayAdapter<String> fullStation = new ArrayAdapter<String>(TracksActivity.this,
                android.R.layout.simple_spinner_item,arrStation);
        destAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //SET ALL ADAPTER END

        //SET INITIAL INDEX OF SPINNER SOURCE AND SPINNER DESTINATION START
        spCurr.setSelection(0);
        spDest.setSelection(spDest.getAdapter().getCount()-1);
        //SET INITIAL INDEX END

        //SET LISTENER FOR SPINNER CURR
        spCurr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                int idxCurr = spCurr.getSelectedItemPosition();

                String[] arrStationChange = new String[destAdapt.getCount()-idxCurr];
                int i;
                for(i=0; i<arrStationChange.length; i++){
                    arrStationChange[i] = (String)fullStation.getItem(++idxCurr);
                    System.out.println(arrStationChange[i]);
                }

                //Adapter for new destination stations
                ArrayAdapter<String> destAdapt = new ArrayAdapter<String>(TracksActivity.this,
                        android.R.layout.simple_spinner_item,arrStationChange);
                destAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spDest.setAdapter(destAdapt);
                spDest.setSelection(spDest.getAdapter().getCount()-1); //set destination do last station
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    //PUT EVERY ONCLICK FUNCTION HERE
    //ONCLICK FUNCTION START
    @Override
    public void onClick(View view) {
        //Button Go Clicked
        if(view.getId() == btnGoMap.getId()) {
            Intent intent = new Intent(TracksActivity.this, MapsActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == btnBack.getId()){
            Intent intent = new Intent(TracksActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }
    //ONCLICK FUNCTION END

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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        sourceStation = this.spCurr.getSelectedItem().toString();
        //System.out.println("source = " + sourceStation);
        destStation = this.spDest.getSelectedItem().toString();
        //System.out.println("destination = " + destStation);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(TracksActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
