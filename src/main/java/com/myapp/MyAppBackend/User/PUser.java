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
    public void setUserName(String userName) { this.userName = userName; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPassword(String password) { this.password = password; }

}
