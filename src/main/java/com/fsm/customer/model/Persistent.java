package com.fsm.customer.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class Persistent implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Setter
    @CreationTimestamp
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTs;

    @Setter
    @UpdateTimestamp
    @Column(name = "UPDATED_TIMESTAMP")
    private LocalDateTime updatedTs;

    @Setter
    @Column(name = "CREATED_BY")
    private String createdBy ;

    @Setter
    @Column(name = "UPDATED_BY")
    private String updatedBy;


}
