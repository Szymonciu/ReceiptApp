package com.example.pc.receiptapp.app;

import android.app.Application;

import io.realm.Realm;

public class ReceiptApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

}
