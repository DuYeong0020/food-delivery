package kr.flab.fooddelivery.domain.user;



public interface UserReader {
    User findByUserId(String userId);

    User findByEmail(String email);

    User findByNickname(String nickname);

    User findByPhoneNumber(String phoneNumber);
}
