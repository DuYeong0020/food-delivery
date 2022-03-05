package kr.flab.fooddelivery.domain.user;

import java.util.Optional;

public interface UserReader {
    User getByUserId(String userId);
    Optional<User> findByUserId(String userId);
}
