package kr.flab.fooddelivery.domain.partner;

import kr.flab.fooddelivery.domain.Address;
import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
public class Partner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String businessLicense;
    private String companyRegistrationNumber;
    private String name;

    @Embedded
    private Address address;
    private String copyOfBankStatement;
    private Status entryStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
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
}
