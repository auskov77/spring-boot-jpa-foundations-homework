package ru.itsjava.services;

import ru.itsjava.domain.Pet;

import java.util.List;

public interface PetService {
    void changePet(String oldBreed, String updatedBreed);

    void printPet(String breed);

    void createPet(Pet pet);

    Pet getPetById(long id);

    void deletePet(Pet pet);

    List<Pet> getAllPets();

    void updatePet(Pet pet);
}
