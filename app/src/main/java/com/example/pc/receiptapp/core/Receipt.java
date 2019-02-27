package com.example.pc.receiptapp.core;

import java.io.Serializable;

public class Receipt implements Serializable {
    private Long id;
    private String title;
    private String place;
    private String date;
    private String imagePath;


    public Receipt(Long id, String title, String place, String date, String imagePath) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
