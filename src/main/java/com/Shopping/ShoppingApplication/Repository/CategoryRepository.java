package com.Shopping.ShoppingApplication.Repository;

import com.Shopping.ShoppingApplication.Model.Entity.Category;
import com.Shopping.ShoppingApplication.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Optional<Category> findById(Long id);
}
