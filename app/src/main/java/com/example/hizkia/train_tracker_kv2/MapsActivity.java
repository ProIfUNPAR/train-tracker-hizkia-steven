package com.example.hizkia.train_tracker_kv2;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
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

    private TextView tvDistance, tvEta, tvSpeed, txtStation, tvDistanceNext, tvEtaNext, txtStationNext;
    private Location tempLocation1, tempLocation2, currLocation;
    private float totalDistance;
    private String sourceStation, destStation;
    private ArrayList<Station> listStations;
    private int ct;

    private Polyline line;
    private PolylineOptions lineOpt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getLocationPermission();

        this.tvSpeed = this.findViewById(R.id.valueSpeed);
        this.tvDistance = this.findViewById(R.id.valueDistance);
        this.tvEta = this.findViewById(R.id.valueETA);
        this.txtStation = this.findViewById(R.id.txtStationDetail);
        this.tvDistanceNext = this.findViewById(R.id.valueDistanceNext);
        this.tvEtaNext = this.findViewById(R.id.valueETANext);
        this.txtStationNext = this.findViewById(R.id.txtStationNext);


        this.sourceStation = TracksActivity.sourceStation;
        this.destStation = TracksActivity.destStation;
        //this.txtStation.setText(this.sourceStation + " - "+ this.destStation);


        this.totalDistance = 0;
        this.ct = 0;
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

    private void getDeviceLocation(final ArrayList<Station> listStations){
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
                            currLocation = (Location) task.getResult();

                            moveCamera(new LatLng(currLocation.getLatitude(), currLocation.getLongitude()), DEFAULT_ZOOM);
                        } else {
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                for(int i = 0; i < listStations.size() - 1; i++){
                    Station temp1 = listStations.get(i);
                    Station temp2 = listStations.get(i + 1);


                    tempLocation1 = new Location("");
                    tempLocation1.setLatitude(temp1.getLatitude());
                    tempLocation1.setLongitude(temp1.getLongitude());

                    tempLocation2 = new Location("");
                    tempLocation2.setLatitude(temp2.getLatitude());
                    tempLocation2.setLongitude(temp2.getLongitude());

                    totalDistance += calculateDistance(tempLocation1, tempLocation2);
                }

                txtStation.setText(listStations.get(listStations.size() - 1).getNamaStasiun());
                tvDistance.setText(String.format("%.1f", totalDistance));
                tvEta.setText(calculateETA(30, totalDistance));

                if(ct == 0) {
                    tempLocation1 = new Location("");
                    tempLocation1.setLongitude(listStations.get(0).getLongitude());
                    tempLocation1.setLatitude(listStations.get(0).getLatitude());


                    tempLocation2 = new Location("");
                    tempLocation2.setLongitude(listStations.get(1).getLongitude());
                    tempLocation2.setLatitude(listStations.get(1).getLatitude());
                    float initialDistance = calculateDistance(tempLocation1, tempLocation2);

                    txtStationNext.setText(listStations.get(1).getNamaStasiun());
                    tvDistanceNext.setText(String.format("%.1f", initialDistance));
                    tvEtaNext.setText(calculateETA(30, initialDistance));
                }

                LocationManager locManager = (LocationManager) this
                        .getSystemService(Context.LOCATION_SERVICE);
                LocationListener locListener = new LocationListener() {

                    @Override
                    public void onLocationChanged(Location location) {
                        //location.getLatitude();
                        //Toast.makeText(getApplicationContext(), "Current speed:" + location.getSpeed(),
                                //Toast.LENGTH_SHORT).show();

                        currLocation = location;
                        float speed = calculateSpeed();
                        tvSpeed.setText(String.format("%.1f", speed));

                        Station curStation = listStations.get(ct);
                        tempLocation1 = new Location("");
                        tempLocation1.setLongitude(curStation.getLongitude());
                        tempLocation1.setLatitude(curStation.getLatitude());
                        float distanceCurr = calculateDistance(currLocation, tempLocation1);

                        if(ct > 0){
                            tvDistanceNext.setText(String.format("%.1f", distanceCurr));
                            tvEtaNext.setText(calculateETA(speed, distanceCurr));
                        }

                        if (distanceCurr <= 10 && ct < listStations.size()) {
                            ct++;
                            if (ct == listStations.size()) {
                                notificationCall("Your train has arrived!");
                            }
                            else {
                                Station nextStation = listStations.get(ct);
                                txtStationNext.setText(nextStation.getNamaStasiun());

                                tempLocation2 = new Location("");
                                tempLocation2.setLongitude(nextStation.getLongitude());
                                tempLocation2.setLatitude(nextStation.getLatitude());

                                totalDistance = totalDistance - calculateDistance(tempLocation1, tempLocation2);
                            }
                        }
                        float distance = totalDistance + distanceCurr;
                        tvDistance.setText(String.format("%.1f", distance));

                        String eta = calculateETA(speed, distance);
                        tvEta.setText(eta);
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
                        1, locListener);
                locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
        } catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation(): SecurityException: " + e.getMessage());
        }
    }

    public void notificationCall(String message){
        NotificationCompat.Builder nb = new NotificationCompat.Builder(this, "default")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                //SET NOTIFICATION SMALL ICON
                .setSmallIcon(R.drawable.trainicon)
                //SET NOTIFICATION LARGE ICON
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.trainicon))
                //NOTIFICATION TITLE
                .setContentTitle("TRAIN_TRACKER_KV2")
                //NOTIFICATION CONTENT
                .setContentText(message);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, nb.build());
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

    public float calculateSpeed(){
        float speed = currLocation.getSpeed();
        speed = speed * 3600 / 1000;
        return speed;
    }

    public float calculateDistance(Location loc1, Location loc2){
        return loc1.distanceTo(loc2) / 1000;
    }

    public String calculateETA(float speed, float distance){
        float eta;
        if(speed <= 30)eta = distance / 30;
        else eta = distance / speed;
        if(eta < 0.09)notificationCall("Your train will arrive in 5 minutes!");
        int second = (int)(((eta % 1) * 3600) % 60);
        int minute = (int)((eta % 1) * 60 ) % 60;
        int hour = (int)(eta);
        String resultTimeText = String.format("%02d H : %02d M : %02d S",hour, minute, second);
        return resultTimeText;
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(MapsActivity.this, TracksActivity.class);
        startActivity(intent);
    }
}