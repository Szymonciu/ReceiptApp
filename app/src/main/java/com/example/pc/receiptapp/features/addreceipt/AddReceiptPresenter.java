package com.example.pc.receiptapp.features.addreceipt;

public class AddReceiptPresenter implements AddReceiptContract.Presenter {

    private AddReceiptContract.View view;

    @Override
    public void attackView(AddReceiptContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onConfirmButtonClicked(String receiptTitle, String receiptPurchaseLocation, String receiptDate) {

    }

    @Override
    public void onTakePhotoButtonClicked() {
        if (view != null) {
            view.openTakePhotoScreen();
        }
    }
}
