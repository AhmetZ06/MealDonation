package com.mezunlar.mealdonation.repository;

import com.mezunlar.mealdonation.model.DonorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorInfoRepository extends JpaRepository<DonorInfo, Long> {
    // Additional queries if needed
}
