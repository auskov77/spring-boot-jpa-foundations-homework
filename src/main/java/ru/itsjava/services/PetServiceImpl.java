package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{
    private final PetRepository petRepository;

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
}
