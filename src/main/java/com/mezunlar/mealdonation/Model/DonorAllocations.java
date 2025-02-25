package com.mezunlar.mealdonation.Model;

import com.mezunlar.mealdonation.enums.AllocationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "donor_allocations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonorAllocations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to donor_info table instead of User
    @ManyToOne
    @JoinColumn(name = "donor_info_id", nullable = false)
    private DonorInfo donorInfo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AllocationType allocationType;

    // Could reference student_id if STUDENT, or a category string (if needed)
    private Long targetId;

    // Original donation amount
    @Column(nullable = false)
    private Double allocatedAmount;

    // Remaining balance after partial funding
    @Column(nullable = false)
    private Double currentBalance;

    // Optional timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
