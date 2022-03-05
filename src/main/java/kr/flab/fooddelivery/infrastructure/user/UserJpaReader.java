package kr.flab.fooddelivery.infrastructure.user;

import kr.flab.fooddelivery.domain.user.User;
import kr.flab.fooddelivery.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserJpaReader implements UserReader {
    private final UserJpaRepository userJpaRepository;

    @Override
    public User getByUserId(String userId) {
        return null;
    }
}
