package com.example.dashboard.detect;

public class Detect {

    private String file_name;
    private String time_create;
    private String detect_info;
    private int image;


    public Detect(String file_name, String time_create, String detect_info, int image) {
        this.file_name = file_name;
        this.time_create = time_create;
        this.detect_info = detect_info;
        this.image = image;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getTime_create() {
        return time_create;
    }

    public void setTime_create(String name) {
        this.time_create = time_create;
    }

    public String getDetect_info() {
        return detect_info;
    }

    public void setDetect_info(String detect_info) {
        this.detect_info = detect_info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
