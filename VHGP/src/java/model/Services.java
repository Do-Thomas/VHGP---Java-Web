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
public class Services {

    private int ServiceID;
    private String ServiceName;
    private String ServiceDetail;
    private int ServiceTime;
    private Double ServicePrice;
    private String ServicePicture;
    private Category CatName;
    private String Status;
    private Category CatID;
    private String ServiceStatus;
    public Services() {
    }

//TopService - hompage
    public Services(int ServiceID, String ServiceName, String ServiceDetail, String ServicePicture) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServiceDetail = ServiceDetail;
        this.ServicePicture = ServicePicture;
    }

    public Services(Category CatName, String ServiceName, int ServiceTime, double ServicePrice, String ServicePicture) {
        this.CatName = CatName;
        this.ServiceName = ServiceName;
        this.ServiceTime = ServiceTime;
        this.ServicePrice = ServicePrice;
        this.ServicePicture = ServicePicture;
    }

    //SearchByName - ServicesDAO
    public Services(int ServiceID, String ServiceName, int ServiceTime, Double ServicePrice, String ServicePicture) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServiceTime = ServiceTime;
        this.ServicePrice = ServicePrice;
        this.ServicePicture = ServicePicture;
    }

    //ListOfService - ServicesDAO
    public Services(int ServiceID, String ServiceName, String ServiceDetail, int ServiceTime, Double ServicePrice, String ServicePicture) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServiceDetail = ServiceDetail;
        this.ServiceTime = ServiceTime;
        this.ServicePrice = ServicePrice;
        this.ServicePicture = ServicePicture;
    }

    public Services(int ServiceID, String ServiceName, String ServiceDetail, int ServiceTime, Double ServicePrice, String ServicePicture, Category CatID) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServiceDetail = ServiceDetail;
        this.ServiceTime = ServiceTime;
        this.ServicePrice = ServicePrice;
        this.ServicePicture = ServicePicture;
        this.CatID = CatID;
    }

    public Services(int ServiceID, String ServiceName, String ServiceDetail, int ServiceTime, Double ServicePrice, String ServicePicture, String Status, Category CatID) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServiceDetail = ServiceDetail;
        this.ServiceTime = ServiceTime;
        this.ServicePrice = ServicePrice;
        this.ServicePicture = ServicePicture;
        this.Status = Status;
        this.CatID = CatID;
    }

    public Services(int ServiceID, String ServiceName, String ServiceDetail, int ServiceTime, double ServicePrice, String ServicePicture, Category CatID, String ServiceStatus) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServiceDetail = ServiceDetail;
        this.ServiceTime = ServiceTime;
        this.ServicePrice = ServicePrice;
        this.ServicePicture = ServicePicture;
        this.CatID = CatID;
        this.ServiceStatus = ServiceStatus;
    }

//    public Services(int _ServiceID, String _ServiceName, String _ServiceDetail, Double _ServiceTime, 
//            double _ServicePrice, String _ServicePicture, Category _CatID, String _ServiceStatus) {
//        this.ServiceID = ServiceID;
//        this.ServiceName = ServiceName;
//        this.ServiceDetail = ServiceDetail;
//        this.ServiceTime = ServiceTime;
//        this.ServicePrice = ServicePrice;
//        this.ServicePicture = ServicePicture;
//        this.CatID = CatID;
//        this.ServiceStatus = ServiceStatus;
//    }

    public int getServiceID() {
        return ServiceID;
    }

    public void setServiceID(int ServiceID) {
        this.ServiceID = ServiceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public String getServiceDetail() {
        return ServiceDetail;
    }

    public void setServiceDetail(String ServiceDetail) {
        this.ServiceDetail = ServiceDetail;
    }

    public int getServiceTime() {
        return ServiceTime;
    }

    public void setServiceTime(int ServiceTime) {
        this.ServiceTime = ServiceTime;
    }

    public Double getServicePrice() {
        return ServicePrice;
    }

    public void setServicePrice(Double ServicePrice) {
        this.ServicePrice = ServicePrice;
    }

    public String getServicePicture() {
        return ServicePicture;
    }

    public void setServicePicture(String ServicePicture) {
        this.ServicePicture = ServicePicture;
    }

    public Category getCatID() {
        return CatID;
    }

    public void setCatID(Category CatID) {
        this.CatID = CatID;
    }

    public void setServiceID(String generatedID) {
        this.ServiceID = ServiceID;
    }

    public Category getCatName() {
        return CatName;
    }

    public void setCatName(Category CatName) {
        this.CatName = CatName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getServiceStatus() {
        return ServiceStatus;
    }

    public void setServiceStatus(String ServiceStatus) {
        this.ServiceStatus = ServiceStatus;
    }


}
