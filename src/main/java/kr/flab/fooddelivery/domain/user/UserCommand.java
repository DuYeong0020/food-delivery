package kr.flab.fooddelivery.domain.user;

import kr.flab.fooddelivery.domain.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserCommand {

    @Getter
    @ToString
    public static class RegisterUserRequest {
        private final String userId;
        private final String email;
        private final String name;
        private final String password;
        private final Address address;

        @Builder
        public RegisterUserRequest(
                String userId,
                String email,
                String name,
                String password,
                Address address
        ) {
            this.userId = userId;
            this.email = email;
            this.name = name;
            this.password = password;
            this.address = address;
        }

        public User convert() {
            return User.builder()
                    .name(this.name)
                    .password(this.password)
                    .build();
        }
    }

    public static class ModifyUserRequest {

    }
}
