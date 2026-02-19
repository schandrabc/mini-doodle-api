package com.doodle.mini_doodle.application.port.out;

import com.doodle.mini_doodle.domain.model.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface SlotPort {
    TimeSlot save(TimeSlot slot);

    Optional<TimeSlot> findById(Slot id);

    boolean existsOverlap(User ownerId, Instant start, Instant end, Slot excludeId);

    Optional<TimeSlot> findExactFreeSlot(User ownerId, Instant start, Instant end);

    /**
     * Atomically book a slot: only succeeds if slot is FREE and not already booked.
     */
    boolean bookIfFree(Slot slotId, MeetingId meetingId);

    List<TimeSlot> findOverlapping(User ownerId, Instant from, Instant to);

    List<TimeSlot> findOverlappingByStatus(User ownerId, Instant from, Instant to, SlotStatus status);

    void delete(Slot id);
}
