package kr.flab.fooddelivery.domain.user;

import kr.flab.fooddelivery.domain.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id; // PK

    @Column(nullable = false)
    private String name; // 유저 이름

    @Column(nullable = false)
    private String userId; // 유저 아이디

    @Column(nullable = false)
    private String password; // 유저 비밀번호

    @Column(length = 8, nullable = false)
    private String nickname; // 유저 닉네임

    private Position position; // 유저 포지션

    @Column(nullable = false)
    private String email; // 유저 이메일

    @Embedded
    private Address address; // 주소

    private String phoneNumber; // 핸드폰 번호



    @Getter
    @RequiredArgsConstructor
    public enum Position {
        USER("유저"),
        PARTNER("파트너"),
        MANAGER("관리자");

        private final String description;
    }


    @Embeddable
    public class Address {
        private String city;
        private String street;
        private String zipcode;
    }


}
