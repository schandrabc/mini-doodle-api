package com.doodle.mini_doodle.domain.model;

public record TimeSlot(
        Slot id,
        User ownerId,
        TimeRange range,
        SlotStatus status,
        MeetingId meetingId
) {
}
