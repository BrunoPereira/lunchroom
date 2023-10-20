package com.lunchroom.product.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Product {
    private long id;

    @NotBlank
    @Size(min = 0, max = 20)
    private String name;

    @NotBlank
    @Size(min = 0, max = 10)
    private String type;

    @NotBlank
    @Size(min = 0, max = 10)
    private int calories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

}
