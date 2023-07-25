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
public class Reviews {
    private int ReviewID;
    private String ReviewTitle;
    private Date ReviewDate;
    private int ReviewRating;
    private String Comment;
    private String ReviewPicture;
    
    private Services Service;
    private Customer Customer;

    public Reviews(String ReviewTitle, Date ReviewDate, int ReviewRating, String Comment, String ReviewPicture, Services Service, Customer Customer) {
        this.ReviewTitle = ReviewTitle;
        this.ReviewDate = ReviewDate;
        this.ReviewRating = ReviewRating;
        this.Comment = Comment;
        this.ReviewPicture = ReviewPicture;
        this.Service = Service;
        this.Customer = Customer;
    }

    public Reviews(int ReviewID, String ReviewTitle, Date ReviewDate, int ReviewRating, String Comment, String ReviewPicture, Services Service, Customer Customer) {
        this.ReviewID = ReviewID;
        this.ReviewTitle = ReviewTitle;
        this.ReviewDate = ReviewDate;
        this.ReviewRating = ReviewRating;
        this.Comment = Comment;
        this.ReviewPicture = ReviewPicture;
        this.Service = Service;
        this.Customer = Customer;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public int getReviewID() {
        return ReviewID;
    }

    public void setReviewID(int ReviewID) {
        this.ReviewID = ReviewID;
    }

    public String getReviewTitle() {
        return ReviewTitle;
    }

    public void setReviewTitle(String ReviewTitle) {
        this.ReviewTitle = ReviewTitle;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date ReviewDate) {
        this.ReviewDate = ReviewDate;
    }

    public int getReviewRating() {
        return ReviewRating;
    }

    public void setReviewRating(int ReviewRating) {
        this.ReviewRating = ReviewRating;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getReviewPicture() {
        return ReviewPicture;
    }

    public void setReviewPicture(String ReviewPicture) {
        this.ReviewPicture = ReviewPicture;
    }

    public Services getService() {
        return Service;
    }

    public void setService(Services Service) {
        this.Service = Service;
    }
    
}
