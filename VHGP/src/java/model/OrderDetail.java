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
public class OrderDetail {

    /**
     * @return the StatusObject
     */

    private int OrderID;
    private int ServiceID;
    private String OrderDServiceName;
    private double OrderDServicePrice;
    private String OrderDIDevics;
    private String Pay;
    private String Status;
    private Status StatusObject;
    private Date timeStart;
    private Date timeEnd;
    private int ServiceTime;

    private Employee Employee;
    public OrderDetail() {
    }

    public OrderDetail(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
//Update OrderDetail
    public OrderDetail(int OrderID, Date timeStart, Date timeEnd, int ServiceTime) {
        this.OrderID = OrderID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.ServiceTime = ServiceTime;
    }

    public OrderDetail(int OrderID, int ServiceID, String OrderDServiceName, double OrderDServicePrice, 
            String OrderDIDevics, String Pay, String Status) {
        this.OrderID = OrderID;
        this.ServiceID = ServiceID;
        this.OrderDServiceName = OrderDServiceName;
        this.OrderDServicePrice = OrderDServicePrice;
        this.OrderDIDevics = OrderDIDevics;
        this.Pay = Pay;
        this.Status = Status;
    }

    public OrderDetail(int ServiceID, String OrderDServiceName, double OrderDServicePrice, String OrderDIDevics, String Pay, Status Status) {
        this.ServiceID = ServiceID;
        this.OrderDServiceName = OrderDServiceName;
        this.OrderDServicePrice = OrderDServicePrice;
        this.OrderDIDevics = OrderDIDevics;
        this.Pay = Pay;
        this.StatusObject = StatusObject;
    }

    public OrderDetail(int OrderID, int ServiceID, String OrderDServiceName, double OrderDServicePrice, String OrderDIDevics, String Pay, Status Status) {
        this.OrderID = OrderID;
        this.ServiceID = ServiceID;
        this.OrderDServiceName = OrderDServiceName;
        this.OrderDServicePrice = OrderDServicePrice;
        this.OrderDIDevics = OrderDIDevics;
        this.Pay = Pay;
        this.StatusObject = StatusObject;
    }

    public OrderDetail(int OrderID, int ServiceID, String OrderDServiceName, double OrderDServicePrice, 
            String OrderDIDevics, String Pay, String Status, Date timeStart, Date timeEnd, int ServiceTime) {
        this.OrderID = OrderID;
        this.ServiceID = ServiceID;
        this.OrderDServiceName = OrderDServiceName;
        this.OrderDServicePrice = OrderDServicePrice;
        this.OrderDIDevics = OrderDIDevics;
        this.Pay = Pay;
        this.Status = Status;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.ServiceTime = ServiceTime;
    }


    //Tạo bảng OrderDetails
    public OrderDetail(int OrderID, int ServiceID, String OrderDServiceName, 
            double OrderDServicePrice, String OrderDIDevics, String Pay, String Status, 
            Date timeStart, Date timeEnd) {
        this.OrderID = OrderID;
        this.ServiceID = ServiceID;
        this.OrderDServiceName = OrderDServiceName;
        this.OrderDServicePrice = OrderDServicePrice;
        this.OrderDIDevics = OrderDIDevics;
        this.Pay = Pay;
        this.Status = Status;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public OrderDetail(int _OrderID, int _ServiceID, String _OrderDServiceName, double _OrderDServicePrice, 
            String _OrderDIDevices, String _Pay, String Status, Status StatusID) {
        this.OrderID = _OrderID;
        this.ServiceID = _ServiceID;
        this.OrderDServiceName = _OrderDServiceName;
        this.OrderDServicePrice = _OrderDServicePrice;
        this.OrderDIDevics = _OrderDIDevices;
        this.Pay = _Pay;
        this.Status = Status;
        this.StatusObject = StatusID;
    }

    //getListJob()
    public OrderDetail(int OrderID, int ServiceID, String OrderDServiceName, double OrderDServicePrice, 
            String OrderDIDevics, String Pay, Status StatusObject, Date timeStart, Date timeEnd, int ServiceTime, 
            Employee Employee) {
        this.OrderID = OrderID;
        this.ServiceID = ServiceID;
        this.OrderDServiceName = OrderDServiceName;
        this.OrderDServicePrice = OrderDServicePrice;
        this.OrderDIDevics = OrderDIDevics;
        this.Pay = Pay;
        this.StatusObject = StatusObject;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.ServiceTime = ServiceTime;
        this.Employee = Employee;
    }
    
      //getStatus - OrderDetail
    public OrderDetail(int OrderID, int ServiceID, String OrderDServiceName, double OrderDServicePrice, 
            String OrderDIDevics, String Pay, String Status, Status StatusObject, Date timeStart, Date timeEnd, int ServiceTime) {
        this.OrderID = OrderID;
        this.ServiceID = ServiceID;
        this.OrderDServiceName = OrderDServiceName;
        this.OrderDServicePrice = OrderDServicePrice;
        this.OrderDIDevics = OrderDIDevics;
        this.Pay = Pay;
        this.Status = Status;
        this.StatusObject = StatusObject;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.ServiceTime = ServiceTime;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getServiceID() {
        return ServiceID;
    }

    public void setServiceID(int ServiceID) {
        this.ServiceID = ServiceID;
    }

    public String getOrderDServiceName() {
        return OrderDServiceName;
    }

    public void setOrderDServiceName(String OrderDServiceName) {
        this.OrderDServiceName = OrderDServiceName;
    }

    public double getOrderDServicePrice() {
        return OrderDServicePrice;
    }

    public void setOrderDServicePrice(double OrderDServicePrice) {
        this.OrderDServicePrice = OrderDServicePrice;
    }

    public String getOrderDIDevics() {
        return OrderDIDevics;
    }

    public void setOrderDIDevics(String OrderDIDevics) {
        this.OrderDIDevics = OrderDIDevics;
    }

    public String getPay() {
        return Pay;
    }

    public void setPay(String Pay) {
        this.Pay = Pay;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setStatusObject(Status StatusObject) {
        this.StatusObject = StatusObject;
    }

    public Status getStatusObject() {
        return StatusObject;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getServiceTime() {
        return ServiceTime;
    }

    public void setServiceTime(int ServiceTime) {
        this.ServiceTime = ServiceTime;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee Employee) {
        this.Employee = Employee;
    }

}
