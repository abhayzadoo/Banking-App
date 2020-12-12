package com.example.moneytransactionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TransactionList extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        listView = (ListView) findViewById(R.id.list);
        ArrayList<String> mytransaction = new ArrayList<>();
        mytransaction.add("user send Rs 1000 to Abhay");
        mytransaction.add("user send Rs 200 to Yashita");
        mytransaction.add("user send Rs 123 to Jhon");
        mytransaction.add("user send Rs 500 to Srishti");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mytransaction);
        listView.setAdapter(arrayAdapter);



    }
}