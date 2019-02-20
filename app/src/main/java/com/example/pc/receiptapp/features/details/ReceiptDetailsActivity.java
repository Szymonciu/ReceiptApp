package com.example.pc.receiptapp.features.details;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.core.Receipt;

public class ReceiptDetailsActivity extends AppCompatActivity implements ReceiptDetailsContract.View {

    public static final String RECEIPT_KEY = "receipt key";

    private TextView title;
    private TextView place;
    private TextView date;
    private ImageView photo;

    private ReceiptDetailsContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_details);
        Receipt receipt = (Receipt) getIntent().getSerializableExtra(RECEIPT_KEY);
        initViews();
        initPresenter();
        presenter.onReceiptSuccessfullyRetrieved(receipt);
    }

    private void initPresenter() {
        presenter = new ReceiptDetailsPresenter();
        presenter.attachView(this);
    }

    private void initViews() {
        title = findViewById(R.id.title_value);
        place = findViewById(R.id.place_value);
        date = findViewById(R.id.date_value);
        photo = findViewById(R.id.image);
    }


    @Override
    public void showReceipt(Receipt receipt) {
        title.setText(receipt.getTitle());
        place.setText(receipt.getPlace());
        date.setText(receipt.getDate());
        photo.setImageURI(Uri.parse(receipt.getImagePath()));
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
