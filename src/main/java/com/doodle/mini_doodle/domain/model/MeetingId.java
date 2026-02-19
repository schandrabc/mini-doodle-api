package com.doodle.mini_doodle.domain.model;

import java.util.UUID;

public record MeetingId(UUID value) {
  public static MeetingId of(UUID v) { return new MeetingId(v); }
}
