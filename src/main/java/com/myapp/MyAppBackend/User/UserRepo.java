package com.myapp.MyAppBackend.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by cpritcha on 6/2/17.
 */

@Repository
public interface UserRepo extends JpaRepository<PUser, String> {

    @Query( value = "SELECT u FROM PUser u WHERE u.userName = :userName")
    PUser findUserByName(@Param("userName") String userName);

    @Query( value = "SELECT u FROM PUser u WHERE u.userId = :userId")
    PUser findUserById(@Param("userId") Integer userId);
}