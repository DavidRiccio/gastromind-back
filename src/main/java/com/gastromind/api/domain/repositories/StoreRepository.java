package com.gastromind.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.gastromind.api.domain.models.Store;

public interface StoreRepository {
    Store save(Store store);

    Optional<Store> findById(String id);

    void deleteById(String id);

    List<Store> findAll();
}
