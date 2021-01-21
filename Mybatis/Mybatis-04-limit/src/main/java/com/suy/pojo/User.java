package com.suy.pojo;

public class User {
    private int id;
    private String user;
    private String passwd;
    private int privilege;

    public User() {
    }

    public User(int id, String user, String passwd, int privilege) {
        this.id = id;
        this.user = user;
        this.passwd = passwd;
        this.privilege = privilege;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }
}
