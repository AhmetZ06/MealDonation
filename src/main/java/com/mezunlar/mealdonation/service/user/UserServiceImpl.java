package com.mezunlar.mealdonation.service.user;

import com.mezunlar.mealdonation.model.User;
import com.mezunlar.mealdonation.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUserEnabledStatus(Long userId, boolean enabled) {
        User existingUser = getUserById(userId);
        if (existingUser.isEnabled() != enabled) {
            existingUser.setEnabled(enabled);
            return userRepository.save(existingUser);
        }
        return existingUser;
    }


    public User updateUser(Long userId, User updatedData) {
        User existingUser = getUserById(userId);

        if (updatedData.getFirstName() != null) {
            existingUser.setFirstName(updatedData.getFirstName());
        }
        if (updatedData.getLastName() != null) {
            existingUser.setLastName(updatedData.getLastName());
        }
        if (updatedData.getEmail() != null) {
            existingUser.setEmail(updatedData.getEmail());
        }
        if (updatedData.getRole() != null) {
            existingUser.setRole(updatedData.getRole());
        }
        if (updatedData.getPassword() != null) {
            existingUser.setPassword(updatedData.getPassword());
        }

        // Save changes
        return userRepository.save(existingUser);
    }

    /**
     * Delete a user by ID.
     */
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    /**
     * (Optional) Find users by role (e.g., STUDENT, MERCHANT, DONOR, ADMIN).
     */

    // Additional business logic as needed...
}
