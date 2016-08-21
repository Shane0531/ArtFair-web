package com.sylc.repository;

import com.sylc.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository <Event, Integer> {

}
