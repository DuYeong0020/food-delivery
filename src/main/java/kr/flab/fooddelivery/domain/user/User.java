package kr.flab.fooddelivery.domain.user;

import kr.flab.fooddelivery.domain.Address;
import kr.flab.fooddelivery.domain.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String userId;
    private String password;
    private String nickname;
    private Position position;
    private String email;

    @Embedded
    private Address address;
    private String phoneNumber;

    @Getter
    @RequiredArgsConstructor
    public enum Position {
        USER("유저"),
        PARTNER("파트너"),
        MANAGER("관리자");

        private final String description;
    }
}
