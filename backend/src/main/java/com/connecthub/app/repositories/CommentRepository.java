package com.connecthub.app.repositories;

import com.connecthub.app.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel,Integer> {
}
