package com.example.finalproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Doctor> mdata;
    Dialog MyDialog;

    public RecyclerViewAdapter(Context mContext, List<Doctor> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_doctor_list,viewGroup,false);
        final MyViewHolder vHolder=new MyViewHolder(v);




        //Dialog Part
        MyDialog = new Dialog(mContext);
        MyDialog.setContentView(R.layout.details_doctor);
        MyDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        vHolder.item_doctorls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView detailname =(TextView)MyDialog.findViewById(R.id.detail_name_ID);
                TextView detailphn= (TextView)MyDialog.findViewById(R.id.detail_phone_ID);
                ImageView detailImg= (ImageView)MyDialog.findViewById(R.id.Doctor_Img_Id);
                Button btn=(Button)MyDialog.findViewById(R.id.details_apponment_id_btn);
                detailname.setText(mdata.get(vHolder.getAdapterPosition()).getName());
                detailphn.setText(mdata.get(vHolder.getAdapterPosition()).getPhone());
                detailImg.setImageResource(mdata.get(vHolder.getAdapterPosition()).getPhoto());
                

                Toast.makeText(mContext, "Doctor No: " + String.valueOf(vHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                MyDialog.show();
            }
        });









        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_name.setText(mdata.get(i).getName());
        myViewHolder.tv_phone.setText(mdata.get(i).getPhone());
        myViewHolder.Im_photo.setImageResource(mdata.get(i).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_doctorls;
        private TextView tv_name;
        private TextView tv_phone;
        private ImageView Im_photo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_doctorls = (LinearLayout) itemView.findViewById(R.id.doctor_list_itemId);
            tv_name=(TextView)itemView.findViewById(R.id.Name_Doctor_Id);
            tv_phone=(TextView)itemView.findViewById(R.id.NumberDoctor_Id);
            Im_photo=(ImageView)itemView.findViewById(R.id.img_doctor);
        }
    }
}
