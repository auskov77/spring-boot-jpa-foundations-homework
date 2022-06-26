package ru.itsjava.services;

public interface PetService {
    void changePet(String oldBreed, String updatedBreed);
    void printPet(String breed);
}
