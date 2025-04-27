package com.mezunlar.mealdonation.model;

import com.mezunlar.mealdonation.enums.MealRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "meal_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_Id", nullable = false)
    private User user;

    // The meal being requested
    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meals meal;

    // Timestamp for when the request was created
    private LocalDateTime requestDate;

    // Current status of the request (PENDING, FUNDED, COMPLETED, etc.)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealRequestStatus status;

    // The total price of the meal (or you could get this from meal.price if needed)
    private Double totalPrice;

    // A unique code for the student to show at the restaurant
    private String code;

    // Expiration time for the code
    private LocalDateTime codeExpiry;

    // If the code has been used already
    private boolean usedFlag;
}
