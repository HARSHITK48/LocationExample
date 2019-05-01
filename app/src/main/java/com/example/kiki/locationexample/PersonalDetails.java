package com.example.kiki.locationexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class PersonalDetails extends AppCompatActivity {
    Button selectBoothButton,submitDetailsButton;
    EditText ed1,ed2,ed3,ed4,ed5;
    String startPoint,endPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_vehicle);
        selectBoothButton = findViewById(R.id.showBoothsButton);
        submitDetailsButton=findViewById(R.id.submit_details);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        selectBoothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PersonalDetails.this, "Showing Booths", Toast.LENGTH_SHORT).show();

                Intent  intent = new Intent(PersonalDetails.this, MapsActivity.class);
                intent.putExtra("start",startPoint);
                intent.putExtra("end",endPoint);
                startActivity(intent);

            }
        });
        submitDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                startPoint = ed4.getText().toString();
                endPoint=ed5.getText().toString();
                ed4.setText("");
                ed5.setText("");

                Toast.makeText(PersonalDetails.this, "Details Successfully Submitted.\nProceed to booths", Toast.LENGTH_SHORT).show();

            }
        });


    }

}
