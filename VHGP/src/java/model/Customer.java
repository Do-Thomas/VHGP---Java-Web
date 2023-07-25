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
public class Customer {

    private int CustomerID;
    private String CustomerName;
    private String Phone;
    private String Password;
    private Date BirthDay;
    private String Email;
    private String CustomerAddress;
    private Boolean Gender;
    private Role Role;

    private String confirm;

    public Customer() {
    }

    public Customer(int CustomerID, String CustomerName) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
    }

    //Details - CustomerDAO
    public Customer(String CustomerName, String Phone, String Password, Date BirthDay, String Email, String CustomerAddress, Boolean Gender) {
        this.CustomerName = CustomerName;
        this.Phone = Phone;
        this.Password = Password;
        this.BirthDay = BirthDay;
        this.Email = Email;
        this.CustomerAddress = CustomerAddress;
        this.Gender = Gender;
    }

    public Customer(int CustomerID, String CustomerName, String Phone, String Password, Date BirthDay, String CustomerAddress, Boolean Gender) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Phone = Phone;
        this.Password = Password;
        this.BirthDay = BirthDay;
        this.CustomerAddress = CustomerAddress;
        this.Gender = Gender;
    }

    public Customer(String CustomerName, String Phone, String Password, Date BirthDay, String Email, String CustomerAddress, Boolean Gender, Role RoleID, String confirm) {

        this.CustomerName = CustomerName;
        this.Phone = Phone;
        this.Password = Password;
        this.BirthDay = BirthDay;
        this.Email = Email;
        this.CustomerAddress = CustomerAddress;
        this.Gender = Gender;
        this.Role = RoleID;
        this.confirm = confirm;
    }

    public Customer(int CustomerID, String CustomerName, String Phone, String Password, Date BirthDay, String Email, String CustomerAddress, Boolean Gender, Role RoleID) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Phone = Phone;
        this.Password = Password;
        this.BirthDay = BirthDay;
        this.Email = Email;
        this.CustomerAddress = CustomerAddress;
        this.Gender = Gender;
        this.Role = RoleID;
    }

    public Customer(int _ID, String _CustomerName, String _Phone, String _Password, 
            java.sql.Date _BirthDay, String _Email, String _CustomerAddress, Boolean _Gender) {
        this.CustomerID = _ID;
        this.CustomerName = _CustomerName;
        this.Phone = _Phone;
        this.Password = _Password;
        this.BirthDay = _BirthDay;
        this.Email = _Email;
        this.CustomerAddress = _CustomerAddress;
        this.Gender = _Gender;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date BirthDay) {
        this.BirthDay = BirthDay;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean Gender) {
        this.Gender = Gender;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setBirthDay(String invalid_birth_date_format) {

    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role Role) {
        this.Role = Role;
    }

    public boolean isGender() {
        return Gender;
    }
}
