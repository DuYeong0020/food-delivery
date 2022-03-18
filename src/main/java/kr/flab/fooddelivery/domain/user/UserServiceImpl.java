package kr.flab.fooddelivery.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStore userStore;
    private final UserReader userReader;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder;


//    @Override
//    public String authenticationForRegisterStep(String phoneNumber) {
//        var authCode = user.generateAuthCode();
//
//        // generate randomString for authenticationCode
//        // phoneNumber SMS with authenticationCode
//    }

    @Override
    public UserInfo registerUser(UserCommand.RegisterUserRequest request) {
        userValidator.checkRegisterUser(request);
        var encodePassword = passwordEncoder.encode(request.getPassword());
        var initUser = request.toEntity(encodePassword);
        var user = userStore.storeUser(initUser);
        return new UserInfo(user);
    }

    @Override
    public UserInfo findUserId(UserCriteria.FindUserCriteria criteria) {
        userValidator.checkFindUserId(criteria);
        var user = userReader.findByPhoneNumber(criteria.getPhoneNumber());
        return new UserInfo(user);
    }

    @Override
    public UserInfo modifyPassword(UserCommand.ModifyPasswordRequest request) {
        return null;
    }


    @Override
    public UserInfo modifyUser(UserCommand.ModifyUserRequest request) {
        userValidator.checkModifyUser(request);
        // 유저를 가져와서
        var initUser = request.toEntity();
        // 변경할 부분만 바꾸기
        // 유저를 저장

        return null;

    }
}

