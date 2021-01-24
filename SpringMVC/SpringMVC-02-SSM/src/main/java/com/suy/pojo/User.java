package com.suy.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Integer id;
    private String user;
    transient private String passwd;
    private Integer privilege;

    public User(String user, String passwd, int privilege) {
        this.user = user;
        this.passwd = passwd;
        this.privilege = privilege;
    }
}
