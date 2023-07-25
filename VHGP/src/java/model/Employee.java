/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Employee {

    private int EmployeeID;
    private String EmployeeName;
    private Date BirthDay;
    private String EmployeePhone;
    private String EmployeeAddress;
    private String EmployeePicture;
    private boolean EmployeeGender;
    private String roleID;
    private Category category;
    private String Password;
    private int Status;
    private String confirm;
    private Role role;

    private OrderDetail OrderDetail;
    private Status StatusObject;
    public Employee() {
    }

    public Employee(String EmployeeName, Date BirthDay, String EmployeePhone, 
            String EmployeeAddress, String EmployeePicture, boolean EmployeeGender, 
            String roleID, Category category, String Password, int Status, String confirm) {
        this.EmployeeName = EmployeeName;
        this.BirthDay = BirthDay;
        this.EmployeePhone = EmployeePhone;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeePicture = EmployeePicture;
        this.EmployeeGender = EmployeeGender;
        this.roleID = roleID;
        this.category = category;
        this.Password = Password;
        this.Status = Status;
        this.confirm = confirm;
    }

    public Employee(int EmployeeID, String EmployeeName, Date BirthDay, String EmployeePhone,
            String EmployeeAddress, String EmployeePicture, boolean EmployeeGender, Category category) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.BirthDay = BirthDay;
        this.EmployeePhone = EmployeePhone;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeePicture = EmployeePicture;
        this.EmployeeGender = EmployeeGender;
        this.category = category;
    }

    public Employee(int EmployeeID, String EmployeeName, Date BirthDay,
            String EmployeePhone, String EmployeeAddress, String EmployeePicture,
            boolean EmployeeGender, Category category, int Status) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.BirthDay = BirthDay;
        this.EmployeePhone = EmployeePhone;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeePicture = EmployeePicture;
        this.EmployeeGender = EmployeeGender;
        this.category = category;
        this.Status = Status;
    }
    
     public Employee(int EmployeeID, String EmployeeName, Date BirthDay,
            String EmployeePhone, String EmployeeAddress, String EmployeePicture,
            boolean EmployeeGender, Category category, int Status, OrderDetail orderDetail) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.BirthDay = BirthDay;
        this.EmployeePhone = EmployeePhone;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeePicture = EmployeePicture;
        this.EmployeeGender = EmployeeGender;
        this.category = category;
        this.Status = Status;
        this.OrderDetail = OrderDetail;
    }

    public Employee(int EmployeeID, String EmployeeName, Date BirthDay, String EmployeePhone,
            String EmployeeAddress, String EmployeePicture, boolean EmployeeGender,
            String roleID, Category category, String Password, int Status) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.BirthDay = BirthDay;
        this.EmployeePhone = EmployeePhone;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeePicture = EmployeePicture;
        this.EmployeeGender = EmployeeGender;
        this.roleID = roleID;
        this.category = category;
        this.Password = Password;
        this.Status = Status;
    }

    public Employee(int _EmployeeID, String _EmployeeName, java.sql.Date _BirthDay, String _EmployeePhone, String _EmployeeAddress, 
            String _EmployeePicture, boolean _EmployeeGender, Role _RoleIDEmp, Category category, String _Password, int _Status) {
       this.EmployeeID = _EmployeeID;
        this.EmployeeName = _EmployeeName;
        this.BirthDay = _BirthDay;
        this.EmployeePhone = _EmployeePhone;
        this.EmployeeAddress = _EmployeeAddress;
        this.EmployeePicture = _EmployeePicture;
        this.EmployeeGender = _EmployeeGender;
        this.role = _RoleIDEmp;
        this.category = category;
        this.Password = _Password;
        this.Status = _Status;
    }

    //getEmployeeWorkDate 
    public Employee(int EmployeeID, String EmployeeName, Date BirthDay, String EmployeePhone, 
            String EmployeeAddress, boolean EmployeeGender, Category category, int Status, Status StatusObject) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.BirthDay = BirthDay;
        this.EmployeePhone = EmployeePhone;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeeGender = EmployeeGender;
        this.category = category;
        this.Status = Status;
        this.StatusObject = StatusObject;
    }

    //10 property - getEmployeeJob
    public Employee(int EmployeeID, String EmployeeName, Date BirthDay, String EmployeePhone, 
            String EmployeeAddress, String EmployeePicture, boolean EmployeeGender, int Status, 
            OrderDetail OrderDetail, Status StatusObject) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
        this.BirthDay = BirthDay;
        this.EmployeePhone = EmployeePhone;
        this.EmployeeAddress = EmployeeAddress;
        this.EmployeePicture = EmployeePicture;
        this.EmployeeGender = EmployeeGender;
        this.Status = Status;
        this.OrderDetail =  OrderDetail;
        this.StatusObject = StatusObject;
    }

    public Employee(int EmployeeID, String EmployeeName) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
    }

    

    public boolean isEmployeeGender() {
        return EmployeeGender;
    }

    public void setEmployeeGender(boolean EmployeeGender) {
        this.EmployeeGender = EmployeeGender;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date BirthDay) {
        this.BirthDay = BirthDay;
    }

    public String getEmployeePhone() {
        return EmployeePhone;
    }

    public void setEmployeePhone(String EmployeePhone) {
        this.EmployeePhone = EmployeePhone;
    }

    public String getEmployeeAddress() {
        return EmployeeAddress;
    }

    public void setEmployeeAddress(String EmployeeAddress) {
        this.EmployeeAddress = EmployeeAddress;
    }

    public String getEmployeePicture() {
        return EmployeePicture;
    }

    public void setEmployeePicture(String EmployeePicture) {
        this.EmployeePicture = EmployeePicture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatusObject() {
        return StatusObject;
    }

    public void setStatusObject(Status StatusObject) {
        this.StatusObject = StatusObject;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public OrderDetail getOrderDetail() {
        return OrderDetail;
    }

    public void setOrderDetail(OrderDetail OrderDetail) {
        this.OrderDetail = OrderDetail;
    }
}
