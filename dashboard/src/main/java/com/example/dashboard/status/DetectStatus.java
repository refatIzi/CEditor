package com.example.dashboard.status;

import com.example.serializationutils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DetectStatus implements Serializable {
    private DetectHost detectHost;
    private DetectFile[] detectFiles;

    public DetectStatus() {

    }

    public DetectStatus(DetectHost detectHost, DetectFile[] detectFiles) {
        this.detectHost = detectHost;
        this.detectFiles = detectFiles;
    }

    public DetectStatus(DetectFile[] detectFiles) {
        this.detectFiles = detectFiles;
    }

    public DetectStatus(DetectHost detectHost) {
        this.detectHost = detectHost;
    }


    public DetectHost getHost() {
        return detectHost;
    }

    public void setHost(DetectHost detectHost) {
        this.detectHost = detectHost;
    }

    public DetectFile[] getDetectFile() {
        return detectFiles;
    }

    public void setDetectFile(DetectFile[] detectFiles) {
        this.detectFiles = detectFiles;
    }

    public DetectStatus status(byte[] bytes) {
        try {
            return (DetectStatus) SerializationUtils.deserialize(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDetected() {
        return Arrays.asList(detectFiles).stream()
                .map(DetectFile::getFile_name)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "Status";
    }
}
