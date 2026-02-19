package com.doodle.mini_doodle.domain.model;

import java.util.Set;
import java.util.UUID;

public record Meeting(
        MeetingId id,
        User hostUserId,
        TimeRange range,
        String title,
        String description,
        Set<User> participantIds
) {
}
