package com.example.dashboard.folder;


import com.example.serializationutils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class FileDetected implements Serializable {

    public FileDetected verification(byte[] bytes) {
        try {
            return (FileDetected) SerializationUtils.deserialize(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
