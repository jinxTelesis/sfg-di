package dre.corp.pets;

import org.springframework.stereotype.Service;

@Service
public class PetServiceFactory {

    public PetService getPetService(String type){
        switch(type){
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();

        }
    }

}
