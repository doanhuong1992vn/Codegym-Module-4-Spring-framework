package com.picture_of_day.repository;

import com.picture_of_day.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    @Query("select c FROM Comment c WHERE DATE(c.postTime) = CURRENT_DATE")
    Page<Comment> findByPostTimeInDay(Pageable pageable);
}
