package com.example.hizkia.train_tracker_kv2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by ASUS on 2/8/2018.
 */

public class Database {
    //private ArrayList<Train> trains;
    private static TreeMap <String,Station> stationInfo;
    private static TreeMap <String,Train> trainInfo;
    private String[] listOfTrains;
    private int ctList; // counter for number of trains

    public static String activeTrain = "";
    public static boolean isArrival = false;
    public static int idxSpCur = -1, idxSpDest = -1;

    public Database(){
        //this.trains = new ArrayList<>();
        this.listOfTrains = new String [27]; // initial value : set length of list is 50 trains
        this.ctList = 0;
        stationInfo = new TreeMap<>();
        trainInfo = new TreeMap<>();
        //Station
        initStation();
        //train
        initTrain();

        /*
        //SET INITIAL ATTRIBUTE isArrival
        if(activeTrain == null){
            activeTrain = "";
            //SET INITIAL ATTRIBUTE isArrival
            isArrival = false;
        }
        //SET INITIAL ATTRIBUTE idxSpCur
        idxSpCur = -1;
        //SET INITIAL ATTRIBUTE idxSpDest
        idxSpDest = -1;
        */
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

        stationInfo.put("Stasiun Bandung", new Station("Stasiun Bandung",-6.912594, 107.602400));
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
        stationInfo.put("Stasiun Karanganyar", new Station("Stasiun Karanganyar", -7.633254, 109.573407));
        stationInfo.put("Stasiun Bumiayu", new Station("Stasiun Bumiayu", -7.237431, 109.009813));
        stationInfo.put("Stasiun Ciledug", new Station("Stasiun Ciledug", -6.903064, 108.743914));
        stationInfo.put("Stasiun Pasar Senen", new Station("Stasiun Pasar Senen", -6.174728, 106.844366));
        stationInfo.put("Stasiun Wates", new Station("Stasiun Wates",-7.859568, 110.157929));
        stationInfo.put("Stasiun Sidareja", new Station("Stasiun Sidareja",-7.486377, 108.807519));
        stationInfo.put("Stasiun Meluwung", new Station("Stasiun Meluwung",-7.394298, 108.699520));
        stationInfo.put("Stasiun Maos", new Station("Stasiun Maos",-7.619081, 109.139463));
        stationInfo.put("Stasiun Ijo", new Station("Stasiun Ijo",-7.615272, 109.446940));
        stationInfo.put("Stasiun Lawang", new Station("Stasiun Lawang",-7.836702, 112.697636));
        stationInfo.put("Stasiun Ciamis", new Station("Stasiun Ciamis",-7.329368, 108.355991));
        stationInfo.put("Stasiun Cicalengka", new Station("Stasiun Cicalengka",-6.981545, 107.832663));
        stationInfo.put("Stasiun Kemranjen", new Station("Stasiun Kemranjen",-7.621419, 109.314908));
        stationInfo.put("Stasiun Leles", new Station("Stasiun Leles",-7.084445, 107.899659));
        stationInfo.put("Stasiun Porong", new Station("Stasiun Porong",-7.538350, 112.701672));
        stationInfo.put("Stasiun Prembun", new Station("Stasiun Prembun",-7.724335, 109.798102));
        stationInfo.put("Stasiun Karang Anyar", new Station("Stasiun Karang Anyar",-7.633173, 109.573492));
        stationInfo.put("Stasiun Jeruk Legi", new Station("Stasiun Jeruk Legi",-7.622978, 109.018096));
        stationInfo.put("Stasiun Sruweng", new Station("Stasiun Sruweng",-7.6552205,109.6030586));
        stationInfo.put("Stasiun Caruban", new Station("Stasiun Caruban",-7.551131, 111.654815));
        stationInfo.put("Stasiun Solo Jebres", new Station("Stasiun Solo Jebres",-7.562221, 110.839500));
        stationInfo.put("Stasiun Cilacap", new Station("Stasiun Cilacap",-7.736050, 109.007068));
        //stationInfo.put("Stasiun ", new Station("Stasiun ", ));

        // untuk testing aplikasi
        stationInfo.put("Stasiun Unpar",new Station("Stasiun Unpar",-6.873485, 107.604630));
        stationInfo.put("Stasiun Ciwalk",new Station("Stasiun Ciwalk",-6.893640, 107.605595));
        stationInfo.put("Stasiun Istana Plaza", new Station("Stasiun Istana Plaza", -6.905661, 107.596791));
        stationInfo.put("Stasiun Haris", new Station("Stasiun Haris", -6.880705, 107.604186));
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
        trainInfo.put("Cirebon Ekspres | Cirebon - Gambir",cirebonEkspres);
        this.listOfTrains[ctList++] = "Cirebon Ekspres | Cirebon - Gambir";


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
        Train testing = new Train ("testing");
        testing.addDepartureTrack(stationInfo.get("Stasiun Unpar"));
        testing.addDepartureTrack(stationInfo.get("Stasiun Haris"));
        testing.addDepartureTrack(stationInfo.get("Stasiun Ciwalk"));
        testing.addDepartureTrack(stationInfo.get("Stasiun Istana Plaza"));

        testing.addArrivalTrack((stationInfo.get("Stasiun Istana Plaza")));
        testing.addArrivalTrack((stationInfo.get("Stasiun Ciwalk")));
        testing.addArrivalTrack(stationInfo.get("Stasiun Haris"));
        testing.addArrivalTrack((stationInfo.get("Stasiun Unpar")));

        trainInfo.put("testing | Unpar - Istana Plaza",testing);
        this.listOfTrains[ctList++] = "testing | Unpar - Istana Plaza";

        // argo bromo anggrek-eksekutif
        Train argoAnggrek = new Train("Argo Anggrek");
        //Surabaya Pasarturi-Gambir
        argoAnggrek.addDepartureTrack(stationInfo.get("Stasiun Surabaya Pasarturi"));
        argoAnggrek.addDepartureTrack(stationInfo.get("Stasiun Semarang Tawang"));
        argoAnggrek.addDepartureTrack(stationInfo.get("Stasiun Pekalongan"));
        argoAnggrek.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        argoAnggrek.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        argoAnggrek.addDepartureTrack(stationInfo.get("Stasiun Gambir"));

        //Gambir - Surabaya Pasarturi
        argoAnggrek.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        argoAnggrek.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        argoAnggrek.addArrivalTrack(stationInfo.get("Stasiun Pekalongan"));
        argoAnggrek.addArrivalTrack(stationInfo.get("Stasiun Semarang Tawang"));
        argoAnggrek.addArrivalTrack(stationInfo.get("Stasiun Surabaya Pasarturi"));
        trainInfo.put("Argo Anggrek | Surabaya Pasarturi - Gambir", argoAnggrek);
        this.listOfTrains[ctList++] = "Argo Anggrek | Surabaya Pasarturi - Gambir";

        //argo Dwipangga
        Train argoDwipangga = new Train ("Argo Dwipangga");
        //Solo Balapan - Gambir
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Klaten"));
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        argoDwipangga.addDepartureTrack(stationInfo.get("Stasiun Gambir"));

        //Gambir - Solo Balapan
        argoDwipangga.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        argoDwipangga.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        argoDwipangga.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        argoDwipangga.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        argoDwipangga.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        argoDwipangga.addArrivalTrack(stationInfo.get("Stasiun Klaten"));
        argoDwipangga.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));

        trainInfo.put("Argo Dwipangga | Solo Balapan - Gambir", argoDwipangga);
        this.listOfTrains[ctList++] = "Argo Dwipangga | Solo Balapan - Gambir";

        //Kutoarjo
        Train sawunggalihUtama = new Train ("Sawunggalih Utama");
        //Kutoarjo - Pasar Senen
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Kebumen"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Karanganyar"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Gombong"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Bumiayu"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Ciledug"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        sawunggalihUtama.addDepartureTrack(stationInfo.get("Stasiun Pasar Senen"));
        //Pasar Senen - Kutoarjo
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Pasar Senen"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Ciledug"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Bumiayu"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Gombong"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Karanganyar"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Kebumen"));
        sawunggalihUtama.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        trainInfo.put("Sawunggalih Utama | Kutoarjo - Pasar Senen", sawunggalihUtama);
        this.listOfTrains[ctList++] = "Sawunggalih Utama | Kutoarjo - Pasar Senen";

        //Lodaya
        Train lodaya = new Train ("Lodaya");
        //Solo Balapan - Bandung
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Klaten"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Wates"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Kebumen"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Sidareja"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Meluwung"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Banjar"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Tasikmalaya"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Cipeundeuy"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Kiaracondong"));
        lodaya.addDepartureTrack(stationInfo.get("Stasiun Bandung"));

        //Bandung - Solo Balapan
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Bandung"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Kiaracondong"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Cipeundeuy"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Tasikmalaya"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Banjar"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Sidareja"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Maos"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Ijo"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Gombong"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Wates"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Klaten"));
        lodaya.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));

        trainInfo.put("Lodaya | Solo Balapan - Bandung", lodaya);
        this.listOfTrains[ctList++] = "Lodaya | Solo Balapan - Bandung";

        //Mutiara Selatan
        Train mutiaraSelatan = new Train("Mutiara Selatan");
        //Malang - Bandung
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Malang"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Lawang"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Bangil"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Sidoarjo"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Mojokerto"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Jombang"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Kertosono"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Nganjuk"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Kebumen"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Gombong"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Maos"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Banjar"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Ciamis"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Tasikmalaya"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Cipeundeuy"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Cicalengka"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Kiaracondong"));
        mutiaraSelatan.addDepartureTrack(stationInfo.get("Stasiun Bandung"));

        //Bandung - Malang
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Bandung"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Kiaracondong"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Leles"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Cipeundeuy"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Tasikmalaya"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Ciamis"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Banjar"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Kemranjen"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Ijo"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Gombong"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Kebumen"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Nganjuk"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Kertosono"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Jombang"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Mojokerto"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Sidoarjo"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Porong"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Bangil"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Lawang"));
        mutiaraSelatan.addArrivalTrack(stationInfo.get("Stasiun Malang"));

        trainInfo.put("Mutiara Selatan | Malang - Bandung", mutiaraSelatan);
        this.listOfTrains[ctList++] = "Mutiara Selatan | Malang - Bandung";

        Train argoLawu= new Train("Argo Lawu");
        //Solo Balapan-Yogyakarta-Gambir
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Klaten"));
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        argoLawu.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir-Yogyakarta-Solo Balapan
        argoLawu.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        argoLawu.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        argoLawu.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        argoLawu.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        argoLawu.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        argoLawu.addArrivalTrack(stationInfo.get("Stasiun Klaten"));
        argoLawu.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));

        trainInfo.put("Argo Lawu | Solo Balapan - Yogyakarta - Gambir", argoLawu);
        this.listOfTrains[ctList++] = "Argo Lawu | Solo Balapan - Yogyakarta - Gambir";

        Train argoMuria= new Train("Argo Muria");
        //Semarang Tawang - Gambir
        argoMuria.addDepartureTrack(stationInfo.get("Stasiun Semarang Tawang"));
        argoMuria.addDepartureTrack(stationInfo.get("Stasiun Pekalongan"));
        argoMuria.addDepartureTrack(stationInfo.get("Stasiun Tegal"));
        argoMuria.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        argoMuria.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        argoMuria.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        argoMuria.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Semarang Tawang
        argoMuria.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        argoMuria.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        argoMuria.addArrivalTrack(stationInfo.get("Stasiun Tegal"));
        argoMuria.addArrivalTrack(stationInfo.get("Stasiun Pekalongan"));
        argoMuria.addArrivalTrack(stationInfo.get("Stasiun Semarang Tawang"));

        trainInfo.put("Argo Muria | Semarang Tawang - Gambir", argoMuria);
        this.listOfTrains[ctList++] = "Argo Muria | Semarang Tawang - Gambir";

        Train argoSindoro= new Train("Argo Sindoro");
        //Semarang Tawang - Gambir
        argoSindoro.addDepartureTrack(stationInfo.get("Stasiun Semarang Tawang"));
        argoSindoro.addDepartureTrack(stationInfo.get("Stasiun Pekalongan"));
        argoSindoro.addDepartureTrack(stationInfo.get("Stasiun Tegal"));
        argoSindoro.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        argoSindoro.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        argoSindoro.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Semarang Tawang
        argoSindoro.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        argoSindoro.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        argoSindoro.addArrivalTrack(stationInfo.get("Stasiun Tegal"));
        argoSindoro.addArrivalTrack(stationInfo.get("Stasiun Pekalongan"));
        argoSindoro.addArrivalTrack(stationInfo.get("Stasiun Semarang Tawang"));

        trainInfo.put("Argo Sindoro | Semarang Tawang - Gambir", argoSindoro);
        this.listOfTrains[ctList++] = "Argo Sindoro | Semarang Tawang - Gambir";

        Train argoJati= new Train("Argo Jati");
        //Cirebon - Gambir
        argoJati.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        argoJati.addDepartureTrack(stationInfo.get("Stasiun Jatibarang"));
        argoJati.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        argoJati.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        argoJati.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Cirebon
        argoJati.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        argoJati.addArrivalTrack(stationInfo.get("Stasiun Bekasi"));
        argoJati.addArrivalTrack(stationInfo.get("Stasiun Jatibarang"));
        argoJati.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));

        trainInfo.put("Argo Jati | Cirebon - Gambir", argoJati);
        this.listOfTrains[ctList++] = "Argo Jati | Cirebon - Gambir";

        Train argoWilis= new Train("Argo Wilis");
        //Surabaya Gubeng-Bandung
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Jombang"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Banjar"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Tasikmalaya"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Cipeundeuy"));
        argoWilis.addDepartureTrack(stationInfo.get("Stasiun Bandung"));
        //Bandung-Surabaya Gubeng
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Bandung"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Cipeundeuy"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Tasikmalaya"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Banjar"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Jombang"));
        argoWilis.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));

        trainInfo.put("Argo Wilis | Surabaya Gubeng - Bandung", argoWilis);
        this.listOfTrains[ctList++] = "Argo Wilis | Surabaya Gubeng - Bandung";

        Train gajayana= new Train("Gajayana");
        //Malang - Gambir
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Malang"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Kepanjen"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Wlingi"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Blitar"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Tulungagung"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Kediri"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Kertosono"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        gajayana.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Malang
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Gombong"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Kebumen"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Kertosono"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Kediri"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Tulungagung"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Blitar"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Wlingi"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Kepanjen"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Malang Kotolama"));
        gajayana.addArrivalTrack(stationInfo.get("Stasiun Malang"));

        trainInfo.put("Gajayana | Malang - Gambir", gajayana);
        this.listOfTrains[ctList++] = "Gajayana | Malang - Gambir";

        Train sembrani= new Train("Sembrani");
        //Surabaya Pasarturi - Gambir
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Surabaya Pasarturi"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Lamongan"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Bojonegoro"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Cepu"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Semarang Tawang"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Pekalongan"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Tegal"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        sembrani.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Surabaya Pasarturi
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Tegal"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Pekalongan"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Semarang Tawang"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Cepu"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Bojonegoro"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Lamongan"));
        sembrani.addArrivalTrack(stationInfo.get("Stasiun Surabaya Pasarturi"));

        trainInfo.put("Sembrani | Surabaya Pasarturi - Gambir", sembrani);
        this.listOfTrains[ctList++] = "Sembrani | Surabaya Pasarturi - Gambir";

        Train bima= new Train("Bima");
        //Malang - Gambir
        bima.addDepartureTrack(stationInfo.get("Stasiun Malang"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Lawang"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Sidoarjo"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Mojokerto"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Jombang"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Nganjuk"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Jatibarang"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        bima.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Malang
        bima.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Jatibarang"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Kemranjen"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Sumpiuh"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Ijo"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Kebumen"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Prembun"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Nganjuk"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Jombang"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Mojokerto"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Sidoarjo"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Lawang"));
        bima.addArrivalTrack(stationInfo.get("Stasiun Malang"));

        trainInfo.put("Bima | Malang - Gambir", bima);
        this.listOfTrains[ctList++] = "Bima | Malang - Gambir";

        Train taksaka= new Train("Taksaka");
        //Yogyakarta - Gambir
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Kebumen"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        taksaka.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Yogyakarta
        taksaka.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        taksaka.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        taksaka.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        taksaka.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        taksaka.addArrivalTrack(stationInfo.get("Stasiun Kebumen"));
        taksaka.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        taksaka.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));

        trainInfo.put("Taksaka | Yogyakarta - Gambir", taksaka);
        this.listOfTrains[ctList++] = "Taksaka | Yogyakarta - Gambir";

        Train turangga= new Train("Turangga");
        //Surabaya Gubeng - Bandung
        turangga.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Mojokerto"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Jombang"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Kertosono"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Nganjuk"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Wilangan"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Solo Balapan"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Yogyakarta"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Kutoarjo"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Karang Anyar"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Kemranjen"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Banjar"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Tasikmalaya"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Cipeundeuy"));
        turangga.addDepartureTrack(stationInfo.get("Stasiun Bandung"));
        //Bandung - Surabaya Gubeng
        turangga.addArrivalTrack(stationInfo.get("Stasiun Bandung"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Cipeundeuy"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Tasikmalaya"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Banjar"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Jeruk Legi"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Sruweng"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Kutoarjo"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Yogyakarta"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Solo Balapan"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Nganjuk"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Kertosono"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Jombang"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Mojokerto"));
        turangga.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));

        trainInfo.put("Turangga | Surabaya Gubeng - Bandung", turangga);
        this.listOfTrains[ctList++] = "Turangga | Surabaya Gubeng - Bandung";

        Train bangunkarta= new Train("Bangunkarta");
        //Surabaya Gubeng - Gambir
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Surabaya Gubeng"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Mojokerto"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Jombang"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Kertosono"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Nganjuk"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Caruban"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Madiun"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Paron"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Solo Jebres"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Semarang Tawang"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Pekalongan"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Pemalang"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Tegal"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        bangunkarta.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Surabaya Gubeng
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Tegal"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Pemalang"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Pekalongan"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Semarang Tawang"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Solo Jebres"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Paron"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Madiun"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Caruban"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Nganjuk"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Kertosono"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Jombang"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Mojokerto"));
        bangunkarta.addArrivalTrack(stationInfo.get("Stasiun Surabaya Gubeng"));

        trainInfo.put("Bangunkarta | Surabaya Gubeng - Gambir", bangunkarta);
        this.listOfTrains[ctList++] = "Bangunkarta | Surabaya Gubeng - Gambir";

        Train purwojaya= new Train("Purwojaya");
        //Cilacap - Gambir
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Cilacap"));
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Maos"));
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Kroya"));
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Purwokerto"));
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Cirebon"));
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Bekasi"));
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Jatinegara"));
        purwojaya.addDepartureTrack(stationInfo.get("Stasiun Gambir"));
        //Gambir - Cilacap
        purwojaya.addArrivalTrack(stationInfo.get("Stasiun Gambir"));
        purwojaya.addArrivalTrack(stationInfo.get("Stasiun Cirebon"));
        purwojaya.addArrivalTrack(stationInfo.get("Stasiun Purwokerto"));
        purwojaya.addArrivalTrack(stationInfo.get("Stasiun Kroya"));
        purwojaya.addArrivalTrack(stationInfo.get("Stasiun Maos"));
        purwojaya.addArrivalTrack(stationInfo.get("Stasiun Cilacap"));
        
        trainInfo.put("Purwojaya | Cilacap - Gambir", purwojaya);
        this.listOfTrains[ctList++] = "Purwojaya | Cilacap - Gambir";

        //trainInfo.put("", );
        //this.listOfTrains[ctList++] = "";

        Arrays.sort(this.listOfTrains);
    }

    //GET THE STATIONS TRAVERSED BY TRAIN from START_STATION to END_STATION
    //@param the name of start station and end station
    //@param arrival or departure track to be selected (0=departure, 1=arrival)
    public static ArrayList<Station> getStationOnTrack(String start, String end, int optionTrack){
        ArrayList<Station> listStations = new ArrayList<>();
        ArrayList<Station> fullTrack;
        if(optionTrack == 0){
            //departure track
            fullTrack = trainInfo.get(activeTrain).departureTrack;
        }else{
            //arrival track
            fullTrack = trainInfo.get(activeTrain).arrivalTrack;
        }
        //TAKE STATIONS THAT ARE ONLY PASSED FROM START STATION TO END STATION OF ALL STATIONS
        int i;
        boolean checkStart = false;
        for(i=0; i<fullTrack.size(); i++) {
            if (checkStart) {
                listStations.add(fullTrack.get(i));
                if (fullTrack.get(i).getNamaStasiun().equalsIgnoreCase(end)) {
                    break;
                }
            } else {
                if (fullTrack.get(i).getNamaStasiun().equalsIgnoreCase(start)) {
                    checkStart = true;
                    listStations.add(fullTrack.get(i));
                }
            }
        }
        return listStations;
    }
}