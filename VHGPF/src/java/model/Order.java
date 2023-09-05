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
public class Order {
    private int OrderID;
    private String OrderNote;
    
    private CustomerDetail CustomerDetail;
    private Customer Customer;
    private Employee Employee;
    private Status Status;
    private OrderDetail OrderDetail;

    //Update chia việc Order
    public Order(int OrderID, Employee Employee) {
        this.OrderID = OrderID;
        this.Employee = Employee;
    }

    public Order(int OrderID, String OrderNote) {
        this.OrderID = OrderID;
        this.OrderNote = OrderNote;
    }

    
    public Order(int OrderID, String OrderNote, CustomerDetail CustomerDetail, Customer Customer, Employee Employee, 
            Status Status, OrderDetail OrderDetail) {
        this.OrderID = OrderID;
        this.OrderNote = OrderNote;
        this.CustomerDetail = CustomerDetail;
        this.Customer = Customer;
        this.Employee = Employee;
        this.Status = Status;
        this.OrderDetail = OrderDetail;
    }

    //Checkout
    public Order(int OrderID, String OrderNote, Status Status, OrderDetail OrderDetail) {
        this.OrderID = OrderID;
        this.OrderNote = OrderNote;
        this.Status = Status;
        this.OrderDetail = OrderDetail;
    }



    
    public Order(int OrderID, String OrderNote, Customer Customer, Employee Employee, Status Status) {
        this.OrderID = OrderID;
        this.OrderNote = OrderNote;
        this.Customer = Customer;
        this.Employee = Employee;
        this.Status = Status;
    }

    public Order() {
    }

    public Order(int OrderID) {
        this.OrderID = OrderID;
    }

    public Order(String OrderNote, Customer Customer, Employee Employee) {
        this.OrderNote = OrderNote;
        this.Customer = Customer;
        this.Employee = Employee;
    }

    public Order(int OrderID, String OrderNote, Customer Customer, Employee Employee) {
        this.OrderID = OrderID;
        this.OrderNote = OrderNote;
        this.Customer = Customer;
        this.Employee = Employee;
    }
//getOrderbyOrderDetail
    public Order(int OrderID, String OrderNote, Customer Customer, Employee Employee, OrderDetail OrderDetail) {
        this.OrderID = OrderID;
        this.OrderNote = OrderNote;
        this.Customer = Customer;
        this.Employee = Employee;
        this.OrderDetail = OrderDetail;
    }


    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee EmployeeID) {
        this.Employee = Employee;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderNote() {
        return OrderNote;
    }

    public void setOrderNote(String OrderNote) {
        this.OrderNote = OrderNote;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer CustomerID) {
        this.Customer = CustomerID;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public OrderDetail getOrderDetail() {
        return OrderDetail;
    }

    public void setOrderDetail(OrderDetail OrderDetail) {
        this.OrderDetail = OrderDetail;
    }

    public CustomerDetail getCustomerDetail() {
        return CustomerDetail;
    }

    public void setCustomerDetail(CustomerDetail CustomerDetail) {
        this.CustomerDetail = CustomerDetail;
    }
    
}
