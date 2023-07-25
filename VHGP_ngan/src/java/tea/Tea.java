/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tea;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Ngân
 */
public class Tea {

    private String madv;
    private String tendv;
    private double dongia;
//    private int soluong;
    private String details;
    private double thoigian;
    private String hinhanh;
    private Date deliveryDate;
    private Date deliveryTime;

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Tea(String madv, String tendv, double dongia, String details, double thoigian, String hinhanh, Date deliveryDate, Date deliveryTime) {
        this.madv = madv;
        this.tendv = tendv;
        this.dongia = dongia;
        this.details = details;
        this.thoigian = thoigian;
        this.hinhanh = hinhanh;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
    }

    public Tea(String madv, String tendv, double dongia, String details, double thoigian, String hinhanh, Date deliveryDate) {
        this.madv = madv;
        this.tendv = tendv;
        this.dongia = dongia;
        this.details = details;
        this.thoigian = thoigian;
        this.hinhanh = hinhanh;
        this.deliveryDate = deliveryDate;
    }
    public Tea() {
        this.madv = "";
        this.tendv = "";
        this.dongia = 0;
        this.details = "";
        this.thoigian = 0;
        this.hinhanh = "";
         this.deliveryDate = null;
        this.deliveryTime = null;
        
    }

    public Tea(String madv, String tendv, double dongia, String details, double thoigian, String hinhanh) {
        this.madv = madv;
        this.tendv = tendv;
        this.dongia = dongia;
        this.details = details;
        this.thoigian = thoigian;
        this.hinhanh = hinhanh;
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

//    public int getSoluong() {
//        return soluong;
//    }
//
//    public void setSoluong(int soluong) {
//        this.soluong = soluong;
//    }
    public double getThoigian() {
        return thoigian;
    }

    public void setThoigian(double thoigian) {
        this.thoigian = thoigian;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
