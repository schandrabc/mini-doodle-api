package com.doodle.mini_doodle.application.port.out;

import com.doodle.mini_doodle.domain.model.User;

import java.util.Optional;

public interface UserPort {
    record UserView(User id, String email, String displayName) {
    }

    User create(String email, String displayName);

    Optional<UserView> find(User id);

    boolean exists(User id);

    java.util.List<UserView> list();
}
