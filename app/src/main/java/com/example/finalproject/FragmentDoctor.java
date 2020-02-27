package com.example.finalproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentDoctor extends Fragment {

    View v;
    private RecyclerView myrecyclerView;
    private List<Doctor> lsDoctor;

    public FragmentDoctor(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.doctor_fragment,container,false);
        myrecyclerView=(RecyclerView)v.findViewById(R.id.Doctor_RecyclerViewId);
        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(getContext(),lsDoctor);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lsDoctor =new ArrayList<>();
        lsDoctor.add(new Doctor("Professor Dr.MD.A Ahasan","Medicine & Gastroenterology",R.drawable.ahasan));
        lsDoctor.add(new Doctor("Dr.Masud Rana","Gastroenterologist",R.drawable.rana));
        lsDoctor.add(new Doctor("Dr.Md.Faruk Hossain","Neuromedicine Specialist",R.drawable.faruk));
        lsDoctor.add(new Doctor("Dr.Md.Fokrul Islam","Neuromedicine Specialist",R.drawable.islam));
        lsDoctor.add(new Doctor("Professor Dr.Md.Sohailul Islam ","Medicine Specialist",R.drawable.fokrul));
        lsDoctor.add(new Doctor("Professor Dr.A H M Mostafizur Rahman","Psychiatrist",R.drawable.rahman));
        lsDoctor.add(new Doctor("Dr.salauddin Mamun Chowdhury","Medicine Specialist",R.drawable.chowdhury));
        lsDoctor.add(new Doctor("Dr.Hari Bhushan sarkar","Medicine Specialist",R.drawable.shoyli));
        lsDoctor.add(new Doctor("Dr.Kamrun nahar","Obstetrician & Gynecologist",R.drawable.nahar));
        lsDoctor.add(new Doctor("Dr. Mohammad Mahabubul Alam Chowdhury","Child-Pediatric Surgeon",R.drawable.mamun));

    }
}
