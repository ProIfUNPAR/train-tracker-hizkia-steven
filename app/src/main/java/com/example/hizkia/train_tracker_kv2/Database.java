package com.example.hizkia.train_tracker_kv2;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ASUS on 2/8/2018.
 */

public class Database {
    private ArrayList<Train> trains;
    private HashMap <String,Station> stationInfo;

    public Database(){
        this.trains = new ArrayList<>();
        this.stationInfo = new HashMap<>();
        //Station

        //train

    }

    public void initStation (){

        stationInfo.put("stBandung", new Station("Stasiun Bandung", -6.912594, 107.602400));
        stationInfo.put("stCimahi", new Station("Stasiun Cimahi", -6.885734, 107.536124));
        stationInfo.put("stPurwakarta", new Station("Stasiun Purwakarta", -6.5529825,107.4452251));
        stationInfo.put("stCikampek", new Station("Stasiun Cikampek", -6.406378, 107.458955));
        stationInfo.put("stHaurgeulis", new Station("Stasiun Haurgeulis", -6.458553, 107.940902));
        stationInfo.put("stJatibarang", new Station("Stasiun Jatibarang", -6.473079, 108.306333));
        stationInfo.put("stCirebon", new Station("Stasiun Cirebon", -6.705298, 108.555399));
        stationInfo.put("stTegal", new Station("Stasiun Tegal", -6.867345, 109.142687));
        stationInfo.put("stPekalongan", new Station("Stasiun Pekalongan", -6.889684, 109.664378));
        stationInfo.put("stSemarangTawang", new Station("Stasiun Semarang Tawang", -6.964436, 110.427925));
        stationInfo.put("stSemarangPoncol", new Station("Stasiun Semarang Poncol", -6.972832, 110.414697));

        // untuk testing aplikasi
        stationInfo.put("stUnpar",new Station("unpar",-6.873485, 107.604630));
        stationInfo.put("stCiwalk",new Station("ciwalk",-6.893640, 107.605595));
        stationInfo.put("stIP", new Station("istana plaza", -6.905661, 107.596791));
        stationInfo.put("stHaris", new Station("haris", -6.905661, 107.596791));
    }

    public void initTrain(){
        //Ciremai(Bandung - Semarang Tawang)
        Train ciremaiBandung_SemarangTawang = new Train("ciremaiBandung_SemarangTawang");
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stBandung"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stCimahi"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stPurwakarta"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stCikampek"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stHaurgeulis"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stJatibarang"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stCirebon"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stTegal"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stPekalongan"));
        ciremaiBandung_SemarangTawang.addArrivalTrack(stationInfo.get("stSemarangTawang"));

        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stSemarangTawang"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stSemarangPoncol"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stPekalongan"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stTegal"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stCirebon"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stJatibarang"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stHaurgeulis"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stCikampek"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stPurwakarta"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stCimahi"));
        ciremaiBandung_SemarangTawang.addDepartureTrack(stationInfo.get("stBandung"));
        trains.add(ciremaiBandung_SemarangTawang);

        //train testing
        Train testing = new Train ("testingTrain");
        testing.addArrivalTrack(stationInfo.get("stUnpar"));
        testing.addArrivalTrack(stationInfo.get("stCiwalk"));
        testing.addArrivalTrack(stationInfo.get("stIP"));

        testing.addDepartureTrack((stationInfo.get("stIP")));
        testing.addDepartureTrack((stationInfo.get("stCiwalk")));
        testing.addDepartureTrack((stationInfo.get("stUnpar")));

        trains.add(testing);
    }
}