package com.sylc.repository;

import com.sylc.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepo extends JpaRepository <Banner, Integer> {
}
