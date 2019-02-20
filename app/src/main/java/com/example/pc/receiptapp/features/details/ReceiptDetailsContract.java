package com.example.pc.receiptapp.features.details;

import com.example.pc.receiptapp.core.BaseContract;
import com.example.pc.receiptapp.core.Receipt;

public interface ReceiptDetailsContract {
    interface View extends BaseContract.View {
        void showReceipt(Receipt receipt);

    }

    interface Presenter extends BaseContract.Presenter<View> {
        void onReceiptSuccessfullyRetrieved(Receipt receipt);
    }
}
