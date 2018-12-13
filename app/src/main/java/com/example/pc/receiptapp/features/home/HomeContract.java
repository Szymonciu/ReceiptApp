package com.example.pc.receiptapp.features.home;

import com.example.pc.receiptapp.core.BaseContract;

public interface HomeContract {
    interface View extends BaseContract.View {
        void openAddReceiptScreen();

        void openListOfReceiptScreen();

        void openInfoDialog();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void onAddReceiptButtonClick();

        void onListOfReceiptButtonClick();

        void onInfoIconClick();
    }
}
