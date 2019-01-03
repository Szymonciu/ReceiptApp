package com.example.pc.receiptapp.core;

public class Receipt {
    private String title;
    private String place;
    private String date;
    private String imagePath;


    public Receipt(String title, String place, String date, String imagePath) {
        this.title = title;
        this.place = place;
        this.date = date;
        this.imagePath = imagePath;
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
        return "Receipt{" +
                "title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
