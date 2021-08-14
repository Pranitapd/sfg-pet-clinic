package com.udemy.sfgpetclinic.sevices.map;

import com.udemy.sfgpetclinic.model.Owner;
import com.udemy.sfgpetclinic.services.map.OwnerServiceMap;
import com.udemy.sfgpetclinic.services.map.PetServiceMap;
import com.udemy.sfgpetclinic.services.map.PetTypeServiceMap;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Builder
class OwnerServiceMapTest {

    //OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        //doing dependency injection-- what spring basically does
       // ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        //ownerServiceMap.save(Owner.builder().);   //adding one owner obj into test
    }

    @Test
    void findAll() {
        //Set<Owner> ownerSet = ownerServiceMap.findAll();
       // assertEquals(0, ownerSet.size());
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByLastName() {
    }
}