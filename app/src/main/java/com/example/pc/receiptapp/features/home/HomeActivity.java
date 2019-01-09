package com.example.pc.receiptapp.features.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pc.receiptapp.InfoDialog;
import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.features.addreceipt.AddReceiptActivity;
import com.example.pc.receiptapp.features.list.ReceiptListActivity;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    private Button addReceipt;
    private Button listOfReceipt;
    private ImageView infoIcon;

    private HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        initPresenter();


        addReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddReceiptButtonClick();
            }
        });

        listOfReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onListOfReceiptButtonClick();
            }
        });

        infoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onInfoIconClick();
            }
        });

    }

    private void initViews() {
        addReceipt = findViewById(R.id.add_receipt);
        listOfReceipt = findViewById(R.id.list_of_receipt);
        infoIcon = findViewById(R.id.info_button);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    private void initPresenter() {
        presenter = new HomePresenter();
        presenter.attackView(this);
    }


    @Override
    public void openAddReceiptScreen() {
        Intent intent = new Intent(this, AddReceiptActivity.class);
        startActivity(intent);
    }

    @Override
    public void openListOfReceiptScreen() {
        Intent intent = new Intent(this, ReceiptListActivity.class);
        startActivity(intent);
    }

    @Override
    public void openInfoDialog() {
        InfoDialog infoDialog = new InfoDialog();
        infoDialog.show(getSupportFragmentManager(), "Info Dialog");
    }
}
