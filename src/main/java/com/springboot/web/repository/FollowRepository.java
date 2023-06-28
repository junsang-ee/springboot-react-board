package com.springboot.web.repository;

import com.springboot.web.model.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, String> {
}
