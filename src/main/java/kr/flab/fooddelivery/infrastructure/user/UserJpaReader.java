package kr.flab.fooddelivery.infrastructure.user;

import kr.flab.fooddelivery.domain.user.User;
import kr.flab.fooddelivery.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserJpaReader implements UserReader {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User findByUserId(String userId) {
        return userJpaRepository.findByUserId(userId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByNickname(String nickname) {
        return userJpaRepository.findByNickname(nickname)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userJpaRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(EntityNotFoundException::new);
    }


}
