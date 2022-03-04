package kr.flab.fooddelivery.domain.order.item;

import kr.flab.fooddelivery.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "order_item_options")
public class OrderItemOption extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이름
    private String name;

    // 가격
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_option_group_id")
    private OrderItemOptionGroup orderItemOptionGroup;
}
