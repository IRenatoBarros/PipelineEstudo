package com.example.calculadoraservlet;



public class UserRequest {
    private double prodid;
    private String descript;

    public UserRequest(String descript) {
        this.descript = descript;
    }

    public double getProdid() {
        return prodid;
    }

    public void setProdid(double prodid) {
        this.prodid = prodid;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
