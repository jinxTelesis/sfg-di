package dre.corp.pets;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("cat")
public class CatPetService implements PetService{

    public String getPetType(){return "Cats Are the Best!";}
}
