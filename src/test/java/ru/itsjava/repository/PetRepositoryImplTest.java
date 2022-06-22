package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@Import(PetRepositoryImpl.class)
public class PetRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

    @Test
    public void shouldHaveCorrectInsert(){
        var cow = new Pet(5L, "cow");
        petRepository.insert(cow);
        var actualPet = petRepository.findById(5L);

        Assertions.assertEquals(cow, actualPet);
    }

    @Test
    public void shouldHaveCorrectUpdate(){
        var pet = petRepository.findById(1L);
        pet.setBreed("cow");
        petRepository.update(pet);
        var actualPet = petRepository.findById(1L);

        Assertions.assertEquals("cow", actualPet.getBreed());
    }

    @Test
    public void shouldHaveCorrectDeleteById(){
        petRepository.deleteById(4L);
        var deletePet = petRepository.findById(4L);

        Assertions.assertNull(deletePet);
    }
}
