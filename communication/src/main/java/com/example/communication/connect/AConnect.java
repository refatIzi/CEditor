package com.example.communication.connect;

import com.example.dashboard.status.DetectFile;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AConnect implements Serializable {
    String hostName;
    String[] detect_info;
    String status;

    public AConnect(String hostName, String[] detect_info, String status) {
        this.hostName = hostName;
        this.detect_info = detect_info;
        this.status = status;
    }

    public AConnect() {

    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String[] getDetect_info() {
        return detect_info;
    }

    public void setDetect_info(String[] detect_info) {
        this.detect_info = detect_info;
    }

    public String getStatus() {
        return status;
    }
    public String getFiles(){
        return Arrays.asList(detect_info).stream()
                .map(String::toString)
                .collect(Collectors.joining(", "));
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
