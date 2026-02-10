package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gastromind.api.domain.models.Unit;
import com.gastromind.api.domain.repositories.UnitRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.UnitJpaRepository;

public class UnitAdapter implements UnitRepository {

    @Autowired
    UnitJpaRepository unitJpaRepository;

    @Override
    public Unit save(Unit unit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Unit> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Unit> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    
}
