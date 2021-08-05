package com.udemy.sfgpetclinic.bootstrap;

import com.udemy.sfgpetclinic.model.Owner;
import com.udemy.sfgpetclinic.model.Pet;
import com.udemy.sfgpetclinic.model.PetType;
import com.udemy.sfgpetclinic.model.Vet;
import com.udemy.sfgpetclinic.services.OwnerService;
import com.udemy.sfgpetclinic.services.PetTypeService;
import com.udemy.sfgpetclinic.services.VetService;
import com.udemy.sfgpetclinic.services.map.OwnerServiceMap;
import com.udemy.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //@Autowired  optional
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        //ownerService = new OwnerServiceMap();
        //vetService = new VetServiceMap();
        //instead of hard coding like above Spring should take care of them
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        System.out.println("Loaded Owners........");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Pam");
        vet1.setLastName("Beasly");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Dwight");
        vet2.setLastName("Schrute");

        vetService.save(vet2);
    }
}
