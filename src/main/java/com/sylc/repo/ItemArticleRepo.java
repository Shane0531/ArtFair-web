package com.sylc.repo;

import com.sylc.model.ItemArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemArticleRepo extends JpaRepository<ItemArticle, Integer> {

  List<ItemArticle> findAllByOrderByIdxDesc();

  @Query(value = "SELECT * FROM item_article order by idx desc limit 8" , nativeQuery = true)
  List<ItemArticle> findAllByOrderByIdxDescLimit8();
}
