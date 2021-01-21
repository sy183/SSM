package com.suy.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
    private int id;
    private String user;
    private String passwd;
    private int privilege;
    private Information information;

    public User() {
    }

    public User(int id, String user, String passwd, int privilege, Information information) {
        this.id = id;
        this.user = user;
        this.passwd = passwd;
        this.privilege = privilege;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    @Value("1")
    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    @Value("suy")
    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    @Value("css66018")
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getPrivilege() {
        return privilege;
    }

    @Value("256")
    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public Information getInformation() {
        return information;
    }

    @Autowired
    public void setInformation(Information information) {
        this.information = information;
    }
}
