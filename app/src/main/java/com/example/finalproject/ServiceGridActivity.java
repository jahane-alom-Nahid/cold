package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class ServiceGridActivity extends AppCompatActivity {
    CardView primaryService;
    CardView hospitalList;
    CardView GovtInfo;
    CardView Ambulance;
    CardView About;
    CardView Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_grid);

        primaryService=findViewById(R.id.PrimaryserviceId);
        hospitalList=findViewById(R.id.HospitalList_Id);
        GovtInfo=findViewById(R.id.GovtInfoIdId);
        Ambulance=findViewById(R.id.AmbulanceId);
        About=findViewById(R.id.AboutId);
        Exit=findViewById(R.id.ExitId);

        primaryService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ServiceGridActivity.this,PrimaryServiceActivity.class));

            }
        });


        hospitalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ServiceGridActivity.this,HospitalList.class));

            }
        });


        GovtInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ServiceGridActivity.this,GovtNews.class));

            }
        });



        Ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ServiceGridActivity.this,PrimaryServiceActivity.class));

            }
        });



        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ServiceGridActivity.this,About.class));

            }
        });



        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ServiceGridActivity.this,LoginActivity.class));
                Toast.makeText(ServiceGridActivity.this, "Sucessfully Exit ", Toast.LENGTH_SHORT).show();

            }
        });



    }
}
