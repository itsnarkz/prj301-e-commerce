package com.Shopping.ShoppingApplication.Repository;

import com.Shopping.ShoppingApplication.Model.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "select i from Item i join Category c on i.category = c where i.category.id = ?1")
    List<Item> getItemByCategory(Long id);

    @Query(value = "select i from Item i where i.name LIKE %?1%")
    List<Item> searchItemByName(String name);

    Item getItemById(Long id);
}
