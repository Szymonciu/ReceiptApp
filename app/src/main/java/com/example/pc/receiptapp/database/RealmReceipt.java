package com.example.pc.receiptapp.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmReceipt extends RealmObject {

    @PrimaryKey
    private String id;
    private String title;
    private String place;
    private String date;
    private String imagePath;

    public RealmReceipt() {

    }

    public RealmReceipt(String id, String title, String place, String date, String imagePath) {
        this.id = id;
        this.title = title;
        this.place = place;
        this.date = date;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "RealmReceipt{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
