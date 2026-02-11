package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gastromind.api.domain.models.HouseHold;
import com.gastromind.api.domain.repositories.HouseHoldRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.HouseholdEntity;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.HouseHoldJpaRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers.HouseholdMapper;

@Component
public class HouseHoldAdapter implements HouseHoldRepository {

    @Autowired
    HouseHoldJpaRepository holdJpaRepository;

    @Autowired
    HouseholdMapper householdMapper;

    @Override
    public HouseHold save(HouseHold houseHold) {
        HouseholdEntity entity = householdMapper.toEntity(houseHold);
        return householdMapper.toDomain(holdJpaRepository.save(entity));
    }

    @Override
    public Optional<HouseHold> findById(String id) {
        return holdJpaRepository.findById(id).map(householdMapper::toDomain);
    }

    @Override
    public void deleteById(String id) {
        holdJpaRepository.deleteById(id);
    }

    @Override
    public List<HouseHold> findAll() {
        List<HouseholdEntity> houseHoldEntities = holdJpaRepository.findAll();
        return householdMapper.toDomainList(houseHoldEntities);
    }

}
