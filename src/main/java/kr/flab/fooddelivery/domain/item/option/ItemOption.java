package kr.flab.fooddelivery.domain.item.option;

import kr.flab.fooddelivery.domain.item.optiongroup.ItemOptionGroup;

import javax.persistence.*;

@Entity
@Table(name = "items_options")
public class ItemOption {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemOptionGroup itemOptionGroup;

}
