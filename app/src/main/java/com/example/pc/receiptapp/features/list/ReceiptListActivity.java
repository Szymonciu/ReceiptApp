package com.example.pc.receiptapp.features.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.core.Receipt;

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
        presenter.attackView(this);
    }

    private void setupRecycler() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ReceiptListAdapter();
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void showReceiptList(List<Receipt> receiptList) {
        adapter.setReceiptList(receiptList);
    }
}
