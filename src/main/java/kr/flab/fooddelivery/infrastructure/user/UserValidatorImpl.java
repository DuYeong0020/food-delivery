package kr.flab.fooddelivery.infrastructure.user;

import kr.flab.fooddelivery.domain.user.UserReader;
import kr.flab.fooddelivery.domain.user.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidatorImpl implements UserValidator {
    private final UserReader userReader;

    @Override
    public void checkDuplicateUserId(String userId) {
        var user = userReader.findByUserId(userId);
        if (user.isPresent()) throw new RuntimeException("이미 가입된 userId 입니다");
    }
}
