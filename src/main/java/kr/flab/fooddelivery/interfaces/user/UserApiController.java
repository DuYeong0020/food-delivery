package kr.flab.fooddelivery.interfaces.user;

import kr.flab.fooddelivery.common.response.CommonResponse;
import kr.flab.fooddelivery.domain.user.UserCommand;
import kr.flab.fooddelivery.domain.user.UserInfo;
import kr.flab.fooddelivery.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping
    public CommonResponse registerUser(@RequestBody @Valid UserDto.RegisterRequest request) {
        var command = request.toCommand();
        var userInfo = userService.registerUser(command);
        var response = new UserDto.RegisterResponse(userInfo);
        return CommonResponse.success(response);

    }
}
