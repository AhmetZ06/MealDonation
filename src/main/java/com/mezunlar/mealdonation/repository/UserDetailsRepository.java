package com.mezunlar.mealdonation.repository;

import com.mezunlar.mealdonation.model.UserDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetailedInfo, Long> {

}
