package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gastromind.api.domain.models.UsualPurchase;
import com.gastromind.api.domain.repositories.UsualPurchaseRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.UsualPurchaseJpaRepository;

public class UsualPurchaseAdapter implements UsualPurchaseRepository {

    @Autowired
    UsualPurchaseJpaRepository usualPurchaseJpaRepository;

    @Override
    public UsualPurchase save(UsualPurchase usualPurchase) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<UsualPurchase> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<UsualPurchase> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
