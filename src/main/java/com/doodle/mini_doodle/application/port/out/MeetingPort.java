package com.doodle.mini_doodle.application.port.out;


import com.doodle.mini_doodle.domain.model.Meeting;
import com.doodle.mini_doodle.domain.model.MeetingId;

import java.util.Optional;

public interface MeetingPort {
  Meeting save(Meeting meeting);
  Optional<Meeting> find(MeetingId id);
}
