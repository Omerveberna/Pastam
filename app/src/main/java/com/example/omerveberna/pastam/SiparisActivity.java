package com.example.omerveberna.pastam;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SiparisActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference;
    private DatabaseReference siparislerReference;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Pastalar> pasta_listesi;
    private String mevcutKisiId;

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authStateListener != null) {
            auth.removeAuthStateListener(authStateListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis);

        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.scrollToPosition(0);

        mRecyclerView.setLayoutManager(linearLayoutManager);



        databaseReference = FirebaseDatabase.getInstance().getReference().child("pastalar");
        siparislerReference = FirebaseDatabase.getInstance().getReference().child("siparişler");


        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser oturumAcanUser = firebaseAuth.getCurrentUser();
                if (oturumAcanUser != null) {
                    mevcutKisiId=oturumAcanUser.getUid();
                    String mevcutKisiEmail=oturumAcanUser.getEmail();


                }
            }
        };
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pasta_listesi = new ArrayList<Pastalar>();
                Pastalar pastalar;
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    pastalar = ds.getValue(Pastalar.class);

                    //Recycler view ile verileri kullanıcıya göster.


                    pasta_listesi.add(new Pastalar(pastalar.getIcerik(),pastalar.getkisi(),pastalar.getFiyat()));
                }
                PastalarAdapter pastalarAdapter = new PastalarAdapter(pasta_listesi, new CustomItemClickListener() {

                    @Override
                    public void onItemClick(View v, int position) {
                        Pastalar pastalar= pasta_listesi.get(position);
                        Siparisler siparisler= new Siparisler();

                        siparisler.setKisi(pastalar.getkisi());
                        siparisler.setIcerik(pastalar.getIcerik());
                        siparisler.setFiyat(pastalar.getFiyat());
                        siparisler.setUid(mevcutKisiId);
                        //Toast.makeText(getApplicationContext(),position + " " + pastalar.getIcerik(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SiparisActivity.this,TamamlandiActivity.class);
                        startActivity(intent);
                        siparislerReference.push().setValue(siparisler);

                    }
                });

                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setAdapter(pastalarAdapter);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });










    }
}
