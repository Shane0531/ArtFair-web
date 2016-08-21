package com.sylc.repository;

import com.sylc.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepo extends JpaRepository <Manager, Integer> {

  @Query("SELECT m FROM Manager m WHERE m.id = :userid AND m.password = PASSWORD(SHA1(:passwd))")
  Manager selectLogin(@Param("userid") String userid, @Param("passwd") String passwd);

}
