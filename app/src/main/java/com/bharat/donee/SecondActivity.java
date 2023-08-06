package com.bharat.donee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrNames= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView=findViewById(R.id.listView);
        arrNames.add("NAME                                            Required Help");
        arrNames.add("Smile foundation                                        Rs.30000");
        arrNames.add("AASHA foundation                                       Rs.25000");
        arrNames.add("Education Helping NGO                                Rs.20000");
        arrNames.add("Bharat Chand                                             Rs.10000");
        arrNames.add("Ravi Sharma                                       Class 12 Books");
        arrNames.add("jaskirat                        Scholarship for Higher Studies");
        arrNames.add("Helping Hands NGO                            Cloths for winter");
        arrNames.add("EMon Foundation             Sponsorship for children");
        arrNames.add("Child Orphanage                     Clothes, Money, Books");
        arrNames.add("Bharti Foundation                                    Rs. 30000");
        arrNames.add("Manjinder Singh               Rs. 100000 for Medical");
        arrNames.add("sakshi sinha                     Rs. 30000  for Higher Studies");
        arrNames.add("Sarka Foundation                    Clothes,Food, Money,");
        arrNames.add("Kesha Free Library                                       Books");
        arrNames.add("jaskirat Foundation                                Food, Books");
        arrNames.add("Khalsa foundation                                      Rs.3000");
        arrNames.add("Bhagat Singh Library                                     BOOKS");
        arrNames.add("Rawat Orphanage                    Clothes, Food, Books");
        arrNames.add("SDP ATAL LAB                                        Equipments");
        arrNames.add("Shan foundation                                         Books");
        arrNames.add("Kiran foundation                                          Rs.20000");
        arrNames.add("JYOTI Foundation                                          Rs.4500");
        arrNames.add("Chand Charitable School                            Rs.10000");
        arrNames.add("Divya Charitable Eye Surgeon                       Rs. 5000");

//
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}