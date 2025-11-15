package com.connecthub.app.repositories;

import com.connecthub.app.models.TopicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicModel,Integer> {
}
