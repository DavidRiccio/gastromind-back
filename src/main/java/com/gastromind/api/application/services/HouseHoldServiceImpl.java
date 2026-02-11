package com.gastromind.api.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gastromind.api.domain.exceptions.NotFoundException;
import com.gastromind.api.domain.models.HouseHold;
import com.gastromind.api.domain.ports.in.IHouseHoldService;
import com.gastromind.api.domain.ports.out.HouseHoldRepository;

@Service
public class HouseHoldServiceImpl implements IHouseHoldService {

    private final HouseHoldRepository repository;


    public HouseHoldServiceImpl(HouseHoldRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HouseHold> findAll() {
        return repository.findAll();
    }

    @Override
    public HouseHold findById(String id) {
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Unidad Familiar no encontrada"));
    }

    @Override
    public HouseHold create(HouseHold houseHold) {
        return repository.save(houseHold);
    }

    @Override
    public HouseHold update(String id, HouseHold houseHold) {
        findById(id);
        houseHold.setId(id);
        return repository.save(houseHold);
    }

    @Override
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}