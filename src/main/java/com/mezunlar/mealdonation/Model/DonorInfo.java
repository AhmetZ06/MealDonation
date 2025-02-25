package com.mezunlar.mealdonation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "donor_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // If a donor provides a name or stays anonymous, you can store partial info
    private String name;
    private String email;

    // Mark true if donor wishes to remain anonymous
    private boolean anonymous;

    // Optional timestamps or other metadata
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
