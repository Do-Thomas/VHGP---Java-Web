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
public class Category {
    private int CatID;
    private String CatName;
    private String CatStatus;
    private String CatPicture;

    public Category() {
    }

    public Category(int CatID, String CatName, String CatStatus, String CatPicture) {
        this.CatID = CatID;
        this.CatName = CatName;
        this.CatStatus = CatStatus;
        this.CatPicture = CatPicture;
    } 
    public String getCatPicture() {
        return CatPicture;
    }

    public void setCatPicture(String CatPicture) {
        this.CatPicture = CatPicture;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int CatID) {
        this.CatID = CatID;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String CatName) {
        this.CatName = CatName;
    }

    public String getCatStatus() {
        return CatStatus;
    }

    public void setCatStatus(String CatStatus) {
        this.CatStatus = CatStatus;
    }
    
    
}
