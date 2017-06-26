package com.sylc.repo;

import com.sylc.model.KnowledgeArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KnowledgeArticleRepo extends JpaRepository<KnowledgeArticle, Integer> {

  List<KnowledgeArticle> findAllByOrderByIdxDesc();

  @Query(value = "SELECT * FROM knowledge_article order by idx desc limit 8" , nativeQuery = true)
  List<KnowledgeArticle> findAllByOrderByIdxDescLimit8();
}
