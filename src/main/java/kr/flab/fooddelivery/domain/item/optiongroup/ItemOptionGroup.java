package kr.flab.fooddelivery.domain.item.optiongroup;

import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "item_option_groups")
public class ItemOptionGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean hasDefaultOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
