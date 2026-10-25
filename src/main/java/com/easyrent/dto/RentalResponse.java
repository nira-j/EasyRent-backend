package com.easyrent.dto;
import com.easyrent.model.*; import java.time.LocalDate;
public record RentalResponse(Long id,Long itemId,String itemName,Long renterId,String renterName,LocalDate startDate,int days,double totalAmount,RentalStatus status,String message){
 public static RentalResponse from(Rental r){return new RentalResponse(r.getId(),r.getItem().getId(),r.getItem().getName(),r.getRenter().getId(),r.getRenter().getFullName(),r.getStartDate(),r.getDays(),r.getTotalAmount(),r.getStatus(),r.getMessage());}
}