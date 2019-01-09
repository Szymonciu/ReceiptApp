package com.example.pc.receiptapp.features.addreceipt;

import com.example.pc.receiptapp.core.BaseContract;

public interface AddReceiptContract {
    interface View extends BaseContract.View {
        void closeScreen();

        void openTakePhotoScreen();


    }

    interface Presenter extends BaseContract.Presenter<View> {
        void onConfirmButtonClicked(String receiptTitle, String receiptPurchaseLocation, String receiptDate);

        void onTakePhotoButtonClicked();


    }
}
