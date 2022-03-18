package kr.flab.fooddelivery.domain.user;

import kr.flab.fooddelivery.domain.Address;
import lombok.Getter;

@Getter
public class UserInfo {

    private final String userId;
    private final String email;
    private final String nickname;
    private final String password;
    private final Address address;

    public UserInfo(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.address = user.getAddress();
    }


}
