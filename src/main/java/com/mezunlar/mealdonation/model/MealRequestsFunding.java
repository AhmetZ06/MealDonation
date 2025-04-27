package com.mezunlar.mealdonation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "meal_requests_funding")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealRequestsFunding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // References the meal request being funded
    @ManyToOne
    @JoinColumn(name = "meal_request_id", nullable = false)
    private MealRequests mealRequest;

    // References the donor_allocations row from which funding is drawn
    @ManyToOne
    @JoinColumn(name = "donor_allocation_id", nullable = false)
    private DonorAllocations donorAllocation;

    // How much of donorAllocation's currentBalance is applied here
    @Column(nullable = false)
    private Double fundedAmount;

    // When the funding was applied
    private LocalDateTime fundedDate;
}
