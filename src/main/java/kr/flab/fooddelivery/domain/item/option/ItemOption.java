package kr.flab.fooddelivery.domain.item.option;

import com.sun.istack.NotNull;
import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.item.optiongroup.ItemOptionGroup;

import javax.persistence.*;

@Entity
@Table(name = "items_options")
public class ItemOption extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_option_group_id")
    private ItemOptionGroup itemOptionGroup;

}
