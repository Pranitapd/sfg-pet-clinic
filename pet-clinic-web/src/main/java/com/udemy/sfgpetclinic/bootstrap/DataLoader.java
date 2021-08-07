package com.udemy.sfgpetclinic.bootstrap;

import com.udemy.sfgpetclinic.model.*;
import com.udemy.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    //@Autowired  optional
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService){
        //ownerService = new OwnerServiceMap();
        //vetService = new VetServiceMap();
        //instead of hard coding like above Spring should take care of them
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0)
            extracted();
    }

    private void extracted() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.getDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.getDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.getDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Scott");
        owner1.setAddress("asd");
        owner1.setCity("Maha");
        owner1.setTelephone("12232");

        Pet Mikespet = new Pet();
        Mikespet.setPetType(savedDogPetType);
        Mikespet.setName("Chedder");
        Mikespet.setOwner(owner1);
        Mikespet.setBirthDate(LocalDate.now());

        owner1.getPets().add(Mikespet);     //hashmap add
        ownerService.save(owner1);



        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jim");
        owner2.setLastName("Halpert");
        owner2.setAddress("Halpert town");
        owner2.setCity("NY");
        owner2.setTelephone("12334345");

        Pet Jimscat = new Pet();
        Jimscat.setPetType(savedCatPetType);
        Jimscat.setName("Whiskers");
        Jimscat.setOwner(owner2);
        Jimscat.setBirthDate(LocalDate.now());

        owner2.getPets().add(Jimscat);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(Jimscat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("Loaded Owners........");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Pam");
        vet1.setLastName("Beasly");
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Dwight");
        vet2.setLastName("Schrute");
        vet2.getSpecialities().add(surgery);

        vetService.save(vet2);
    }
}
