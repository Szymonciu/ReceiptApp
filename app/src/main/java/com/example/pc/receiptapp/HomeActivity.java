package com.example.pc.receiptapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button addReceipt;
    private Button listOfReceipt;
    private Button infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addReceipt = (Button) findViewById(R.id.add_receipt);
        listOfReceipt = (Button) findViewById(R.id.list_of_receipt);
        infoButton = (Button) findViewById(R.id.info_button);

        addReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_add_receipt();
            }
        });

        listOfReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_list_of_receipt();
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

    private void openDialog() {
        InfoDialog infoDialog = new InfoDialog();
        infoDialog.show(getSupportFragmentManager(), "Dialog");
    }

    private void openactivity_list_of_receipt() {
        Intent intent = new Intent(this, ListOfReceipt.class);
        startActivity(intent);
    }


    private void openactivity_add_receipt() {
        Intent intent = new Intent(this, AddReceipt.class);
        startActivity(intent);
    }

}
