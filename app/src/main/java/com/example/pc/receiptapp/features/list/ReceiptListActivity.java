package com.example.pc.receiptapp.features.list;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.core.Receipt;
import com.example.pc.receiptapp.features.details.ReceiptDetailsActivity;

import java.util.List;

public class ReceiptListActivity extends AppCompatActivity implements ReceiptListContract.View {

    private RecyclerView recyclerView;
    private ReceiptListAdapter adapter;
    private ReceiptListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_list);

        setupRecycler();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    private void initPresenter() {
        presenter = new ReceiptListPresenter();
        presenter.attachView(this);
    }

    private void setupRecycler() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ReceiptListAdapter(new OnReceiptClickedListener() {
            @Override
            public void onItemClick(Receipt receipt) {
                openReceiptDetails(receipt);
            }

            @Override
            public void onTrashIconClick(Receipt receipt) {
                presenter.onTrashIconClick(receipt);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void openReceiptDetails(Receipt receipt) {
        Intent intent = new Intent(this, ReceiptDetailsActivity.class);
        intent.putExtra(ReceiptDetailsActivity.RECEIPT_KEY, receipt);
        startActivity(intent);
    }


    @Override
    public void showReceiptList(List<Receipt> receiptList) {
        adapter.setReceiptList(receiptList);
    }

    @Override
    public void showDeleteAlert() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Are you sure to delete this receipt?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.onDeleteAccepted();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    @Override
    public void deleteItem(Receipt receipt) {
        adapter.deleteItem(receipt);
    }
}
