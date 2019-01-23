package com.example.pc.receiptapp.features.addreceipt;

import android.net.Uri;

import com.example.pc.receiptapp.database.LocalDataSource;
import com.example.pc.receiptapp.database.RealmReceipt;

public class AddReceiptPresenter implements AddReceiptContract.Presenter {

    private AddReceiptContract.View view;

    @Override
    public void attachView(AddReceiptContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }


    @Override
    public void onConfirmButtonClicked(String receiptTitle, String receiptPurchaseLocation, String receiptDate, Uri imageURI) {
        if (receiptTitle.isEmpty() || receiptDate.isEmpty() || receiptPurchaseLocation.isEmpty() || imageURI == null) {
            if (view != null) {
                view.showFieldsMustNotBeEmptyMessage();
            }
        } else {
            RealmReceipt realmReceipt = new RealmReceipt(System.currentTimeMillis(), receiptTitle, receiptPurchaseLocation, receiptDate, imageURI.toString());
            LocalDataSource.save(realmReceipt);
            if (view != null) {
                view.closeScreen();
            }

        }

    }

    @Override
    public void onTakePhotoButtonClicked() {
        if (view != null) {
            view.openTakePhotoScreen();
        }
    }


}
