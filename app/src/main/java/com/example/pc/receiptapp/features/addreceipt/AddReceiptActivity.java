package com.example.pc.receiptapp.features.addreceipt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pc.receiptapp.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddReceiptActivity extends AppCompatActivity implements AddReceiptContract.View {

    private EditText receiptTitleEditText;
    private EditText receiptPurchaseLocationEditText;
    private EditText receiptDateEditText;
    private AddReceiptContract.Presenter presenter;


    private Button addReceipt;
    private Button addPhoto;

    private ImageView receiptPhoto;

    private Uri photoURI;
    private static final int REQUEST_TAKE_PHOTO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receipt);

        initViews();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    private void initPresenter() {
        presenter = new AddReceiptPresenter();
        presenter.attachView(this);
    }

    private void initViews() {
        receiptPurchaseLocationEditText = findViewById(R.id.receipt_purchase_location);
        receiptDateEditText = findViewById(R.id.receipt_date);
        receiptTitleEditText = findViewById(R.id.receipt_title);
        receiptPhoto = findViewById(R.id.receipt_photo);
        addReceipt = findViewById(R.id.confirm);
        addReceipt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String receiptTitle = receiptTitleEditText.getText().toString();
                String receiptPurchaseLocation = receiptPurchaseLocationEditText.getText().toString();
                String receiptDate = receiptDateEditText.getText().toString();
                presenter.onConfirmButtonClicked(receiptTitle, receiptPurchaseLocation, receiptDate, photoURI);

            }
        });
        addPhoto = findViewById(R.id.add_photo_button);
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTakePhotoButtonClicked();
            }
        });
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            receiptPhoto.setImageURI(photoURI);
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        // Save a file: path for use with ACTION_VIEW intents
        return File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
    }


    @Override
    public void closeScreen() {
        finish();
    }

    @Override
    public void openTakePhotoScreen() {
        dispatchTakePictureIntent();
    }

    @Override
    public void showFieldsMustNotBeEmptyMessage() {
        Toast.makeText(this, "Fields must not be empty!", Toast.LENGTH_SHORT).show();
    }
}
