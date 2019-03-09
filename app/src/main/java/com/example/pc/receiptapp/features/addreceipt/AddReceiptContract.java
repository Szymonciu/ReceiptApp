package com.example.pc.receiptapp.features.addreceipt;

import android.net.Uri;

import com.example.pc.receiptapp.core.BaseContract;

public interface AddReceiptContract {
    interface View extends BaseContract.View {
        void closeScreen();

        void openTakePhotoScreen();

        void showFieldsMustNotBeEmptyMessage();

    }

    interface Presenter extends BaseContract.Presenter<View> {
        void onConfirmButtonClicked(String receiptTitle, String receiptPurchaseLocation,
                                    String receiptDate, Uri imageURI);

        void onTakePhotoButtonClicked();

    }
}
