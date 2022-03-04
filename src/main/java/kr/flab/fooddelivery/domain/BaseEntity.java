package kr.flab.fooddelivery.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    // 생성 시간
    @Column(name = "create_time")
    @CreationTimestamp
    private ZonedDateTime createdTime;

    // 수정 시간
    @Column(name = "update_time")
    @UpdateTimestamp
    private ZonedDateTime updatedTime;

    // 삭제 여부
    @Column(name = "")
    private Boolean deleteOrNot;

}
