package com.example.kiki.locationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;
import java.util.UUID;

public class ReceiptActivity extends AppCompatActivity {

    TextView paymentId , paymentMethod , paymentCharged , paymentMadeBy;
    String  method,charges,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        Intent i = getIntent();
       method =  i.getStringExtra("Payment Method");
       charges = i.getStringExtra("tripCharges");
       name = i.getStringExtra("name");
        paymentId = findViewById(R.id.activity_receipt_id_text_view);
        paymentMethod = findViewById(R.id.activity_receipt_payment_text_view);
        paymentCharged = findViewById(R.id.activity_receipt_charges_text_view);
        paymentMadeBy = findViewById(R.id.activity_receipt_name_text_view);

        String id = UUID.randomUUID().toString().substring(0,9);
        paymentMethod.setText(""+method);
        paymentCharged.setText(""+charges);
        paymentMadeBy.setText(""+name);


    }
}
