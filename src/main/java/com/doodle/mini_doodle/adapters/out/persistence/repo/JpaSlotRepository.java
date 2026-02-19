package com.doodle.mini_doodle.adapters.out.persistence.repo;

import com.doodle.mini_doodle.adapters.out.persistence.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface JpaSlotRepository extends JpaRepository<SlotEntity, UUID> {

  List<SlotEntity> findByOwnerIdAndStartTimeLessThanAndEndTimeGreaterThan(UUID ownerId, Instant to, Instant from);

  List<SlotEntity> findByOwnerIdAndStatusAndStartTimeLessThanAndEndTimeGreaterThan(UUID ownerId, String status, Instant to, Instant from);

  @Query("update SlotEntity s set s.status = 'BUSY', s.meetingId = :meetingId " +
      "where s.id = :id and s.status = 'FREE' and s.meetingId is null")
  int bookIfFree(@Param("id") UUID id, @Param("meetingId") UUID meetingId);
}
