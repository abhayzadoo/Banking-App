package com.example.moneytransactionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telecom.StatusHints;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    DatabaseHelper myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.transactionlist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, SendMoney.class);
                startActivity(intent);
            }
        });


        myDB = new DatabaseHelper(ListActivity.this);
        // yha se update
        ArrayList<String> thislist = new ArrayList<>();
        Cursor data = myDB.readalldata();

        if (data.getCount()== 0 ){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                thislist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thislist);
                listView.setAdapter(listAdapter);
            }
        }
        


    }
}