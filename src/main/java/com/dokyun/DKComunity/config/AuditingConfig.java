package com.dokyun.DKComunity.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditingConfig {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false,length = 100,updatable = false)
    protected LocalDateTime createAte;

    @CreatedBy
    @Column
    protected String createBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    protected LocalDateTime modifiedAt;

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    protected String modifiedBy;

}
