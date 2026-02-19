package com.doodle.mini_doodle.domain.model;

import java.time.Instant;

public record TimeRange(Instant start, Instant end) {
  public TimeRange {
    if (start == null || end == null) throw new IllegalArgumentException("start/end must be provided");
    if (!start.isBefore(end)) throw new IllegalArgumentException("start must be before end");
  }

  public boolean overlaps(TimeRange other) {
    return this.start.isBefore(other.end) && this.end.isAfter(other.start);
  }

  public TimeRange intersect(TimeRange other) {
    var s = start.isAfter(other.start) ? start : other.start;
    var e = end.isBefore(other.end) ? end : other.end;
    return s.isBefore(e) ? new TimeRange(s, e) : null;
  }
}
