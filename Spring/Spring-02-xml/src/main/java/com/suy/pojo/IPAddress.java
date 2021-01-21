package com.suy.pojo;

public class IPAddress {
    private String address;
    private int netmask;

    public IPAddress() {
    }

    public IPAddress(String address, int netmask) {
        this.address = address;
        this.netmask = netmask;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNetmask() {
        return netmask;
    }

    public void setNetmask(int netmask) {
        this.netmask = netmask;
    }
}
