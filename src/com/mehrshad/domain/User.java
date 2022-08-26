package com.mehrshad.domain;

import com.mehrshad.domain.basedomain.Person;

public class User extends Person {
//    private String emailAddress;
    public User(Integer id, String fullName, String username, String password) {
        super(id, fullName, username, password);
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{} " + super.toString();
    }
}
