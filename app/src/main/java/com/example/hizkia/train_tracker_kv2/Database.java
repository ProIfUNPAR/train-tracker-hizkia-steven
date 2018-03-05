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
        stationInfo.put("Stasiun Bekasi", new Station("Stasiun Bekasi",-6.236140, 106.999412));
        stationInfo.put("Stasiun Jatinegara", new Station("Stasiun Jatinegara", -6.215092, 106.870360));
        stationInfo.put("Stasiun Gambir", new Station("Stasiun Gambir", -6.176770, 106.830642));
        stationInfo.put("Stasiun Surabaya Pasarturi", new Station("Stasiun Surabaya Pasarturi", -7.248049, 112.731153));
        stationInfo.put("Stasiun Lamongan", new Station("Stasiun Lamongan", -7.112545, 112.420176));
        stationInfo.put("Stasiun Babat", new Station("Stasiun Babat", -7.106191, 112.168764));
        stationInfo.put("Stasiun Bojonegoro", new Station("Stasiun Bojonegoro", -7.164278, 111.886681));
        stationInfo.put("Stasiun Cepu", new Station("Stasiun Cepu", -7.154512, 111.590826));
        stationInfo.put("Stasiun Ngrombo", new Station("Stasiun Ngrombo", -7.145438, 110.900774));
        stationInfo.put("Stasiun Pemalang", new Station("Stasiun Pemalang", -6.887310, 109.388225));
        stationInfo.put("Stasiun Jatinegara", new Station("Stasiun Jatinegara", -6.215092, 106.870372));
        stationInfo.put("Stasiun Pasarsenen", new Station("Stasiun Pasarsenen", -6.174940, 106.845394));
        stationInfo.put("Stasiun Arjawinangun", new Station("Stasiun Arjawinangun", -6.644666, 108.414547));
        stationInfo.put("Stasiun Brebes", new Station("Stasiun Brebes", -6.874526, 109.043867));
        stationInfo.put("Stasiun Tanjung", new Station("Stasiun Tanjung", -6.876940, 108.860412));
        stationInfo.put("Stasiun Losari", new Station("Stasiun Losari", -6.846387, 108.798258));
        stationInfo.put("Stasiun Babakan", new Station("Stasiun Babakan", -6.860797, 108.719837));
        stationInfo.put("Stasiun Manggarai", new Station("Stasiun Manggarai", -6.209923, 106.850209));
        stationInfo.put("Stasiun Surabaya Gubeng", new Station("Stasiun Surabaya Gubeng", -7.265379, 112.751976));
        stationInfo.put("Stasiun Boharan", new Station("Stasiun Boharan", -7.387942, 112.619717));
        stationInfo.put("Stasiun Mojokerto", new Station("Stasiun Mojokerto", -7.472396, 112.434042));
        stationInfo.put("Stasiun Jombang", new Station("Stasiun Jombang", -7.558042, 112.233613));
        stationInfo.put("Stasiun Nganjuk", new Station("Stasiun Nganjuk", -7.600248, 111.902754));
        stationInfo.put("Stasiun Wilangan", new Station("Stasiun Wilangan", -7.561197, 111.803764));
        stationInfo.put("Stasiun Madiun", new Station("Stasiun Madiun", -7.618827, 111.524393));
        stationInfo.put("Stasiun Solo Balapan", new Station("Stasiun Solo Balapan", -7.557018, 110.821418));
        stationInfo.put("Stasiun Klaten", new Station("Stasiun Klaten", -7.712341, 110.603023));
        stationInfo.put("Stasiun Yogyakarta", new Station("Stasiun Yogyakarta", -7.789196, 110.363489));
        stationInfo.put("Stasiun Purwokerto", new Station("Stasiun Purwokerto", -7.419225, 109.221920));
        stationInfo.put("Stasiun Kroya", new Station("Stasiun Kroya", -7.630119, 109.253541));
        stationInfo.put("Stasiun Kebumen", new Station("Stasiun Kebumen", -7.681910, 109.662124));
        stationInfo.put("Stasiun Kutoarjo", new Station("Stasiun Kutoarjo", -7.726045, 109.907127));
        stationInfo.put("Stasiun Sragen", new Station("Stasiun Sragen", -7.429325, 111.017840));
        stationInfo.put("Stasiun Kertosono", new Station("Stasiun Kertosono", -7.592114, 112.100626));
        stationInfo.put("Stasiun Sidoarjo", new Station("Stasiun Sidoarjo", -7.456881, 112.712853));
        stationInfo.put("Stasiun Bangil", new Station("Stasiun Bangil", -7.598890, 112.778318));
        stationInfo.put("Stasiun Pasuruan", new Station("Stasiun Pasuruan", -7.637872, 112.910008));
        stationInfo.put("Stasiun Probolinggo", new Station("Stasiun Probolinggo", -7.742786, 113.216006));
        stationInfo.put("Stasiun Klakah", new Station("Stasiun Klakah", -7.994092, 113.249374));
        stationInfo.put("Stasiun Tanggul", new Station("Stasiun Tanggul", -8.162861, 113.448378));
        stationInfo.put("Stasiun Rambipuji", new Station("Stasiun Rambipuji", -8.203396, 113.614408));
        stationInfo.put("Stasiun Jember", new Station("Stasiun Jember", -8.164783, 113.703603));
        stationInfo.put("Stasiun Malang", new Station("Stasiun Malang", -7.977501, 112.637028));
        stationInfo.put("Stasiun Malang Kotalama", new Station("Stasiun Malang Kotalama", -7.994870, 112.632595));
        stationInfo.put("Stasiun Kepanjen", new Station("Stasiun Kepanjen", -8.131978, 112.573287));
        stationInfo.put("Stasiun Wlingi", new Station("Stasiun Wlingi", -8.088333, 112.320039));
        stationInfo.put("Stasiun Blitar", new Station("Stasiun Blitar", -8.101339, 112.162802));
        stationInfo.put("Stasiun Tulungagung", new Station("Stasiun Tulungagung", -8.062899, 111.904490));
        stationInfo.put("Stasiun Kediri", new Station("Stasiun Kediri", -7.817229, 112.015548));
        stationInfo.put("Stasiun Paron", new Station("Stasiun Paron", -7.442100, 111.386396));
        stationInfo.put("Stasiun Gombong", new Station("Stasiun Gombong", -7.610921, 109.507769));
        stationInfo.put("Stasiun Sumpiuh", new Station("Stasiun Sumpiuh", -7.615362, 109.361168));
        stationInfo.put("Stasiun Banjar", new Station("Stasiun Banjar", -7.376311, 108.542273));
        stationInfo.put("Stasiun Tasikmalaya", new Station("Stasiun Tasikmalaya", -7.322346, 108.223812));
        stationInfo.put("Stasiun Cipeundeuy", new Station("Stasiun Cipeundeuy", -7.094600, 108.103213));
        stationInfo.put("Stasiun Kiaracondong", new Station("Stasiun Kiaracondong", -6.924958, 107.646301));
        stationInfo.put("Stasiun Walikukun", new Station("Stasiun Walikukun", -7.398850, 111.224695));
        stationInfo.put("Stasiun Kalisat", new Station("Stasiun Kalisat", -8.126872, 113.812322));
        stationInfo.put("Stasiun Kalibaru", new Station("Stasiun Kalibaru", -8.288863, 113.984387));
        stationInfo.put("Stasiun Kalisetail", new Station("Stasiun Kalisetail", -8.302856, 114.139770));
        stationInfo.put("Stasiun Temuguruh", new Station("Stasiun Temuguruh", -8.309795, 114.201957));
        stationInfo.put("Stasiun Rogojampi", new Station("Stasiun Rogojampi", -8.304504, 114.292583));
        stationInfo.put("Stasiun Karangasem", new Station("Stasiun Karangasem", -8.222878, 114.340794));
        stationInfo.put("Stasiun Banyuwangi", new Station("Stasiun Banyuwangi", -8.141181, 114.397141));
        //stationInfo.put("Stasiun ", new Station("Stasiun ", ));

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

        trainInfo.put("Ciremai | Bandung - Semarang Tawang",ciremaiBandung_SemarangTawang);
        this.listOfTrains[ctList++] = "Ciremai | Bandung - Semarang Tawang";


        //Argo Parahyangan
        //Bandung - Gambir
        Train argoParahyangan = new Train("Argo Parahyangan");
        argoParahyangan.addDepartureTrack(stationInfo.get("Stasiun Bandung"));
        argoParahyangan.addDepartureTrack(stationInfo.get("Stasiun Purwakarta"));
        argoParahyangan.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        argoParahyangan.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        argoParahyangan.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Bandung
        argoParahyangan.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        argoParahyangan.addArrivalTrack(stationInfo.get("Stasiun Bekasi"));
        argoParahyangan.addArrivalTrack(stationInfo.get("Stasiun Purwakarta"));
        argoParahyangan.addArrivalTrack(stationInfo.get("Stasiun Cimahi"));
        argoParahyangan.addArrivalTrack(stationInfo.get("Stasiun Bandung"));
        trainInfo.put("Argo Parahyangan | Bandung - Gambir",argoParahyangan);
        this.listOfTrains[ctList++] = "Argo Parahyangan | Bandung - Gambir";

        //Gumarang
        Train gumarang =  new Train("Gumarang");
        //Surabaya Pasar Turi - Pasarsenen
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Surabaya Pasarturi"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Lamongan"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Babat"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Bojonegoro"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Cepu"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Ngrombo"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Semarang Tawang"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Pekalongan"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Pemalang"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Tegal"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Jatibarang"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        gumarang.addDepartureTrack(stationInfo.get("Stasiun Pasarsenen"));
        //Pasarsenen - Surabaya Pasar Turi
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Pasarsenen"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Jatibarang"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Tegal"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Pemalang"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Pekalongan"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Semarang Tawang"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Ngrombo"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Cepu"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Bojonegoro"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Babat"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Lamongan"));
        gumarang.addArrivalTrack(stationInfo.get("Stasiun Surabaya Pasarturi"));
        trainInfo.put("Gumarang | Surabaya Pasar Turi - Pasarsenen",gumarang);
        this.listOfTrains[ctList++] = "Gumarang | Surabaya Pasar Turi - Pasarsenen";


        //Cirebon Ekspres
        Train cirebonEkspres = new Train("Cirebon Ekspres");
        //Cirebon - Gambir
        cirebonEkspres.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        cirebonEkspres.addDepartureTrack(stationInfo.get("Stasiun Jatibarang"));
        cirebonEkspres.addDepartureTrack(stationInfo.get("Stasiun Haurgeulis"));
        cirebonEkspres.addDepartureTrack(stationInfo.get("Stasiun Cikampek"));
        cirebonEkspres.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        cirebonEkspres.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        cirebonEkspres.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Cirebon
        cirebonEkspres.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        cirebonEkspres.addArrivalTrack(stationInfo.get("Stasiun Bekasi"));
        cirebonEkspres.addArrivalTrack(stationInfo.get("Stasiun Haurgeulis"));
        cirebonEkspres.addArrivalTrack(stationInfo.get("Stasiun Jatibarang"));
        cirebonEkspres.addArrivalTrack(stationInfo.get("Stasiun Arjawinangun"));
        cirebonEkspres.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        trainInfo.put("Cirebon Ekspres_| Cirebon - Gambir",cirebonEkspres);
        this.listOfTrains[ctList++] = "Cirebon Ekspres_| Cirebon - Gambir";


        //Tegal Bahari
        Train tegalBahari = new Train("Tegal Bahari");
        //Tegal - Gambir
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Tegal"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Brebes"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Tanjung"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Losari"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Babakan"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Arjawinangun"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Jatibarang"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Haurgeulis"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Manggarai"));
        tegalBahari.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Tegal
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Manggarai"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Bekasi"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Haurgeulis"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Jatibarang"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Babakan"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Loasri"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Tanjung"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Brebes"));
        tegalBahari.addArrivalTrack(stationInfo.get("Stasiun Tegal"));;
        trainInfo.put("Tegal Bahari | Tegal - Gambir",tegalBahari);
        this.listOfTrains[ctList++] = "Tegal Bahari | Tegal - Gambir";


        //Sancaka
        Train sancaka = new Train("Sancaka");
        //Surabaya Gubeng - Yogyakarta
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Boharan"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Mojokerto"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Jombang"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Nganjuk"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Wilangan"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Klaten"));
        sancaka.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        //Yogyakarta - Surabaya Gubeng
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Klaten"));
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Nganjuk"));
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Jombang"));
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Mojokerto"));
        sancaka.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        trainInfo.put("Sancaka | Surabaya Gubeng - Yogyakarta",sancaka);
        this.listOfTrains[ctList++] = "Sancaka | Surabaya Gubeng - Yogyakarta";


        //Ranggajati Ekspres
        Train ranggajatiEkspres = new Train("Ranggajati Ekspres");
        // Cirebon - Jember
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Kebumen"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Klaten"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Sragen"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Nganjuk"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Kertosono"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Jombang"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Mojokerto"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Bangil"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Pasuruan"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Probolinggo"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Klakah"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Tanggul"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Rambipuji"));
        ranggajatiEkspres.addDepartureTrack(stationInfo.get("Stasiun Jember"));
        //Jember - Cirebon
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Jember"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Rambipuji"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Tanggul"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Klakah"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Prbolinggo"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Bangil"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Sidoarjo"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Mojokerto"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Jombang"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Kertosono"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Nganjuk"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Sragen"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Klaten"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Kebumen"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        ranggajatiEkspres.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        trainInfo.put("Ranggajati Ekspres | Cirebon - Jember",ranggajatiEkspres);
        this.listOfTrains[ctList++] = "Ranggajati Ekspres | Cirebon - Jember";


        //Malabar
        Train malabar = new Train("Malabar");
        //Malang - Bandung
        malabar.addDepartureTrack(stationInfo.get("Stasiun Malang"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Malang Kotalama"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Kepanjen"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Wlingi"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Blitar"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Tulungagung"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Kediri"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Kertosono"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Nganjuk"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Paron"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Sragen"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Kebumen"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Gombong"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Sumpiuh"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Banjar"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Tasikmalaya"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Cipeundeuy"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Kiaracondong"));
        malabar.addDepartureTrack(stationInfo.get("Stasiun Bandung"));
        //Bandung - Malang
        malabar.addArrivalTrack(stationInfo.get("Stasiun Bandung"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Kiaracondong"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Cipeundeuy"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Tasikmalaya"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Banjar"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Gombong"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Kebumen"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Walikukun"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Paron"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Nganjuk"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Kertosono"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Kediri"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Tulungagung"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Blitar"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Wlingi"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Kepanjen"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Malang Kotalama"));
        malabar.addArrivalTrack(stationInfo.get("Stasiun Malang"));
        trainInfo.put("Malabar | Malang - Bandung",malabar);
        this.listOfTrains[ctList++] = "Malabar | Malang - Bandung";


        //Mutiara Timbur
        Train mutiaraTimur = new Train("Mutiara Timur");
        //Surabaya Gubeng - Banyuwangi
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Sidoarjo"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Bangil"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Probolinggo"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Tanggul"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Rambipuji"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Jember"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Kalisat"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Kalibaru"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Kalisetail"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Temuguruh"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Rogojampi"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Karangasem"));
        mutiaraTimur.addDepartureTrack(stationInfo.get("Stasiun Banyuwangi"));
        //Banyuwangi - Surabaya Gubeng
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Banyuwangi"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Karangasem"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Rogojampi"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Temuguruh"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Kalisetail"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Kalibaru"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Kalisat"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Jember"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Rambipuji"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Tanggul"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Probolinggo"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Bangil"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Sidoarjo"));
        mutiaraTimur.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        trainInfo.put("Mutiara Timur | Surabaya Gubeng - Banyuwangi",mutiaraTimur);
        this.listOfTrains[ctList++] = "Mutiara Timur | Surabaya Gubeng - Banyuwangi";


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