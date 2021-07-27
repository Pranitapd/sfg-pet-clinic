package com.udemy.sfgpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id;        //hibernate recommends to use box Long instead of long

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
