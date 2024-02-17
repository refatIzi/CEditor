package com.example.dashboard.status;

import java.io.Serializable;

public class CheckHost implements Serializable {
    String hostName;
    String ipAddress;
    String macAddress;

    public CheckHost(String hostName, String ipAddress, String macAddress) {
        this.hostName = hostName;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
