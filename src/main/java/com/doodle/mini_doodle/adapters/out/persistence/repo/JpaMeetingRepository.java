package com.doodle.mini_doodle.adapters.out.persistence.repo;

import com.doodle.mini_doodle.adapters.out.persistence.entity.MeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaMeetingRepository extends JpaRepository<MeetingEntity, UUID> {
}
