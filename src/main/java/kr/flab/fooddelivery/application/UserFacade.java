package kr.flab.fooddelivery.application;

import kr.flab.fooddelivery.domain.user.UserCommand;
import kr.flab.fooddelivery.domain.user.UserInfo;
import kr.flab.fooddelivery.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public UserInfo registerUser(UserCommand.RegisterUserRequest request) {
        var user = userService.registerUser(request);

        // 1. 도메인 로직 바깥으로 세어 나간다.
//        user.getUserId()

        // 2. ManyToOne.. lazy ...  lazyLoadingInitial Exception
        item.getItemOptionGroup().asdadasd
    }
}
