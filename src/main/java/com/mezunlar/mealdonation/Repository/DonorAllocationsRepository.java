package com.mezunlar.mealdonation.Repository;

import com.mezunlar.mealdonation.Model.DonorAllocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorAllocationsRepository extends JpaRepository<DonorAllocations, Long> {
    // Additional queries if needed
}
