package com.example.pc.receiptapp.core;

public interface BaseContract {

    interface View {

    }

    interface Presenter<T extends BaseContract.View> {
        void attachView(T view);

        void detachView();
    }
}
