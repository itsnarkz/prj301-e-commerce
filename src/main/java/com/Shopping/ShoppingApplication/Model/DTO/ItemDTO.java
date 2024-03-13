package com.Shopping.ShoppingApplication.Model.DTO;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long id;

    private String name;

    private String description;

    private String photo;

    private int price;

    private String seller;

    private String categoryName;
}
