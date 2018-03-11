package com.example.omerveberna.pastam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SiparisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseReference ddRef= FirebaseDatabase.getInstance().getReference().child("Kullanıcılar");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis);
    }
}
