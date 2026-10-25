package com.easyrent.dto;
import jakarta.validation.constraints.*;
public record CreateItemRequest(@NotBlank String name,@NotNull Long categoryId,@PositiveOrZero double pricePerDay,String location,@Size(max=4000) String description,String imageUrl,@NotNull Long ownerId){}