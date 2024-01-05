package com.lambdacode.spring.boot.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @GeneratedValue
    private Long categoryId;
    
    private String categoryName;
    
    // Other fields...

    // Constructors, getters, setters...
}
