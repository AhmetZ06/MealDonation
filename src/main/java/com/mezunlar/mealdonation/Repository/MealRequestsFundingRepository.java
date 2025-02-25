package com.mezunlar.mealdonation.Repository;

import com.mezunlar.mealdonation.Model.MealRequestsFunding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRequestsFundingRepository extends JpaRepository<MealRequestsFunding, Long> {
    // Additional queries if needed
}
