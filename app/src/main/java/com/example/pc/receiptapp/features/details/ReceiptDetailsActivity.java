package com.example.pc.receiptapp.features.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.core.Receipt;

public class ReceiptDetailsActivity extends AppCompatActivity {

    public static final String RECEIPT_KEY = "receipt key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_details);
        getReceiptFromExtras();
    }

    private void getReceiptFromExtras() {
        Receipt receipt = (Receipt) getIntent().getSerializableExtra(RECEIPT_KEY);
        Toast.makeText(this, receipt.toString(), Toast.LENGTH_SHORT).show();
    }
}
