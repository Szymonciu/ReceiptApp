package com.example.pc.receiptapp.features.home;

import android.net.Uri;

import com.example.pc.receiptapp.database.LocalDataSource;
import com.example.pc.receiptapp.database.RealmReceipt;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;

    @Override
    public void onViewCreated() {
        if (LocalDataSource.getAll().isEmpty()) {
            initDb();
        }
    }

    @Override
    public void onAddReceiptButtonClick() {
        if (view != null) {
            view.openAddReceiptScreen();
        }
    }

    @Override
    public void onListOfReceiptButtonClick() {
        if (view != null) {
            view.openListOfReceiptScreen();
        }
    }

    @Override
    public void onInfoIconClick() {
        if (view != null) {
            view.openInfoDialog();
        }
    }


    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    private void initDb() {
        Uri uri = Uri.parse("android.resource://com.example.pc.receiptapp/drawable/test");
        RealmReceipt laptopReceipt = new RealmReceipt(1L, "Laptop Asus",
                "sklep xkom", "22-06-2018", uri.toString());


        RealmReceipt smartphoneReceipt = new RealmReceipt(2L, "Telefon Ksiaomi",
                "sklep xkom", "22-06-2018", uri.toString());

        LocalDataSource.save(laptopReceipt);
        LocalDataSource.save(smartphoneReceipt);
    }
}
