package com.nishant.Restaurant.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "food_items")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Size(max = 100, min = 10)
    private  String description;

    @NotNull
    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("items")
    private Order order;
}
