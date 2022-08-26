package com.mehrshad.domain;

import com.mehrshad.domain.basedomain.Base;

import java.util.Date;

public class Tarefe extends Base<Integer> {
    private Date date ;
    private Double amount;

    public Tarefe(Integer integer, Date date, Double amount) {
        super(integer);
        this.date = date;
        this.amount = amount;
    }

    public Tarefe() {
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
