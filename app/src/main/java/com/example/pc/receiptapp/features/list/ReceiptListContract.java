package com.example.pc.receiptapp.features.list;

import com.example.pc.receiptapp.core.BaseContract;
import com.example.pc.receiptapp.core.Receipt;

import java.util.List;

public interface ReceiptListContract {
    interface View extends BaseContract.View {
        void showReceiptList(List<Receipt> receiptList);
    }

    interface Presenter extends BaseContract.Presenter<View> {

    }
}
