package com.myapp.MyAppBackend.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cpritcha on 6/2/17.
 */

@SuppressWarnings("serial")
@Entity
@Table(name ="USER_ACCOUNT", schema="DEV01")
public class PUser implements Serializable {

    @Id
    @Column(name = "USER_NAME")
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
    public String getUserName() {
        return this.userName;
    }

    public String getGender() {
        return this.gender;
    }

    public String getPassword() {
        return this.password;
    }

}
