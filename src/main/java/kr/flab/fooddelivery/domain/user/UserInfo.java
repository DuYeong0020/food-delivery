package kr.flab.fooddelivery.domain.user;

import lombok.Getter;

@Getter
public class UserInfo {
    private final String name;

    public UserInfo(User user) {
        this.name = user.getName();
    }
}
