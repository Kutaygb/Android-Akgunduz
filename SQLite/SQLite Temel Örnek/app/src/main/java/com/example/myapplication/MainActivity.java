package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(LayoutInflater.from(getApplicationContext()));

        setContentView(binding.getRoot());

        db = new DBHelper(this);


        binding.btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String t = binding.txtTurkce.getText().toString();
                String e = binding.txtEnglish.getText().toString();

                db.kelimeEkle(t,e);

                binding.txtTurkce.setText("");
                binding.txtEnglish.setText("");
            }
        });

        /*
        // Data Ekle


        db.kelimeEkle("insan","human");
        db.kelimeEkle("bina","building");
        db.kelimeEkle("yılan","snake");
        db.kelimeEkle("akrep","scorpion");

        // Data Güncelle

        db.kelimeDuzenle(2,"böcek","bug");

        // Data Sil

        db.kelimeSil(4);


         */

    }
}