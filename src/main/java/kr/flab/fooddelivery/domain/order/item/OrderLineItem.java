package kr.flab.fooddelivery.domain.order.item;

import kr.flab.fooddelivery.domain.item.Item;
import kr.flab.fooddelivery.domain.order.Order;

import javax.persistence.*;

@Entity
@Table(name = "order_line_item")
public class OrderLineItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long quantity; // 수량

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;


    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

}
