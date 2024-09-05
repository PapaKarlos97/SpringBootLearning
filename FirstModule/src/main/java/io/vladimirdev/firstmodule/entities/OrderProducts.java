package io.vladimirdev.firstmodule.entities;

import lombok.Data;

@Data
public class OrderProducts {
    private String productId;
    private boolean paid;
    private boolean delivered;
}
