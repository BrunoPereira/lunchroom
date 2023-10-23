package com.lunchroom.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaloriesRequest {
    @NotBlank
    private long orderId;
    @NotBlank
    private long[] productIds;
}
