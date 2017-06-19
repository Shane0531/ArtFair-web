package com.sylc.repo;

import com.sylc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Integer> {

  User findOneByStudentNumber(int studentNumber);

  @Query("SELECT u FROM User u WHERE u.id = :userid AND u.passwd = :passwd")
  User selectLogin(@Param("userid") String userid, @Param("passwd") String passwd);
}
