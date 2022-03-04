package kr.flab.fooddelivery.domain.order.item;

import javax.persistence.*;

@Entity
@Table(name = "order_item_options")
public class OrderItemOption {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이름
    private String name;

    // 가격
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderItemOptionGroup orderItemOptionGroup;
}
