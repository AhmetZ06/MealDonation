package com.mezunlar.mealdonation.repository;

import com.mezunlar.mealdonation.model.Meals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long> {
    // e.g. List<Meals> findByCategory(String category);
}
