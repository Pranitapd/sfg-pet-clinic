package com.udemy.sfgpetclinic.services.map;

import com.udemy.sfgpetclinic.model.Visit;
import com.udemy.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null  || visit.getPet().getId() == null
        || visit.getPet().getOwner() == null)
            throw new RuntimeException("Invalid Visit");
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
