package com.udemy.sfgpetclinic.repository;

import com.udemy.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName); //find by property name

    List<Owner> findAllByLastNameLike(String lastName);
}
