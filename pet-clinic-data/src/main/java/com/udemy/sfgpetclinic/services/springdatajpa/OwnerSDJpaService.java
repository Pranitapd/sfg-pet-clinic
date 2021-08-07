package com.udemy.sfgpetclinic.services.springdatajpa;

import com.udemy.sfgpetclinic.model.Owner;
import com.udemy.sfgpetclinic.repository.OwnerRepository;
import com.udemy.sfgpetclinic.services.OwnerService;
import com.udemy.sfgpetclinic.services.PetService;
import com.udemy.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetService petService, PetTypeService petTypeService) {
        this.ownerRepository = ownerRepository;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        //return ownerRepository.findById(aLong).get();     this will create an exception
        //Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        //return optionalOwner.orElse(null);
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    public void deleteById(Long aLong){
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
