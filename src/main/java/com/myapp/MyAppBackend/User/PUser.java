package com.myapp.MyAppBackend.User;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cpritcha on 6/2/17.
 */

@Entity
@Table(name ="USER_ACCOUNT", schema="DEV01")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PUser implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PASSWORD")
    private String password;


    public PUser() {
        // empty constructor for Hibernate
    }

    // CONSTRUCTOR FOR CREATING USER OBJECT
    public PUser( String userName, String gender, String password ) {
        this.userName = userName;
        this.gender = gender;
        this.password = password;
    }

    // GETTER FUNCTIONS FOR USER ATTRIBUTES
    public Integer getUserId() { return this.userId; }
    public String getUserName() {
        return this.userName;
    }
    public String getGender() {
        return this.gender;
    }
    public String getPassword() { return this.password; }

    // SETTER FUNCTIONS FOR USER ATTRIBUTERS
    public void setUserId(Integer userId) { this.userId = userId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPassword(String password) { this.password = password; }

    public PUser updateEntity(User domainObj) {
        this.setUserName(domainObj.getUserName());
        this.setGender(domainObj.getGender());
        this.setPassword(domainObj.getPassword());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PUser pUser = (PUser) o;

        if (!userId.equals(pUser.userId)) return false;
        if (!userName.equals(pUser.userName)) return false;
        if (!gender.equals(pUser.gender)) return false;
        return password.equals(pUser.password);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
