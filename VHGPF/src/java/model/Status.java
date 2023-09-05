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
public class Status {

    private int StatusID;
    private String StatusName;
    private Date OrderDate;
    private int Total;

    private Order Order;
    private Employee Employee;
    private OrderDetail OrderDetail;

    public Status() {
    }

    public Status(Employee Employee, OrderDetail OrderDetail) {
        this.Employee = Employee;
        this.OrderDetail = OrderDetail;
    }

    public Status(int Total, Employee Employee, OrderDetail OrderDetail) {
        this.Total = Total;
        this.Employee = Employee;
        this.OrderDetail = OrderDetail;
    }


    public Status(Order Order, Employee Employee) {
        this.Order = Order;
        this.Employee = Employee;
    }

    public Status(int StatusID, String StatusName, Date OrderDate, Order Order, Employee Employee, OrderDetail OrderDetail) {
        this.StatusID = StatusID;
        this.StatusName = StatusName;
        this.OrderDate = OrderDate;
        this.Order = Order;
        this.Employee = Employee;
        this.OrderDetail = OrderDetail;
    }

    public Status(int StatusID, String StatusName, Date OrderDate, Order Order, Employee Employee) {
        this.StatusID = StatusID;
        this.StatusName = StatusName;
        this.OrderDate = OrderDate;
        this.Order = Order;
        this.Employee = Employee;
    }

    public Status(String StatusName, Date OrderDate, Order Order, Employee Employee) {
        this.StatusName = StatusName;
        this.OrderDate = OrderDate;
        this.Order = Order;
        this.Employee = Employee;
    }

    public Status(int StatusID, String StatusName, Date OrderDate, Order Order) {
        this.StatusID = StatusID;
        this.StatusName = StatusName;
        this.OrderDate = OrderDate;
        this.Order = Order;
    }

    public Order getOrder() {
        return Order;
    }

    public void setOrder(Order Order) {
        this.Order = Order;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String StatusName) {
        this.StatusName = StatusName;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee Employee) {
        this.Employee = Employee;
    }

    public OrderDetail getOrderDetail() {
        return OrderDetail;
    }

    public void setOrderDetail(OrderDetail OrderDetail) {
        this.OrderDetail = OrderDetail;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

}
