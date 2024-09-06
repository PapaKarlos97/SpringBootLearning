package io.vladimirdev.catalogueservice.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Car {
    private String mark;
    private int yearOfProduction;
    private String model;
    private int cost;
}
