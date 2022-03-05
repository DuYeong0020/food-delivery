package kr.flab.fooddelivery.infrastructure.user;

import kr.flab.fooddelivery.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);
}
