package com.example.pc.receiptapp.features.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.core.Receipt;
import com.example.pc.receiptapp.database.LocalDataSource;
import com.example.pc.receiptapp.database.RealmReceipt;

import java.util.ArrayList;
import java.util.List;

public class ReceiptListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReceiptListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_list);

        setupRecycler();
        initAdapter();
    }

    private void setupRecycler() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ReceiptListAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void initAdapter() {
//        List<Receipt> receiptList = Arrays.asList(
//                new Receipt("Winter Boots"),
//                new Receipt("Alkohol"),
//                new Receipt("Computer")
//        );
        List<Receipt> receiptList = new ArrayList<>();
        List<RealmReceipt> realmReceipts = LocalDataSource.getAll();
        for (RealmReceipt realmReceipt : realmReceipts) {
            Receipt receipt = new Receipt(realmReceipt.getTitle(), realmReceipt.getPlace(),
                    realmReceipt.getDate(), realmReceipt.getImagePath());

            receiptList.add(receipt);
        }

        adapter.setReceiptList(receiptList);
    }
}
