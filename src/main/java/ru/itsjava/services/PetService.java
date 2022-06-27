package ru.itsjava.services;

import ru.itsjava.domain.Pet;

public interface PetService {
    void changePet(String oldBreed, String updatedBreed);

    void printPet(String breed);

    void createPet(Pet pet);

    Pet getPetById(long id);

    void deletePetById(long id);
}
