package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.CustomerRepository;
import ru.itsjava.repository.PetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public void changePet(String oldBreed, String updatedBreed) {
        Pet pet = petRepository.getByBreed(oldBreed).get();
        pet.setBreed(updatedBreed);
        petRepository.save(pet);
        System.out.println("Запись благополучно изменили!");
    }

    @Transactional(readOnly = true)
    @Override
    public void printPet(String breed) {
        Pet pet = petRepository.getByBreed(breed).get();
        System.out.println(pet);
    }

    @Transactional
    @Override
    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    @Transactional(readOnly = true)
    @Override
    public Pet getPetById(long id) {
        return petRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void deletePet(Pet pet) {
        customerRepository.deleteAllByPet(pet);
        petRepository.delete(pet);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Transactional
    @Override
    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }
}
