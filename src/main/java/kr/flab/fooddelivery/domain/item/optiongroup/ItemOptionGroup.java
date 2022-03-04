package kr.flab.fooddelivery.domain.item.optiongroup;

import kr.flab.fooddelivery.domain.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "item_option_group")
public class ItemOptionGroup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private Boolean defaultOption;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;



}
