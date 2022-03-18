package kr.flab.fooddelivery.interfaces.user;

import kr.flab.fooddelivery.domain.Address;
import kr.flab.fooddelivery.domain.user.UserCommand;
import kr.flab.fooddelivery.domain.user.UserInfo;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.*;

public class UserDto {

    @Getter
    @ToString
    public static class RegisterRequest {

        @NotEmpty(message = "userId는 필수값입니다")
        private String userId;

        @NotEmpty(message = "email은 필수값입니다")
        @Email(message = "email 형식에 맞아야 합니다")
        private String email;

        @NotEmpty(message = "nickname은 필수값입니다")
        @Size(min = 2, max = 8, message = "nickname은 최소 2글자, 최대 8글자 입니다.")
        private String nickname;

        @NotEmpty(message = "password는 필수값입니다")
        @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$\n", message = "숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용")
        private String password;

        @NotEmpty(message = "address는 필수값입니다")
        private Address address;


        public UserCommand.RegisterUserRequest toCommand() {
            return UserCommand.RegisterUserRequest.builder()
                    .userId(userId)
                    .email(email)
                    .nickname(nickname)
                    .password(password)
                    .address(address)
                    .build();

        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final String userId;
        private final String email;
        private final String nickname;
        private final String password;
        private final Address address;

        public RegisterResponse(UserInfo userInfo) {
            this.userId = userInfo.getUserId();
            this.email = userInfo.getEmail();
            this.nickname = userInfo.getNickname();
            this.password = userInfo.getPassword();
            this.address = userInfo.getAddress();
        }
    }


    @Getter
    @ToString
    public static class ModifyRequest {
        @NotEmpty(message = "nickname은 필수값입니다")
        @Size(min = 2, max = 8, message = "nickname은 최소 2글자, 최대 8글자 입니다.")
        private String nickname;

        @NotEmpty(message = "currentPassword는 필수값입니다")
        @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$\n", message = "숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용")
        private String currentPassword;

        @NotEmpty(message = "newPassword는 필수값입니다")
        @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$\n", message = "숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용")
        private String newPassword;

        @NotEmpty(message = "phoneNumber는 필수값입니다")
        private String phoneNumber;
    }

    @Getter
    @ToString
    public static class ModifyResponse {
        private String userId;
        private String email;
        private String nickname;
        private String password;
        private Address address;
    }
}
