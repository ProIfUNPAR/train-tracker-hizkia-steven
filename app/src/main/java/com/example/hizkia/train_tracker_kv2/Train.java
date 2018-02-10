package com.example.hizkia.train_tracker_kv2;

import java.util.ArrayList;

/**
 * Created by ASUS on 2/8/2018.
 */

public class Train {
    public String trainName;
    public ArrayList <Station> departureTrack, arrivalTrack;

    public Train (String name){
        this.trainName = name;
        this.departureTrack = new ArrayList<>();
        this.arrivalTrack = new ArrayList<>();
    }

    public boolean addDepartureTrack (Station newStasiun){
        return(this.departureTrack.add(newStasiun));
    }
    public boolean addArrivalTrack (Station newStasiun){
        return(this.arrivalTrack.add(newStasiun));
    }
    //remove track hanya diperlukan parameter nama stasiun yang akan dihilangkan dari track
    public boolean removeDepartureStation (String remStasiun){
        int i;
        for(i=0; i<this.departureTrack.size(); i++){
            if(this.departureTrack.get(i).getNamaStasiun().equalsIgnoreCase(remStasiun)){
                this.departureTrack.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean removeArrivalStation (String remStasiun){
        int i;
        for(i=0; i<this.arrivalTrack.size(); i++){
            if(this.arrivalTrack.get(i).getNamaStasiun().equalsIgnoreCase(remStasiun)){
                this.arrivalTrack.remove(i);
                return true;
            }
        }
        return false;
    }
}