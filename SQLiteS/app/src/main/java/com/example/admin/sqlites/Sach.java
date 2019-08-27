package com.example.admin.sqlites;

public class Sach {
    private int id;
    private String ten;
    private String loai;

    public Sach() {
    }

    public Sach(int id, String ten,String loai) {
        this.id = id;
        this.ten = ten;
        this.loai =loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
