package com.suy.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Network {
    private String MacAddress;
    private List<IPAddress> addresses;
    private IPAddress gateway;
    private Map<String, String> arpTable;
    private Set<IPAddress> dns;
    private String description;
    private Properties info;

    public Network() {
    }

    public Network(String macAddress,
                   List<IPAddress> addresses,
                   IPAddress gateway,
                   Map<String, String> arpTable,
                   Set<IPAddress> dns,
                   String description,
                   Properties info) {
        MacAddress = macAddress;
        this.addresses = addresses;
        this.gateway = gateway;
        this.arpTable = arpTable;
        this.dns = dns;
        this.description = description;
        this.info = info;
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String macAddress) {
        MacAddress = macAddress;
    }

    public List<IPAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<IPAddress> addresses) {
        this.addresses = addresses;
    }

    public IPAddress getGateway() {
        return gateway;
    }

    public void setGateway(IPAddress gateway) {
        this.gateway = gateway;
    }

    public Map<String, String> getArpTable() {
        return arpTable;
    }

    public void setArpTable(Map<String, String> arpTable) {
        this.arpTable = arpTable;
    }

    public Set<IPAddress> getDns() {
        return dns;
    }

    public void setDns(Set<IPAddress> dns) {
        this.dns = dns;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }
}
