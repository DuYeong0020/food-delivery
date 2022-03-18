package kr.flab.fooddelivery.domain.user;

public interface UserValidator {

    void checkRegisterUser(UserCommand.RegisterUserRequest request);

    void checkModifyUser(UserCommand.ModifyUserRequest request);

    void checkFindUserId(UserCriteria.FindUserCriteria criteria);
}
