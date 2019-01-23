package com.example.pc.receiptapp.features.home;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;

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
}
