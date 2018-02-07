package com.example.hizkia.train_tracker_kv2;

/**
 * Created by Raymond on 2/7/2018.
 */

public class Station {
    private double longitude;
    private double latitude;
    private String name;

    Station(String name, double longitude, double latitude){
        this.name=name;
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public String getName(){
        return this.name;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public double getLatitude(){
        return this.latitude;
    }
}
