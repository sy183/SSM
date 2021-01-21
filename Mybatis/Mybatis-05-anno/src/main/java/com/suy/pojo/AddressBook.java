package com.suy.pojo;

public class AddressBook {
    private int id;
    private String name;
    private String number;
    private String server;

    public AddressBook() {
    }

    public AddressBook(int id, String name, String number, String server) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.server = server;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
