package com.sylc.repo;

import com.sylc.model.ItemArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemArticleRepo extends JpaRepository<ItemArticle, Integer> {
}
