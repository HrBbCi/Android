package com.ptit.hrbbci.gridviewcustomadapter;

public class HinhAnh {
    private String name;
    private int image;

    public HinhAnh(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
