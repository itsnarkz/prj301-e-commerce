package com.Shopping.ShoppingApplication.Model;

import com.Shopping.ShoppingApplication.Model.DTO.ItemDTO;
import com.Shopping.ShoppingApplication.Model.Entity.Category;
import com.Shopping.ShoppingApplication.Model.Entity.Item;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCart {
    public ItemCart(ItemDTO i) {
        this.id = i.getId();
        this.name = i.getName();
        this.description = i.getDescription();
        this.photo = i.getPhoto();
        this.price = i.getPrice();
        this.seller = i.getSeller();
        this.category = i.getCategoryName();

        this.quantity = 1;
        this.total = this.price;
    }

    public ItemCart update(int num) {
        this.quantity = num;
        this.total = this.price * num;

        return this;
    }

    private Long id;
    private String name;
    private String description;
    private String photo;
    private int price;
    private String seller;
    private String category;

    private int quantity;
    private double total;
}
