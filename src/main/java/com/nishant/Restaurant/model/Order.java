package com.nishant.Restaurant.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties("order")
    private List<FoodItem> items;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("orders")
    private User user;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
