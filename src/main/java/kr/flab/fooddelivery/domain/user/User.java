package kr.flab.fooddelivery.domain.user;

import kr.flab.fooddelivery.domain.Address;
import kr.flab.fooddelivery.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String userId;
    private String password;
    private String nickname;
    private String email;

    private String authenticationCode;

    @Embedded
    private Address address;
    private String phoneNumber;

    @Builder
    public User(
            String name,
            String userId,
            String password,
            String nickname,
            String email
    ) {
        // todo - validation

        this.name = name;
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    // 도메인 메서드...

}
