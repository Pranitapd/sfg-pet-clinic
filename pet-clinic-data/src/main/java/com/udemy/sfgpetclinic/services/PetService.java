package com.udemy.sfgpetclinic.services;

import com.udemy.sfgpetclinic.model.Owner;
import com.udemy.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
