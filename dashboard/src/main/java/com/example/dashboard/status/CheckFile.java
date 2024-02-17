package com.example.dashboard.status;

import java.io.Serializable;

public class CheckFile implements Serializable {
    private String file_name;
    private String time_create;
    private String detect_info;

    public CheckFile(String file_name, String time_create, String detect_info) {
        this.file_name = file_name;
        this.time_create = time_create;
        this.detect_info = detect_info;
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

    public void setTime_create(String time_create) {
        this.time_create = time_create;
    }

    public String getDetect_info() {
        return detect_info;
    }

    public void setDetect_info(String detect_info) {
        this.detect_info = detect_info;
    }
}
