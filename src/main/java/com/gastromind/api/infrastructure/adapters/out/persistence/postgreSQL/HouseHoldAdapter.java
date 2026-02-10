package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gastromind.api.domain.models.HouseHold;
import com.gastromind.api.domain.repositories.HouseHoldRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.HouseHoldJpaRepository;

public class HouseHoldAdapter implements HouseHoldRepository {

    @Autowired
    HouseHoldJpaRepository holdJpaRepository;

    @Override
    public HouseHold save(HouseHold houseHold) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<HouseHold> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<HouseHold> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
