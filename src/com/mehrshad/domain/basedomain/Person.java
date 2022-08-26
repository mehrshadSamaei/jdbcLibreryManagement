package com.mehrshad.domain.basedomain;

import com.mehrshad.domain.basedomain.Base;

public abstract class Person extends Base<Integer> {
private String fullName;
private String username;
private String password;

    public Person(Integer integer, String fullName, String username, String password) {
        super(integer);
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


