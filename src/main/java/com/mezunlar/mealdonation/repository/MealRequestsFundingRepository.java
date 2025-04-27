package com.mezunlar.mealdonation.repository;

import com.mezunlar.mealdonation.model.MealRequestsFunding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRequestsFundingRepository extends JpaRepository<MealRequestsFunding, Long> {
    // Additional queries if needed
}
