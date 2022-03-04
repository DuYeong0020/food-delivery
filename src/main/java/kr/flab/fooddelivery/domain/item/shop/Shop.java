package kr.flab.fooddelivery.domain.item.shop;



import kr.flab.fooddelivery.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 가게 이름
    private String name;

    // 영업 여부
    private Boolean OpenOrNot;

    // 최소 주문 금액
    private Long minOrderPrice;
    // 수수료 율

    // 수수료 누적액
}
