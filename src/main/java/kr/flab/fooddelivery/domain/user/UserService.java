package kr.flab.fooddelivery.domain.user;

public interface UserService {
    String authenticationForRegisterStep(String phoneNumber);
    UserInfo registerUser(UserCommand.RegisterUserRequest request);
    UserInfo modifyUser(UserCommand.ModifyUserRequest request);
    UserInfo findUserId(UserCriteria.FindUser criteria);
}
