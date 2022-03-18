package kr.flab.fooddelivery.infrastructure.user;

import kr.flab.fooddelivery.domain.user.User;
import kr.flab.fooddelivery.domain.user.UserStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserJpaStore implements UserStore {

    private final UserJpaRepository userJpaRepository;


    @Override
    public User storeUser(User user) {
        return userJpaRepository.save(user);
    }
}
