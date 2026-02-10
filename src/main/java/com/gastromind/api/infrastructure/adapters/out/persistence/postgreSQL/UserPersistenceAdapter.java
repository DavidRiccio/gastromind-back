package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import com.gastromind.api.domain.models.User;
import com.gastromind.api.domain.repositories.UserRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.UserJpaRepository;

public class UserPersistenceAdapter implements UserRepository{

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<User> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
