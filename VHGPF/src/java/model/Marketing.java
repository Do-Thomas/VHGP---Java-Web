/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Marketing {

    private String Event;

    private Services ServiceID;

    private Date EndTime;
    private Date StartTime;
    private int Voucher;

    public Marketing() {
    }

    public Marketing(String Event, Services ServiceID, Date EndTime, Date StartTime, int Voucher) {
        this.Event = Event;
        this.ServiceID = ServiceID;
        this.EndTime = EndTime;
        this.StartTime = StartTime;
        this.Voucher = Voucher;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String Event) {
        this.Event = Event;
    }

    public Services getServiceID() {
        return ServiceID;
    }

    public void setServiceID(Services ServiceID) {
        this.ServiceID = ServiceID;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date EndTime) {
        this.EndTime = EndTime;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date StartTime) {
        this.StartTime = StartTime;
    }

    public int getVoucher() {
        return Voucher;
    }

    public void setVoucher(int Voucher) {
        this.Voucher = Voucher;
    }

    //add
    public void setStartTime(String invalid_start_time_date_format) {
    }

    public void setEndTime(String invalid_start_time_date_format) {
    }

}
