package com.sylc.repo;

import com.sylc.model.KnowledgeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeArticleRepo extends JpaRepository<KnowledgeArticle, Integer> {
}
