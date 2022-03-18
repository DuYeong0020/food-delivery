package kr.flab.fooddelivery.infrastructure.user;

import kr.flab.fooddelivery.domain.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.management.RuntimeMBeanException;

@Component
@RequiredArgsConstructor
public class UserValidatorImpl implements UserValidator {
    private final UserReader userReader;
    private final PasswordEncoder passwordEncoder;

    private void checkDuplicateUserId(String userId) {
        var user = userReader.findByUserId(userId);
        if (user != null) throw new RuntimeException("이미 가입된 userId 입니다");
    }


    private void checkDuplicateEmail(String email) {
        var user = userReader.findByEmail(email);
        if (user != null) throw new RuntimeException("이미 존재하는 email 입니다.");
    }


    private void checkDuplicateNickname(String nickname) {
        var user = userReader.findByNickname(nickname);
        if (user != null) throw new RuntimeException("이미 존재하는 nickname 입니다.");
    }

    private void checkDuplicatePhoneNumber(String phoneNumber) {
        var user = userReader.findByPhoneNumber(phoneNumber);
        if (user != null) throw new RuntimeException("이미 존재하는 phoneNumber 입니다");
    }

    private void checkMatchPhoneNumber(String phoneNumber) {
        var user = userReader.findByPhoneNumber(phoneNumber);
        if (user == null) throw new RuntimeMBeanException("phoneNumber로 유저를 찾을수 없습니다.")
    }

    private void checkMatchUserIdPassword(String userId, String password) {
        var user = userReader.findByUserIdPassword(userid, passwordEncoder.encode(password));
        if (user != null) throw new RuntimeException("password가 일치하지 않습니다");

    }


    @Override
    public void checkRegisterUser(UserCommand.RegisterUserRequest request) {
        checkDuplicateUserId(request.getUserId());
        checkDuplicateEmail(request.getEmail());
        checkDuplicateNickname(request.getNickname());
    }

    @Override
    public void checkModifyUser(UserCommand.ModifyUserRequest request) {
        checkDuplicateNickname(request.getNickname());
        checkDuplicatePhoneNumber(request.getPhoneNumber());
        // Todo 비밀번호로 유저 찾기
    }

    @Override
    public void checkFindUserId(UserCriteria.FindUserCriteria criteria) {
        checkMatchPhoneNumber(criteria.getPhoneNumber());
    }


}
