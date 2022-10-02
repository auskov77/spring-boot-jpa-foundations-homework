package ru.itsjava.repository;

import ru.itsjava.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Optional<Pet> getByBreed(String breed);

    Pet findById(long id);

    void insert(Pet pet);

    void update(Pet pet);

    void deleteById(long id);

    void save(Pet pet);

    void delete(Pet pet);

    List<Pet> findAll();
}