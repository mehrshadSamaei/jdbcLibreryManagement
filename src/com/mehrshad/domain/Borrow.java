package com.mehrshad.domain;

import com.mehrshad.domain.basedomain.Base;

import java.sql.Date;

public class Borrow extends Base<Integer> {
    private Date date;
    private Status status;
    private int bookId;
    private int userid;

    public Borrow() {
    }

    public Borrow(Integer integer, Date date, Status status, int bookId, int userid) {
        super(integer);
        this.date = date;
        this.status = status;
        this.bookId = bookId;
        this.userid = userid;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status.ordinal();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}

