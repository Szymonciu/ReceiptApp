package com.example.pc.receiptapp.features.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.core.Receipt;

import java.util.List;

public class ReceiptListAdapter extends RecyclerView.Adapter<ReceiptListAdapter.ReceiptViewHolder> {


    private List<Receipt> receiptList;

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    @NonNull
    @Override
    public ReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_receipt, viewGroup, false);
        return new ReceiptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiptViewHolder receiptViewHolder, int position) {
        Receipt receipt = receiptList.get(position);
        receiptViewHolder.bind(receipt);
    }

    @Override
    public int getItemCount() {
        return receiptList.size();
    }

    public class ReceiptViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public ReceiptViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }

        public void bind(Receipt receipt) {
            title.setText(receipt.getTitle());
        }
    }
}
