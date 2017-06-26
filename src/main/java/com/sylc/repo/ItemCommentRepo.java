package com.sylc.repo;

import com.sylc.model.ItemComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCommentRepo extends JpaRepository<ItemComment, Integer> {
  List<ItemComment> findAllByArticleIdxOrderByIdxDesc(int articleIdx);
}
