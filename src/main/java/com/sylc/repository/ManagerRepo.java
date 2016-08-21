package com.sylc.repository;

import com.sylc.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository <Manager, Integer> {
}
