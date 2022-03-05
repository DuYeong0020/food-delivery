package kr.flab.fooddelivery.domain.order.item;

import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.item.Item;
import kr.flab.fooddelivery.domain.order.Order;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "order_line_item")
public class OrderLineItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity; // 수량

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

}
