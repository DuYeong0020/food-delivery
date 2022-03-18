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
        private final String nickname;
        private final String password;
        private final Address address;


        @Builder
        public RegisterUserRequest(
                String userId,
                String email,
                String nickname,
                String password,
                Address address
        ) {
            this.userId = userId;
            this.email = email;
            this.nickname = nickname;
            this.password = password;
            this.address = address;
        }

        public User toEntity(String password) {
            return User.builder()
                    .userId(this.userId)
                    .email(this.email)
                    .nickname(this.nickname)
                    .password(password)
                    .address(this.address)
                    .build();
        }
    }

    @Getter
    public static class ModifyUserRequest {
        private final String nickname;
        private final String currentPassword;
        private final String newPassword;
        private final String phoneNumber;

        @Builder
        public ModifyUserRequest(
                String nickname,
                String currentPassword,
                String newPassword,
                String phoneNumber
        ){
            this.nickname = nickname;
            this.currentPassword = currentPassword;
            this.newPassword = newPassword;
            this.phoneNumber = phoneNumber;
        }

        public User toEntity() {
            return null;
        }


    }


}
