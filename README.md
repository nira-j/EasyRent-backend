# EasyRent Backend

Spring Boot 3.4 + Java 17 + PostgreSQL REST API.

## Start PostgreSQL
docker compose up -d

Database: easyrent
Username: postgres
Password: postgres
Port: 5432

## Start API
mvn spring-boot:run

API base: http://localhost:8080/api

## Endpoints
GET /api/categories
GET /api/items
GET /api/items?q=camera
GET /api/items?category=electronics
GET /api/items/{id}
POST /api/items
POST /api/rentals
GET /api/rentals/renter/{renterId}
GET /api/users
GET /api/users/{id}

Example POST /api/rentals:
{"itemId":1,"renterId":2,"startDate":"2026-10-01","days":3,"message":"I will pick it up in the afternoon."}

The starter backend uses Hibernate ddl-auto=update. Authentication, payments, image storage, owner approval, reviews, and date-overlap checking can be added next.
