package com.sylc.repo;

import com.sylc.model.KnowledgeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnowledgeCommentRepo extends JpaRepository<KnowledgeComment, Integer> {
  List<KnowledgeComment> findAllByArticleIdxOrderByIdxDesc(int articleIdx);
}
