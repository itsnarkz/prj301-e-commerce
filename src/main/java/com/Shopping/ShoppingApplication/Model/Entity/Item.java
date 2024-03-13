package com.Shopping.ShoppingApplication.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "`Item`")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    @Column(columnDefinition = "nvarchar(255)")
    private String description;

    @Column
    private String photo;

    @Column
    private int price;

    @Column(columnDefinition = "nvarchar(255)")
    private String seller;

    @ManyToOne
    @JoinColumn(name = "`category_id`")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;
}
