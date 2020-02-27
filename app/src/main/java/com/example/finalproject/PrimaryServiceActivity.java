package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrimaryServiceActivity extends AppCompatActivity {


    private ExpandableListView expandableListView;
    List<String> listdataheader;
    private CustomAdapter customAdapter;
    HashMap<String,List<String>> listdatachild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_service);

        prepareListData();
        expandableListView=(ExpandableListView) findViewById(R.id.expandablelistViewId);
        customAdapter=new CustomAdapter(this,listdataheader,listdatachild);
        expandableListView.setAdapter(customAdapter);
    }

    public void prepareListData()
    {
        String[] headerString=getResources().getStringArray(R.array.group_primary_List_header);
        String[] childString=getResources().getStringArray(R.array.child_primary_List_header);

        listdataheader=new ArrayList<>();
        listdatachild=new HashMap<>();

        for (int i=0;i<headerString.length;i++)
        {
            //adding header data
            listdataheader.add(headerString[i]);

            //childAdd in list
            List<String> child=new ArrayList<>();
            child.add(childString[i]);
            listdatachild.put(listdataheader.get(i),child);
        }


    }
}
