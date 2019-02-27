package com.example.pc.receiptapp.features.list;

import com.example.pc.receiptapp.core.Receipt;
import com.example.pc.receiptapp.database.LocalDataSource;
import com.example.pc.receiptapp.database.RealmReceipt;

import java.util.ArrayList;
import java.util.List;

public class ReceiptListPresenter implements ReceiptListContract.Presenter {

    private ReceiptListContract.View view;
    private Receipt receiptToDelete;

    @Override
    public void attachView(ReceiptListContract.View view) {
        this.view = view;
        getReceiptList();
    }

    @Override
    public void detachView() {
        this.view = null;
    }


    private void getReceiptList() {
        List<Receipt> receiptList = new ArrayList<>();
        List<RealmReceipt> realmReceipts = LocalDataSource.getAll();
        for (RealmReceipt realmReceipt : realmReceipts) {
            Receipt receipt = new Receipt(realmReceipt.getId(), realmReceipt.getTitle(), realmReceipt.getPlace(),
                    realmReceipt.getDate(), realmReceipt.getImagePath());

            receiptList.add(receipt);
        }

        if (view != null) {
            view.showReceiptList(receiptList);
        }

    }

    @Override
    public void onTrashIconClick(Receipt receipt) {
        receiptToDelete = receipt;
        if (view != null) {
            view.showDeleteAlert();
        }
    }

    @Override
    public void onDeleteAccepted() {
        RealmReceipt realmReceipt = new RealmReceipt(receiptToDelete.getId(), receiptToDelete.getTitle(),
                receiptToDelete.getPlace(), receiptToDelete.getDate(), receiptToDelete.getImagePath());
        LocalDataSource.delete(realmReceipt);

        if (view != null) {
            view.deleteItem(receiptToDelete);
            receiptToDelete = null;
        }
    }
}
