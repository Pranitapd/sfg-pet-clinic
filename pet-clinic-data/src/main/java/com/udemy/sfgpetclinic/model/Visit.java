package com.udemy.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade =  CascadeType.ALL)     //inverse of what added in pet
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
