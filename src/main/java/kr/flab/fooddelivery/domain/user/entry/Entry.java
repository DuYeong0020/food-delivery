package kr.flab.fooddelivery.domain.user.entry;

import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사업자등록증
    @Column(nullable = false)
    private String businessLicense;

    // 사업자등록번호
    @Column(nullable = false)
    private String companyRegistrationNumber;

    // 대표자 성명
    @Column(nullable = false)
    private String name;

    // 사업장 소재지
    @Embedded
    @Column(nullable = false)
    private Address address;


    // 통장사본
    @Column(nullable = false)
    private String copyOfBankStatement;

    // 입점 상태
    @Column(nullable = false)
    private Status entryStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User user;


    @Getter
    @RequiredArgsConstructor
    public enum Status {
        INIT("신청"),
        COMPLETE("완료"),
        CANCEL("거절"),
        HOLD("보류");

        private final String description;
    }

    @Embeddable
    public class Address {
        private String city;
        private String street;
        private String zipcode;
    }

}
