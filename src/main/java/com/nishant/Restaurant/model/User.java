package com.nishant.Restaurant.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Pattern(regexp = "^.+@.+\\.com")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$")
    private String password;

    @NotBlank
    private String userName;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Order> orders;

}
