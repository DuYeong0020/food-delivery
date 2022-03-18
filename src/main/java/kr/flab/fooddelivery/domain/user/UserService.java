package kr.flab.fooddelivery.domain.user;

public interface UserService {
    // String authenticationForRegisterStep(String phoneNumber);
    UserInfo registerUser(UserCommand.RegisterUserRequest request);
    UserInfo findUserId(UserCriteria.FindUserCriteria criteria);
    UserInfo modifyPassword(UserCommand.ModifyPasswordRequest request);
    UserInfo modifyUser(UserCommand.ModifyUserRequest request);

}
