package com.example.finalproject;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    private EditText PayeeName,transactionId,phoneNum;
    private TextView payDate;
    private Button setectdate;
    private DatePickerDialog datePickerDialog;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        PayeeName=(EditText) findViewById(R.id.payeeNameId);
        transactionId=(EditText) findViewById(R.id.bkashId);
        phoneNum=(EditText) findViewById(R.id.numId);
        payDate=(TextView) findViewById(R.id.dateId);
        setectdate=(Button) findViewById(R.id.selectDateId);

        setectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePicker=new DatePicker(Payment.this);
                int currentDay=datePicker.getDayOfMonth();
                int currentMonth=datePicker.getMonth()+1;
                int currentYear=datePicker.getYear();


                datePickerDialog=new DatePickerDialog(Payment.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                payDate.setText(i+"/"+ (i1+1) +"/"+i2);

                            }
                        },currentYear,currentMonth,currentDay);

            }
        });


    }
}
