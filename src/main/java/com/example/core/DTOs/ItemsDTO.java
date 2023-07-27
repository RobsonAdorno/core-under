package com.example.core.DTOs;

public class ItemsDTO {

    public String description;

    public int quantity;

    public ItemsDTO() {
    }

    public ItemsDTO(String description, int quantity) {
        this.description = description;
        this.quantity = quantity;
    }
}
