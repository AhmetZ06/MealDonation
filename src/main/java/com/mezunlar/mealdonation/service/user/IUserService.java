package com.mezunlar.mealdonation.service.user;

import com.mezunlar.mealdonation.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUserEnabledStatus(Long userId, boolean enabled);
    User updateUser(Long userId, User updatedData);
    void deleteUser(Long userId);
}
