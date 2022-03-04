package kr.flab.fooddelivery.domain.user.entry;

import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table
public class Entry extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사업자등록증
    private String businessLicense;

    // 사업자등록번호
    private String companyRegistrationNumber;
    // 대표자 성명
    private String name;

    // 사업장 소재지
    @Embedded
    private Address address;


    // 통장사본
    private String copyOfBankStatement;

    // 입점 상태
    private Status entryStatus;


    @ManyToOne(fetch = FetchType.LAZY)
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
