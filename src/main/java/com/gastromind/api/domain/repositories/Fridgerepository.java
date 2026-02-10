package com.gastromind.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.gastromind.api.domain.models.Fridge;

public interface Fridgerepository {
    Fridge save(Fridge fridge);

    Optional<Fridge> findById(String id);

    void deleteById(String id);

    List<Fridge> findAll();
}
