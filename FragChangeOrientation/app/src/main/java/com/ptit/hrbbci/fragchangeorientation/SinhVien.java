package com.ptit.hrbbci.fragchangeorientation;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String hoTen,diaChi,Email;
    private int namSinh;

    public SinhVien(String hoTen, String diaChi, String email, int namSinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        Email = email;
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
}
