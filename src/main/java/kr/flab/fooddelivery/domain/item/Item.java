package kr.flab.fooddelivery.domain.item;

import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.item.optiongroup.ItemOptionGroup;
import kr.flab.fooddelivery.domain.order.Order;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;



}
