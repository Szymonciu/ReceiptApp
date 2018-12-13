package com.example.pc.receiptapp;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class AddReceipt extends AppCompatActivity {

    private TextInputLayout textInputName;
    private TextInputLayout textInputDate;
    private TextInputLayout textInputplace;

    private Button AddReceipt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receipt);
    }


}
