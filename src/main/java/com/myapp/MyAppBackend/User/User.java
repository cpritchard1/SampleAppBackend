package com.myapp.MyAppBackend.User;

/**
 * Created by cpritcha on 9/5/17.
 */
public class User {

    private Integer userId;
    private String userName;
    private String gender;
    private String password;
    private Boolean setForDelete;

    public User() {
        // Empty constructor for Hibernate
    }

    public User(Integer userId, String userName, String gender, String password) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.password = password;
        this.setForDelete = false;
    }

    public Integer getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getGender() { return gender; }
    public String getPassword() { return password; }
    public Boolean getSetForDelete() { return setForDelete; }

    public boolean isNew() {
        if(this.userId == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
