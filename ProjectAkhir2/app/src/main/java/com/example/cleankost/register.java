package com.example.cleankost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleankost.Adapter.AdapterCK;
import com.example.cleankost.App.DBCleaningKost;
import com.example.cleankost.Database.cleaning;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class register extends AppCompatActivity {private RecyclerView recyclerView;
    private AdapterCK adapterCK;
    private ArrayList<cleaning> cleaningArrayList;
    DBCleaningKost controller = new DBCleaningKost(this);
    String nm,email,almt;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapterCK = new AdapterCK(cleaningArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(register.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterCK);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, cleaningkost.class);
                startActivity(intent);
            }
        });
    }
    private void BacaData() {
        ArrayList<HashMap<String,String>> daftarcleaningkost = controller.getAllkamarmandi();
        cleaningArrayList = new ArrayList<>();

        //memindah dari hasil query kedalam daftarcleaningkost
        for(int i=0;i<daftarcleaningkost.size();i++){
            cleaning cleaning = new cleaning();

            cleaning.setNama(daftarcleaningkost.get(i).get("nama").toString());
            cleaning.setEmail(daftarcleaningkost.get(i).get("email").toString());
            cleaning.setAlmt(daftarcleaningkost.get(i).get("alamat").toString());
            //pindahkan dari daftarcleaningkost kedalam Arraylist daftarcleaningkost di adapter
            cleaningArrayList.add(cleaning);
        }
    }
}