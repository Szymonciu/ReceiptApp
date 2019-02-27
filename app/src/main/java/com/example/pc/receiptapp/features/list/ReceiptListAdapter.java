package com.example.pc.receiptapp.features.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pc.receiptapp.R;
import com.example.pc.receiptapp.core.Receipt;

import java.util.List;

public class ReceiptListAdapter extends RecyclerView.Adapter<ReceiptListAdapter.ReceiptViewHolder> {


    private List<Receipt> receiptList;
    private OnReceiptClickedLisner lisner;

    public ReceiptListAdapter(OnReceiptClickedLisner lisner) {
        this.lisner = lisner;
    }

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
        private TextView place;
        private TextView date;
        private RelativeLayout container;

        public ReceiptViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            place = itemView.findViewById(R.id.place);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Receipt receipt) {

            title.setText(receipt.getTitle());
            place.setText(receipt.getPlace());
            date.setText(receipt.getDate());
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lisner.onClick(receipt);
                }
            });
        }

    }
}
