package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gastromind.api.domain.models.Fridge;
import com.gastromind.api.domain.repositories.Fridgerepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.FridgeJpaRepository;

public class FridgeAdapter  implements Fridgerepository{

    @Autowired
    FridgeJpaRepository fridgeJpaRepository;

    @Override
    public Fridge save(Fridge fridge) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Fridge> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Fridge> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
