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
public class Admin {
    private String UsernameAdmin;
    private String PassAdmin;
    private String MailAdmin;
    private Role RoleID;

    public Admin() {
    }

    public Admin(String UsernameAdmin, String PassAdmin, String MailAdmin, Role RoleID) {
        this.UsernameAdmin = UsernameAdmin;
        this.PassAdmin = PassAdmin;
        this.MailAdmin = MailAdmin;
        this.RoleID = RoleID;
    }

    public Role getRoleID() {
        return RoleID;
    }

    public void setRoleID(Role RoleID) {
        this.RoleID = RoleID;
    }

    public String getUsernameAdmin() {
        return UsernameAdmin;
    }

    public void setUsernameAdmin(String UsernameAdmin) {
        this.UsernameAdmin = UsernameAdmin;
    }

    public String getPassAdmin() {
        return PassAdmin;
    }

    public void setPassAdmin(String PassAdmin) {
        this.PassAdmin = PassAdmin;
    }

    public String getMailAdmin() {
        return MailAdmin;
    }

    public void setMailAdmin(String MailAdmin) {
        this.MailAdmin = MailAdmin;
    }
    
}
