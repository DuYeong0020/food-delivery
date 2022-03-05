package kr.flab.fooddelivery.domain.user;

public interface UserValidator {
    void checkDuplicateUserId(String userId);
    void checkEmail(String email);
    void checkNickname(String nickname);
}
