package com.lunchroom.product.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CaloriesResponse {
    @NotBlank
    private long orderId;
    @NotBlank
    private int calories;
}
