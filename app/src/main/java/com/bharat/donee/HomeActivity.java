package com.bharat.donee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigation2);
        drawerLayout=findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(HomeActivity.this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_closed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        actionBarDrawerToggle.syncState();
        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Home()).commit();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Home()).commit();
                        break;
                    case R.id.history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new about()).commit();
                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new raise()).commit();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });
//        arrNames.add("Bharat");
//        arrNames.add("Manjinder");
//        arrNames.add("sakshi");
//        arrNames.add("Sarkari Bhai");
//        arrNames.add("keshav");
//        arrNames.add("jaskirat");
//        arrNames.add("Ravi");
//        arrNames.add("Emon");
//        arrNames.add("jaspreet");
//        arrNames.add("Bharat");
//        arrNames.add("Manjinder");
//        arrNames.add("sakshi");
//        arrNames.add("Sarkari Bhai");
//        arrNames.add("keshav");
//        arrNames.add("jaskirat");
//        arrNames.add("Ravi");
//        arrNames.add("Emon");
//        arrNames.add("jaspreet");
//        arrNames.add("Bharat");
//        arrNames.add("Manjinder");
//        arrNames.add("sakshi");
//        arrNames.add("Sarkari Bhai");
//        arrNames.add("keshav");
//        arrNames.add("jaskirat");
//        arrNames.add("Ravi");
//        arrNames.add("Emon");
//        arrNames.add("jaspreet");
//        arrNames.add("Bharat");
//        arrNames.add("Manjinder");
//        arrNames.add("sakshi");
//        arrNames.add("Sarkari Bhai");
//        arrNames.add("keshav");
//        arrNames.add("jaskirat");
//        arrNames.add("Ravi");
//        arrNames.add("Emon");
//        arrNames.add("jaspreet");
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
//        listView.setAdapter(adapter);




    }
}