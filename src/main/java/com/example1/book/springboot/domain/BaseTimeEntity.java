package com.example1.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 해당 클래스를 상속할 경우 필드들도 칼럼으로 인식하도록 한다
@EntityListeners(AuditingEntityListener.class) //Auditing 기능을 포함
public abstract class BaseTimeEntity {
    @CreatedDate //생성되어 저장될 떄 시간
    private LocalDateTime createdDate;
    @LastModifiedDate //값을 변경할 때 시간
    private LocalDateTime modifiedDate;
}
