package com.udemy.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
 @Entity
 @Table(name = "owners")
public class Owner extends Person{

     @Column(name = "address")
     private String address;

     @Column(name = "city")
     private String city;

     @Column(name = "Telephone")
     private String Telephone;

     @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
     private Set<Pet> pets = new HashSet<>();        //to avoid nullpointer exception when we call get

}

