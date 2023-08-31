package com.example.schoolapi.Repository;


import com.example.schoolapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Integer> {

    @Query("select c from User c where c.username=?1 or c.email=?1")
    User findByUserNameOrEmail(String info);

    User findUserById(Integer id);


}
