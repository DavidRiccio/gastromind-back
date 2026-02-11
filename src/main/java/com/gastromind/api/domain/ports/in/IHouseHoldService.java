package com.gastromind.api.domain.ports.in;

import java.util.List;

import com.gastromind.api.domain.models.HouseHold;

public interface IHouseHoldService {
    List<HouseHold> findAll();
    HouseHold findById(String id);
    HouseHold create(HouseHold houseHold);
    HouseHold update(String id, HouseHold houseHold);
    void delete(String id);
}