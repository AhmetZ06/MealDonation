package com.mezunlar.mealdonation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "meals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The merchant (User with role=MERCHANT) offering this meal
    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private User merchant;

    @Column(nullable = false)
    private String mealName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double price;

    // Optional additional description
    private String description;
}
