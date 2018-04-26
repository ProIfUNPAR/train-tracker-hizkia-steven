package com.example.hizkia.train_tracker_kv2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
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

        Log.d("TracksActivity", "tracks initialised");

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
        Log.d("idxSpCurInit", Database.idxSpCur + "");
        Log.d("idxSpDestInit", Database.idxSpDest + "");
        ArrayList<Station>  listStations;
        if(Database.isArrival){
            System.out.println("di sini :"+ Database.activeTrain);
            listStations = MainActivity.db.getTrainInfo(Database.activeTrain).arrivalTrack;
        }else{
            System.out.println("di sini :"+ Database.activeTrain);
            listStations = MainActivity.db.getTrainInfo(Database.activeTrain).departureTrack;
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
        if(Database.idxSpCur != -1){
            Log.d("idxSpCurTag",  Database.idxSpCur + " " + this.spCurr.getSelectedItem().toString());
            spCurr.setSelection(Database.idxSpCur);
            Log.d("idxSpCurTagAfter",  Database.idxSpCur + " " + this.spCurr.getSelectedItem().toString());
        }
        else{
            spCurr.setSelection(0);
            Database.idxSpCur = 0;
        }
        if(Database.idxSpDest != -1){
            Log.d("idxSpDestTag", Database.idxSpDest + " " + this.spDest.getSelectedItem().toString());
            spDest.setSelection(Database.idxSpDest);
            Log.d("idxSpDestTagAfter", Database.idxSpDest + " " + this.spDest.getSelectedItem().toString());
        }
        else{
            spDest.setSelection(spDest.getAdapter().getCount()-1);
            Database.idxSpDest = spDest.getAdapter().getCount()-1;
        }

        //SET INITIAL INDEX END

        //SET LISTENER FOR SPINNER CURR
        spCurr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                int idxCurr = spCurr.getSelectedItemPosition();
                int idxSpCurTemp = Database.idxSpCur;
                Database.idxSpCur = idxCurr;
                Log.d("idxSpCur", Database.idxSpCur + "");

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
                if(Database.idxSpDest != -1) {
                    Database.idxSpDest = idxSpCurTemp - Database.idxSpCur + Database.idxSpDest;
                    spDest.setSelection(Database.idxSpDest);
                }
                /*else{
                    spDest.setSelection(spDest.getAdapter().getCount()-1); //set destination do last station
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        //SET LISTENER FOR SPINNER DEST
        spDest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int idxDest = spDest.getSelectedItemPosition();
                Database.idxSpDest = idxDest;
                Log.d("idxSpDest", Database.idxSpDest + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //PUT EVERY ONCLICK FUNCTION HERE
    //ONCLICK FUNCTION START
    @Override
    public void onClick(View view) {
        //Button Go Clicked
        if(view.getId() == btnGoMap.getId()) {
            sourceStation = this.spCurr.getSelectedItem().toString();
            System.out.println("source = " + sourceStation);
            destStation = this.spDest.getSelectedItem().toString();
            System.out.println("destination = " + destStation);
            Intent intent = new Intent(TracksActivity.this, MapsActivity.class);
            //Check if GPS is ON or OFF
            if(this.getGPSStatus()){
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Please TURN ON your GPS", Toast.LENGTH_SHORT).show();
            }
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
        System.out.println("source = " + sourceStation);
        destStation = this.spDest.getSelectedItem().toString();
        System.out.println("destination = " + destStation);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    //Get if GPS status is ON/TRUE or OFF/FALSE
    public boolean getGPSStatus(){

        LocationManager locationManager;
        Context context = getApplicationContext();
        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    //Back to activity_main using device's back button
    @Override
    public void onBackPressed(){
        //Intent intent = new Intent(TracksActivity.this, MainActivity.class);
        //startActivity(intent);

        Intent intent = new Intent(TracksActivity.this, MainActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
