package com.mehrshad.domain;

import com.mehrshad.domain.basedomain.Person;

public class Admin extends Person {
    public Admin(Integer id, String fullName, String username, String password) {
        super(id, fullName, username, password);
    }

    public Admin() {
    }
}
