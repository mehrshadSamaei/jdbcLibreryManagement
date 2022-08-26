package com.mehrshad.domain.basedomain;

import java.io.Serializable;

public abstract class Base<ID extends Serializable> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Base() {
    }

    public Base(ID id) {
        this.id = id;
    }
}
