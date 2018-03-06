package com.example.hizkia.train_tracker_kv2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQ_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;

    private Boolean locationPermissionGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private TextView tvDistance, tvEta, tvSpeed, txtStation;
    private Location tempLocation1, tempLocation2;
    private float totalDistance;
    private String sourceStation, destStation;

    private Polyline line;
    private PolylineOptions lineOpt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getLocationPermission();

        this.tvDistance = this.findViewById(R.id.valueDistance);
        this.tvEta = this.findViewById(R.id.valueETA);
        this.tvSpeed = this.findViewById(R.id.valueSpeed);
        this.txtStation = this.findViewById(R.id.txtStationDetail);


        this.sourceStation = TracksActivity.sourceStation;
        this.destStation = TracksActivity.destStation;
        this.txtStation.setText(this.sourceStation + " - "+ this.destStation);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: Map is Ready");
        mMap = googleMap;
        lineOpt =new PolylineOptions();

        if (locationPermissionGranted) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);

            Station startStation = Database.getStationInfo(this.sourceStation);
            LatLng start = new LatLng( startStation.getLatitude(),startStation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(start).title(startStation.getNamaStasiun()));
            lineOpt.add(start);
            //Log.d("onMapReady", "Latitude start: " + startStation.getLatitude());
            //Log.d("onMapReady", "Longitude start : " + startStation.getLongitude());

            //GET LIST OF STATIONS ON TRACK
            ArrayList<Station> listStations;
            if(!MainActivity.isArrival){
                listStations = Database.getStationOnTrack(this.sourceStation,this.destStation,0);
            }else{
                listStations = Database.getStationOnTrack(this.sourceStation,this.destStation,1);
            }
            //LOOP to ADD MARKER FOR EACH STATIONS ON TRACK
            int i;
            for(i=1; i<listStations.size()-1; i++){
                Station temp = listStations.get(i);
                LatLng addStation = new LatLng( temp.getLatitude(),temp.getLongitude());

                mMap.addMarker(new MarkerOptions().position(addStation).title(temp.getNamaStasiun())
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker)));
                lineOpt.add(addStation);

            }

            Station endStation = Database.getStationInfo(this.destStation);
            LatLng end = new LatLng( endStation.getLatitude(), endStation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(end).title(endStation.getNamaStasiun()));
            lineOpt.add(end);

            lineOpt.color(R.color.blue);
            line = mMap.addPolyline(lineOpt);

            getDeviceLocation(listStations);

        }
    }

    private void getDeviceLocation(ArrayList<Station> listStations){
        Log.d(TAG, "getDeviceLocation: getting current device location");
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if(locationPermissionGranted){
                Task location = fusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete: location found");
                            Location currLocation = (Location) task.getResult();

                            moveCamera(new LatLng(currLocation.getLatitude(), currLocation.getLongitude()), DEFAULT_ZOOM);
                        } else {
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                for(int i=1; i<listStations.size()-1; i++){
                    Station temp1 = listStations.get(i);
                    Station temp2 = listStations.get(i + 1);


                    tempLocation1 = new Location("");
                    tempLocation1.setLatitude(temp1.getLatitude());
                    tempLocation1.setLongitude(temp1.getLongitude());

                    tempLocation2 = new Location("");
                    tempLocation2.setLatitude(temp2.getLatitude());
                    tempLocation2.setLongitude(temp2.getLongitude());

                    totalDistance += tempLocation1.distanceTo(tempLocation2);
                }

                LocationManager locManager = (LocationManager) this
                        .getSystemService(Context.LOCATION_SERVICE);
                LocationListener locListener = new LocationListener() {

                    @Override
                    public void onLocationChanged(Location location) {
                        location.getLatitude();
                        //Toast.makeText(getApplicationContext(), "Current speed:" + location.getSpeed(),
                                //Toast.LENGTH_SHORT).show();
                        float speed = location.getSpeed();
                        speed = speed * 3600 / 1000;
                        tvSpeed.setText(speed + "Kph");
                        float distance = totalDistance / 1000;
                        tvDistance.setText(distance + "Km");
                        float eta = distance / speed;
                        tvEta.setText(eta + "");
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                };

                locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100,
                        10, locListener);
            }
        } catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation(): SecurityException: " + e.getMessage());
        }
    }

    private void moveCamera(LatLng latLng, float zoom){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng:" + latLng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    private void initMap(){
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);
    }

    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: get location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(), COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                locationPermissionGranted = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQ_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQ_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called");
        locationPermissionGranted = false;

        switch (requestCode){
            case LOCATION_PERMISSION_REQ_CODE:{
                if(grantResults.length > 0){
                    for (int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            locationPermissionGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permsission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    locationPermissionGranted = true;
                    //initialize map
                    initMap();
                }
            }
        }
    }
}