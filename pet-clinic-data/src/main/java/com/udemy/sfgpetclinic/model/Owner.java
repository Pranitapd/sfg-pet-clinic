package com.udemy.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}

