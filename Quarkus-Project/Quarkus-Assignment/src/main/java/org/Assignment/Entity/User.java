package org.Assignment.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UserDetails")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String userEmail;
    private String userMobile;
    private String userCity;

    public User() {
    }

    public User(Long userId, String userName, String userEmail, String userMobile, String userCity) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userCity = userCity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }
}
