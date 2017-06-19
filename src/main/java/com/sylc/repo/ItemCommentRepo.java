package com.sylc.repo;

import com.sylc.model.ItemComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCommentRepo extends JpaRepository<ItemComment, Integer> {
}
