package com.udemy.sfgpetclinic.services;

import com.udemy.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
