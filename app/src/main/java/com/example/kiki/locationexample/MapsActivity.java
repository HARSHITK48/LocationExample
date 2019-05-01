package com.example.kiki.locationexample;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Button payemnt;
    private GoogleMap mMap;
    String Start, End;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        payemnt = findViewById(R.id.paymentButton);
        Intent i  = getIntent();
        Start= i.getStringExtra("start");
        End = i.getStringExtra("end");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        payemnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MapsActivity.this,PaymentGateway.class);
                intent.putExtra("start",Start);
                intent.putExtra("end",End);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(13.9675, 77.7141);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng booth1 = new LatLng(13.9675, 74.7141);
        mMap.addMarker(new MarkerOptions().position(booth1).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(booth1));
        LatLng booth2 = new LatLng(13.9675, 79.7141);
        mMap.addMarker(new MarkerOptions().position(booth2).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(booth2));

        LatLng booth3 = new LatLng(17.3850, 78.4867);
        mMap.addMarker(new MarkerOptions().position(booth3).title("Toll Booth"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(booth3));
    }



}
