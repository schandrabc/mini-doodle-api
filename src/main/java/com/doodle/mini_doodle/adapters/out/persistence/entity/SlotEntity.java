package com.doodle.mini_doodle.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "slots", indexes = {
        @Index(name = "idx_slots_owner_start", columnList = "owner_id,start_time"),
        @Index(name = "idx_slots_owner_status", columnList = "owner_id,status"),
        @Index(name = "idx_slots_meeting", columnList = "meeting_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uk_slots_owner_exact", columnNames = {"owner_id", "start_time", "end_time"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlotEntity {

    @Id
    private UUID id;

    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;

    @Column(name = "start_time", nullable = false)
    private Instant startTime;

    @Column(name = "end_time", nullable = false)
    private Instant endTime;

    @Column(nullable = false)
    private String status; // FREE/BUSY

    @Column(name = "meeting_id")
    private UUID meetingId;
}
