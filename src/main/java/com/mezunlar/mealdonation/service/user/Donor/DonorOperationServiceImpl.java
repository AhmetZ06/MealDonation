package com.mezunlar.mealdonation.service.user.Donor;

import com.mezunlar.mealdonation.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DonorOperationServiceImpl implements IDonorOperationService {

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User updateUserEnabledStatus(Long userId, boolean enabled) {
        return null;
    }

    @Override
    public User updateUser(Long userId, User updatedData) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
