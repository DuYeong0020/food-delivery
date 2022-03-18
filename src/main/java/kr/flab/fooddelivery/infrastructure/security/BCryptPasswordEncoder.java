package kr.flab.fooddelivery.infrastructure.security;


import kr.flab.fooddelivery.domain.security.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
