package com.example.hizkia.train_tracker_kv2;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ASUS on 2/8/2018.
 */

public class Database {
    //private ArrayList<Train> trains;
    private static HashMap <String,Station> stationInfo;
    private static HashMap <String,Train> trainInfo;
    private String[] listOfTrains;
    private int ctList; // counter for number of trains

    public Database(){
        //this.trains = new ArrayList<>();
        this.listOfTrains = new String [2]; // initial value : set length of list is 50 trains
        this.ctList = 0;
        stationInfo = new HashMap<>();
        trainInfo = new HashMap<>();
        //Station
        initStation();
        //train
        initTrain();
    }

    public static Station getStationInfo (String nameOfStation){
        return stationInfo.get(nameOfStation);
    }
    public Train getTrainInfo (String nameOfTrain){
        return this.trainInfo.get(nameOfTrain);
    }

    public String[] getListOfTrains(){
        return this.listOfTrains;
    }

    public void initStation (){

        stationInfo.put("Stasiun Bandung", new Station("Stasiun Bandung", -6.912594, 107.602400));
        stationInfo.put("Stasiun Cimahi", new Station("Stasiun Cimahi", -6.885734, 107.536124));
        stationInfo.put("Stasiun Purwakarta", new Station("Stasiun Purwakarta", -6.5529825,107.4452251));
        stationInfo.put("Stasiun Cikampek", new Station("Stasiun Cikampek", -6.406378, 107.458955));
        stationInfo.put("Stasiun Haurgeulis", new Station("Stasiun Haurgeulis", -6.458553, 107.940902));
        stationInfo.put("Stasiun Jatibarang", new Station("Stasiun Jatibarang", -6.473079, 108.306333));
        stationInfo.put("Stasiun Cirebon", new Station("Stasiun Cirebon", -6.705298, 108.555399));
        stationInfo.put("Stasiun Tegal", new Station("Stasiun Tegal", -6.867345, 109.142687));
        stationInfo.put("Stasiun Pekalongan", new Station("Stasiun Pekalongan", -6.889684, 109.664378));
        stationInfo.put("Stasiun Semarang Tawang", new Station("Stasiun Semarang Tawang", -6.964436, 110.427925));
        stationInfo.put("Stasiun Semarang Poncol", new Station("Stasiun Semarang Poncol", -6.972832, 110.414697));

        // untuk testing aplikasi
        stationInfo.put("unpar",new Station("unpar",-6.873485, 107.604630));
        stationInfo.put("ciwalk",new Station("ciwalk",-6.893640, 107.605595));
        stationInfo.put("istana plaza", new Station("istana plaza", -6.905661, 107.596791));
        stationInfo.put("haris", new Station("haris", -6.905661, 107.596791));
    }

    public void initTrain(){
        //Ciremai(Bandung - Semarang Tawang)
        Train ciremaiBandung_SemarangTawang = new Train("ciremaiBandung_SemarangTawang");
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Bandung"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Cimahi"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Purwakarta"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Cikampek"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Haurgeulis"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Jatibarang"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Tegal"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Pekalongan"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("Stasiun Semarang Tawang"));

        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Semarang Tawang"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Semarang Poncol"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Pekalongan"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Tegal"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Jatibarang"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Haurgeulis"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Cikampek"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Purwakarta"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Cimahi"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("Stasiun Bandung"));
        trainInfo.put("ciremaiBandung_SemarangTawang",ciremaiBandung_SemarangTawang);
        this.listOfTrains[ctList++] = "ciremaiBandung_SemarangTawang";


        //train testing
        Train testing = new Train ("testingTrain");
        testing.addArrivalTrack(stationInfo.get("unpar"));
        testing.addArrivalTrack(stationInfo.get("ciwalk"));
        testing.addArrivalTrack(stationInfo.get("istana plaza"));

        testing.addDepartureTrack((stationInfo.get("istana plaza")));
        testing.addDepartureTrack((stationInfo.get("ciwalk")));
        testing.addDepartureTrack((stationInfo.get("unpar")));

        trainInfo.put("testing",testing);
        this.listOfTrains[ctList++] = "testing";
    }

    //GET THE STATIONS TRAVERSED BY TRAIN from START_STATION to END_STATION
    //@param the name of start station and end station
    //@param arrival or departure track to be selected (0=departure, 1=arrival)
    public static ArrayList<Station> getStationOnTrack(String start, String end, int optionTrack){
        ArrayList<Station> listStations = new ArrayList<>();
        ArrayList<Station> fullTrack;
        if(optionTrack == 0){
            //departure track
            fullTrack = trainInfo.get(MainActivity.activeTrain).departureTrack;
        }else{
            //arrival track
            fullTrack = trainInfo.get(MainActivity.activeTrain).arrivalTrack;
        }
        //TAKE STATIONS THAT ARE ONLY PASSED FROM START STATION TO END STATION OF ALL STATIONS
        int i;
        boolean checkStart = false;
        for(i=0; i<fullTrack.size(); i++){
            if(checkStart){
                listStations.add(fullTrack.get(i));
                if(fullTrack.get(i).getNamaStasiun().equalsIgnoreCase(end)){
                    break;
                }
            }else{
                if(fullTrack.get(i).getNamaStasiun().equalsIgnoreCase(start)){
                    checkStart = true;
                    listStations.add(fullTrack.get(i));
                }
            }
        }
        return listStations;
    }
}