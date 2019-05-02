package com.example.kiki.locationexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class PaymentGateway extends AppCompatActivity {
    Button button ;
    TextView tripChargesTextView;
    Spinner PaymentModeSpinner;
    EditText paymentMadeBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_gateway);
        Intent i  = getIntent();
        final String StartPoint = i.getStringExtra("start");
         final String EndPoint  = i.getStringExtra("end");
         final double tripCharges  = i.getDoubleExtra("tripCharges",0d);
        button = findViewById(R.id.button);
        tripChargesTextView=findViewById(R.id.tripChargesInPaymentGateway);
        tripChargesTextView.append(""+tripCharges);
        paymentMadeBy=findViewById(R.id.paymentMadeBy);
        PaymentModeSpinner=findViewById(R.id.PaymentMethodSpinner);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", 12.9675, 77.7141, StartPoint, 11.9675, 74.7141, EndPoint);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentGateway.this,ReceiptActivity.class);
                intent.putExtra("tripCharges",tripCharges);
                intent.putExtra("name",paymentMadeBy.getText().toString());
                intent.putExtra("Payment Method",PaymentModeSpinner.getSelectedItem().toString());
            }
        });

    }
}
