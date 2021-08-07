package com.udemy.sfgpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        //hibernate recommends to use box Long instead of long

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
