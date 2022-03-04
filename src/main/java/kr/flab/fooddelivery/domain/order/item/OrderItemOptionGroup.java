package kr.flab.fooddelivery.domain.order.item;

import kr.flab.fooddelivery.domain.item.optiongroup.ItemOptionGroup;

import javax.persistence.*;

@Entity
@Table(name = "order_item_option_groups")
public class OrderItemOptionGroup {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 이름

    // 기본 옵션 여부
    private Boolean defaultOption;

    // 베타 선택 여부
    private Boolean betaSelection;


    @ManyToOne(fetch = FetchType.LAZY)
    private OrderLineItem orderLineItem;




}