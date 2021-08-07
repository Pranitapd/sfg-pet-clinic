package com.udemy.sfgpetclinic.repository;

import com.udemy.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

//Spring data JPA will provide instances of these at run time
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
