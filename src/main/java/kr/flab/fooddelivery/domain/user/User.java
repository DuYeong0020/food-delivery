package kr.flab.fooddelivery.domain.user;

import kr.flab.fooddelivery.domain.Address;
import kr.flab.fooddelivery.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.security.InvalidParameterException;

@Entity
@NoArgsConstructor
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String userId;
    private String password;
    private String nickname;
    private String email;
    @Embedded
    private Address address;
    private String phoneNumber;

    @Builder
    public User(
            String userId,
            String password,
            String nickname,
            String email,
            Address address
    ) {
        if (!StringUtils.hasText(userId)) throw new InvalidParameterException();
        if (!StringUtils.hasText(password)) throw new InvalidParameterException();
        if (!StringUtils.hasText(nickname)) throw new InvalidParameterException();
        if (!StringUtils.hasText(email)) throw new InvalidParameterException();
        if (address == null) throw new InvalidParameterException();

        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.address = address;
        this.phoneNumber = null;

    }

}
