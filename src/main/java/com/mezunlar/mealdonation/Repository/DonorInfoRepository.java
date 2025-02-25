package com.mezunlar.mealdonation.Repository;

import com.mezunlar.mealdonation.Model.DonorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorInfoRepository extends JpaRepository<DonorInfo, Long> {
    // Additional queries if needed
}
