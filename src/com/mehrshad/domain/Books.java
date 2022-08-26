package com.mehrshad.domain;

import com.mehrshad.domain.basedomain.Base;

public class Books extends Base<Integer> {
 private String name;
 private Boolean status;

    public Books(Integer integer, String name, Boolean status) {
        super(integer);
        this.name = name;
        this.status = status;
    }

    public Books() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
