package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HospitalList extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);


        listView=(ListView) findViewById(R.id.hospitalListViewId);
        final String[] HospitalName=getResources().getStringArray(R.array.Hospital_name);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(HospitalList.this,R.layout.hospitallayout,R.id.textViewId,HospitalName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = HospitalName[position];
                startActivity(new Intent(HospitalList.this,DoctorListAndCabin.class));

            }
        });


    }
}
