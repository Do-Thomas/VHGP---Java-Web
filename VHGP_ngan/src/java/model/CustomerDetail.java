/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public class CustomerDetail {

    private int CustomerDID;
    private String CustomerAddress;
    private String Phone;
    private Customer customer;

    private Order Order;

    public CustomerDetail() {
    }

    public CustomerDetail(int CustomerDID, String CustomerAddress, String Phone, Customer customer, Order Order) {
        this.CustomerDID = CustomerDID;
        this.CustomerAddress = CustomerAddress;
        this.Phone = Phone;
        this.customer = customer;
        this.Order = Order;
    }

    public CustomerDetail(String CustomerAddress, String Phone, Customer customer, Order Order) {
        this.CustomerAddress = CustomerAddress;
        this.Phone = Phone;
        this.customer = customer;
        this.Order = Order;
    }



    public CustomerDetail(String CustomerAddress, Customer customer, Order Order) {
        this.CustomerAddress = CustomerAddress;
        this.customer = customer;
        this.Order = Order;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return Order;
    }

    public void setOrder(Order Order) {
        this.Order = Order;
    }

    public int getCustomerDID() {
        return CustomerDID;
    }

    public void setCustomerDID(int CustomerDID) {
        this.CustomerDID = CustomerDID;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

}
