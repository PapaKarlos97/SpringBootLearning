package io.vladimirdev.catalogueservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data
@NoArgsConstructor@AllArgsConstructor
public class Customer {
@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
@Embedded
private Car car;
}
