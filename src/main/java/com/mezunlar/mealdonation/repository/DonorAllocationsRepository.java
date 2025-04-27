package com.mezunlar.mealdonation.repository;

import com.mezunlar.mealdonation.model.DonorAllocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorAllocationsRepository extends JpaRepository<DonorAllocations, Long> {
    // Additional queries if needed
}
