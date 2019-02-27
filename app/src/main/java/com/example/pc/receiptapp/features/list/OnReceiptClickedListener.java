package com.example.pc.receiptapp.features.list;

import com.example.pc.receiptapp.core.Receipt;

public interface OnReceiptClickedListener {
    void onItemClick(Receipt receipt);

    void onTrashIconClick(Receipt receipt);
}
