package com.mezunlar.mealdonation.Repository;

import com.mezunlar.mealdonation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // additional query methods if needed
}
