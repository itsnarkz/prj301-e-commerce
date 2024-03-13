package com.Shopping.ShoppingApplication.Repository;

import com.Shopping.ShoppingApplication.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    public Optional<User> findById(Long id);
}
