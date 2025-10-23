package com.connecthub.app.repositories;

import com.connecthub.app.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomModel, Integer> {
}
