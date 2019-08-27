package com.ptit.hrbbci.intentexplicit;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int date;

    public Student(String name, int date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
