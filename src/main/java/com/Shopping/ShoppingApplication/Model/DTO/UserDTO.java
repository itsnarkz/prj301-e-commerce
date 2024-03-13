package com.Shopping.ShoppingApplication.Model.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String username;

    private String name;

    private String email;

    private String phone;

    private String sex;

    private String dob;

    private String address;

    private boolean admin;
}
