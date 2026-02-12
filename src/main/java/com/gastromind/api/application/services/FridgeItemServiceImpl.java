package com.gastromind.api.application.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gastromind.api.domain.exceptions.NotFoundException;
import com.gastromind.api.domain.models.FridgeItem;
import com.gastromind.api.domain.ports.in.IFridgeItemService;
import com.gastromind.api.domain.ports.out.FridgeItemRepository;

@Service
public class FridgeItemServiceImpl implements IFridgeItemService {

    private final FridgeItemRepository repository;

    public FridgeItemServiceImpl(FridgeItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FridgeItem> findAll() {
        return repository.findAll();
    }

    @Override
    public FridgeItem findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item de nevera no encontrado"));
    }

    @Override
    public List<FridgeItem> findByFridgeId(String fridgeId) {
        return repository.findByFridgeId(fridgeId);
    }

    @Override
    @Transactional
    public FridgeItem create(FridgeItem fridgeItem) {
        return repository.save(fridgeItem);
    }

    @Override
    @Transactional
    public FridgeItem update(String id, FridgeItem fridgeItem) {
        this.findById(id);
        fridgeItem.setId(id);
        return repository.save(fridgeItem);
    }

    @Override
    @Transactional
    public void delete(String id) {
        this.findById(id);
        repository.deleteById(id);
    }
}