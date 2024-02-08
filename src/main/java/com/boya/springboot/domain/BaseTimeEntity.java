package com.boya.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA entity 클래스들이 BaseTimeEntity 상속할 경우 필드들도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능 포함
public abstract class BaseTimeEntity { //모든 Entity의 상위 클래스가 되어 Entity들의 reatedDate, LastModifiedDate을 자동으로 관리

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
