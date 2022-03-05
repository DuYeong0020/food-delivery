package kr.flab.fooddelivery.domain.shop;



import kr.flab.fooddelivery.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "shops")
public class Shop extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean isOpen;  // TODO - change enum Status
    private Long minOrderPrice;

    // 수수료 율
    // 수수료 누적액
}
