package com.udemy.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class  Pet extends BaseEntity{
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits;


}
