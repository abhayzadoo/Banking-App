package com.example.moneytransactionapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.jar.Attributes;

public class SendMoney extends AppCompatActivity {

    TextView mname, mphoneno, macctblnc,macctno;
    Button msendmoney;
    AlertDialog dialog;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        msendmoney = findViewById(R.id.sendmoney);

        mname = findViewById(R.id.name);
        mphoneno = findViewById(R.id.phoneno);
        macctblnc = findViewById(R.id.acctblnc);
        macctno = findViewById(R.id.acctno);



        mname.setText("Abhay");
        mphoneno.setText("7439329292");
        macctblnc.setText("9472.00");
        macctno.setText("XXXXXXXQWEXX1234");
        msendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SendMoney.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_transfer_money, null);
                mBuilder.setTitle("Enter the amount want to send").setView(mView).setCancelable(false);

                EditText mAmount = (EditText) findViewById(R.id.enter_money);
                mBuilder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

                dialog = mBuilder.create();
                dialog.show();
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SendMoney.this, "Transaction Successful", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SendMoney.this, MainActivity.class);
                        startActivity(intent);


                    }
                });
            }
        });

    }
}