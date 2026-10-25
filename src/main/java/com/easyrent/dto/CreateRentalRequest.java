package com.easyrent.dto;
import jakarta.validation.constraints.*; import java.time.LocalDate;
public record CreateRentalRequest(@NotNull Long itemId,@NotNull Long renterId,@NotNull LocalDate startDate,@Min(1) @Max(365) int days,@Size(max=1000) String message){}