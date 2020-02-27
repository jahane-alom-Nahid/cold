package com.example.finalproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DoctorListAndCabin extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_and_cabin);

        tabLayout=(TabLayout)findViewById(R.id.tablayout_Id);
        viewPager=(ViewPager)findViewById(R.id.ViewPagerId);
        adapter=new ViewPageAdapter((getSupportFragmentManager()));

        //add adapter


        adapter.AddFragment(new FragmentDoctor(),"Doctor List");
        adapter.AddFragment(new FragmentCabin(),"Cabin Booking");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
