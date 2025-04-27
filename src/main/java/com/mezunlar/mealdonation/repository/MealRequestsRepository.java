package com.mezunlar.mealdonation.repository;

import com.mezunlar.mealdonation.model.MealRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRequestsRepository extends JpaRepository<MealRequests, Long> {
    // Additional query methods if needed
    // e.g. List<MealRequests> findByStatus(MealRequestStatus status);
}
