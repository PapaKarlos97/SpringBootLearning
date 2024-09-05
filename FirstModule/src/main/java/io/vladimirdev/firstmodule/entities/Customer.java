package io.vladimirdev.firstmodule.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private String firstName;
    private List<OrderProducts> orders = new ArrayList<>();
    private int numberOfPhone;
    private String eMail;
}
