package com.example.pc.receiptapp.features.details;

import com.example.pc.receiptapp.core.Receipt;

public class ReceiptDetailsPresenter implements ReceiptDetailsContract.Presenter {

    private ReceiptDetailsContract.View view;

    @Override
    public void attachView(ReceiptDetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onReceiptSuccessfullyRetrieved(Receipt receipt) {
        if (view != null) {
            view.showReceipt(receipt);
        }
    }
}
