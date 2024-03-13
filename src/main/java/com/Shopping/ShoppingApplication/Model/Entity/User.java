package com.Shopping.ShoppingApplication.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "`User`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String sex;

    @Column
    private String dob;

    @Column(columnDefinition = "nvarchar(255)")
    private String address;

    @Column
    private boolean admin;
}
