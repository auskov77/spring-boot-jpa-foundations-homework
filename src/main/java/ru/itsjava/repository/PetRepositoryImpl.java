package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class PetRepositoryImpl implements PetRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Pet> getByBreed(String breed) {
        return null;
    }

    @Override
    public Pet findById(long id) {
        return entityManager.find(Pet.class, id);
    }

    @Override
    public void insert(Pet pet) {
        if (pet.getId() == 0) {
            entityManager.persist(pet);
        } else {
            entityManager.merge(pet);
        }
    }

    @Override
    public void update(Pet pet) {
        entityManager.merge(pet);
    }

    @Override
    public void deleteById(long id) {
        Pet petById = entityManager.find(Pet.class, id);
        entityManager.remove(petById);
    }

    @Override
    public void save(Pet pet) {

    }

    @Override
    public void delete(Pet pet) {

    }

    @Override
    public List<Pet> findAll() {
        return null;
    }
}