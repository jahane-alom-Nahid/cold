package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {


    private Context context;
    List<String> listdataheader;
    HashMap<String,List<String>> listdatachild;

    public CustomAdapter(Context context, List<String> listdataheader, HashMap<String, List<String>> listdatachild) {
        this.context = context;
        this.listdataheader = listdataheader;
        this.listdatachild = listdatachild;
    }

    @Override
    public int getGroupCount() {
        return listdataheader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listdatachild.get(listdataheader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listdataheader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listdatachild.get(listdataheader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerText=(String) getGroup(groupPosition);

        if (convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.grouplayout,null);
        }

        TextView textView=(TextView)convertView.findViewById(R.id.headerTextViewId);
        textView.setText(headerText);
        return convertView;


    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {



        String childText=(String) getChild(groupPosition,childPosition);

        if (convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.childlayout,null);
        }

        TextView textView=(TextView)convertView.findViewById(R.id.childtextVieId);
        textView.setText(childText);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
