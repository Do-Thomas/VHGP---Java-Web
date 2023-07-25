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
public class ConfirmPay {
    
    private int ConfirmID;
    private String ConfirmEmp;
    private String ConfirmCus;
    private String StatusPay;
    
//    private Employee Employee;
    private Status Status;
    private Customer Customer;

    public ConfirmPay(String ConfirmEmp, String ConfirmCus, String StatusPay, Status Status, Customer Customer) {
        this.ConfirmEmp = ConfirmEmp;
        this.ConfirmCus = ConfirmCus;
        this.StatusPay = StatusPay;
        this.Status = Status;
        this.Customer = Customer;
    }


    public String getConfirmEmp() {
        return ConfirmEmp;
    }

    public void setConfirmEmp(String ConfirmEmp) {
        this.ConfirmEmp = ConfirmEmp;
    }

    public String getConfirmCus() {
        return ConfirmCus;
    }

    public void setConfirmCus(String ConfirmCus) {
        this.ConfirmCus = ConfirmCus;
    }

    public String getStatusPay() {
        return StatusPay;
    }

    public void setStatusPay(String StatusPay) {
        this.StatusPay = StatusPay;
    }


    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public int getConfirmID() {
        return ConfirmID;
    }

    public void setConfirmID(int ConfirmID) {
        this.ConfirmID = ConfirmID;
    }
}
