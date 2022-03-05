package kr.flab.fooddelivery.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStore userStore;   // DIP  추상화 레벨이 낮은 것이.. 높은 것을 의존하게 하는 ...
    private final UserReader userReader;
    private final UserValidator userValidator;

    @Override
    public String authenticationForRegisterStep(String phoneNumber) {
        var authCode = user.generateAuthCode();

        // generate randomString for authenticationCode
        // phoneNumber SMS with authenticationCode
    }

    @Override
    public UserInfo registerUser(UserCommand.RegisterUserRequest request) {
        userValidator.checkDuplicateUserId(request.getUserId());
        userValidator.checkNickname();
        userValidator.checkEmail();

        var initUser = request.convert();
        var user = userStore.storeUser(initUser);
        return new UserInfo(user);
    }

    @Override
    public UserInfo modifyUser(UserCommand.ModifyUserRequest request) {
        return null;
    }

    @Override
    public UserInfo findUserId(UserCriteria.FindUser criteria) {
        return null;
    }
}
