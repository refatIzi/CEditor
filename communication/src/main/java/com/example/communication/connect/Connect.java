package com.example.communication.connect;

public class Connect {

    private String nomber;
    private String time;
    private String information;
    private int image;


    public Connect(String nomber, String time, String information, int image) {
        this.nomber = nomber;
        this.time = time;
        this.information = information;
        this.image = image;
    }

    public String getNumber() {
        return nomber;
    }

    public void setNumber(String number) {
        this.nomber = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
