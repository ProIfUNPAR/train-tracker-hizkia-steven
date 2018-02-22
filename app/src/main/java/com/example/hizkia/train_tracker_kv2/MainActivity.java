package com.example.hizkia.train_tracker_kv2;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected RadioGroup rbGroup;
    protected RadioButton rbStart, rbEnd;
    protected Button btnNext;
    protected Spinner spTrains;
    protected String[] listOfTrains;
    public static String activeTrain;
    public static boolean isArrival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET ID FROM LAYOUT START
        this.btnNext = findViewById(R.id.btnNext);
        this.spTrains = findViewById(R.id.spinnerTrains);
        this.rbStart = findViewById(R.id.rbStart);
        this.rbEnd = findViewById(R.id.rbEnd);
        //SET ID FROM LAYOUT END

        //SET LISTENER START
        this.btnNext.setOnClickListener(this);
        //SET LISTENER END

        //GET NAMES OF ALL THE TRAINS WHICH HAVE A TRACK
        Database db = new Database();
        this.listOfTrains = db.getListOfTrains();

        //SET ALL ADAPTER START
        //Adapter for list of Trains
        ArrayAdapter<String> trainsAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,this.listOfTrains);
        trainsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTrains.setAdapter(trainsAdapter);
        //SET ALL ADAPTER END

        //SET INITIAL RADIO BUTTON
        this.rbStart.setChecked(true);
        this.rbEnd.setChecked(false);
        //SET INITIAL ATTRIBUTE isArrival
        isArrival = false;
    }

    //PUT EVERY ONCLICK FUNCTION HERE
    //ONCLICK FUNCTION START
    @Override
    public void onClick(View view) {
        //Button Next Clicked
        //Go to Tracks page
        if(view.getId() == btnNext.getId()){
            String text = spTrains.getSelectedItem().toString();
            System.out.println(text);
            activeTrain = text;

            Intent openTracks = new Intent(this, TracksActivity.class);
            startActivity(openTracks);
        }
    }
    //ONCLICK FUNCTION END

    //RADIO BUTTON FUNCTION START
    public void rbClicked(View view){
        //int idRadio = rbGroup.getCheckedRadioButtonId();
        //this.radioButton = (RadioButton)findViewById(idRadio);

        boolean checked = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.rbStart:
                if(checked)
                isArrival = false;
                break;
            case R.id.rbEnd:
                if(checked)
                isArrival = true;
                break;
        }
    }
    //RADIO BUTTON FUNCTION END

}
