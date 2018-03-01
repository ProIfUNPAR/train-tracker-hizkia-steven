package com.example.hizkia.train_tracker_kv2;

/**
 * Created by ASUS on 2/8/2018.
 */

public class Station {
    private String name;
    private double latitude; //menentukan lokasi berada di utara atau selatan ekuator (0 derajat khatulistiwa sampai 90 derajat di kutub)
    private double longitude; // menentukan lokasi di wilayah barat atau timur dari garis meridian (0 derajat greenwich sampai 180 derajat international date line)
    //private String city;

    public Station (String name, double latitude, double longitude){
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        //this.city = city;
    }

    public String getNamaStasiun(){
        return this.name;
    }
    /*public String getCity(){
        return this.city;
    }*/
    public double getLongitude(){
        return this.longitude;
    }
    public double getLatitude(){
        return this.latitude;
    }

}
