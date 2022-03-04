package kr.flab.fooddelivery.domain.order;

import kr.flab.fooddelivery.domain.BaseEntity;
import kr.flab.fooddelivery.domain.item.shop.Shop;
import kr.flab.fooddelivery.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "orders")
@Getter
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 주문 시간
    @CreationTimestamp
    private ZonedDateTime orderedTime;

    // 주문 상태
    private Status orderStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        INIT("주문 시도"),
        PAYMENT_COMPLETE("결제 완료"),
        ORDER_COMPLETE("주문 접수 완료"),
        IN_DELIVERY("배송 중"),
        DELIVERY_COMPLETE("배송 완료"),
        ORDER_CANCEL("주문 접수 거절");

        private final String description;


    }


}
