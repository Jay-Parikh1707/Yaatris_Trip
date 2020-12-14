package com.example.yaatris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdventureDetails extends AppCompatActivity {

    private Button button;
    AdvnetureModel m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_details);

        Adventures a = new Adventures();
        ArrayList<AdvnetureModel> newmodels= new ArrayList<AdvnetureModel>();



        button = (Button) findViewById(R.id.Bookmyticket);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookingPage();
            }
        });

        TextView name = (TextView)findViewById(R.id.adv_name);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            int j = (int) b.get("index");
            Toast.makeText(this, String.valueOf(j), Toast.LENGTH_SHORT).show();
            newmodels = (
                    ArrayList<AdvnetureModel>
            ) b.get("models");
           this.m = newmodels.get(Integer.valueOf(j));
           name.setText(this.m.adventureName);


        }
    }

    public void openBookingPage() {
        Intent intent = new Intent(this, BookingPage.class);
        startActivity(intent);
    }







}
