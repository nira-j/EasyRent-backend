package com.easyrent.dto;
import com.easyrent.model.RentalItem;
public record ItemResponse(Long id,String name,Long categoryId,String category,double pricePerDay,boolean available,String location,String description,String imageUrl,Long ownerId,String ownerName,double rating,int reviewCount){
 public static ItemResponse from(RentalItem x){return new ItemResponse(x.getId(),x.getName(),x.getCategory().getId(),x.getCategory().getName(),x.getPricePerDay(),x.isAvailable(),x.getLocation(),x.getDescription(),x.getImageUrl(),x.getOwner().getId(),x.getOwner().getName(),x.getRating(),x.getReviewCount());}
}