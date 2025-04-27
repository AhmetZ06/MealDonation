package com.mezunlar.mealdonation.service.auth;


import java.util.Date;
import java.util.UUID;

import com.mezunlar.mealdonation.dto.DtoRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mezunlar.mealdonation.dto.DtoUser;
import com.mezunlar.mealdonation.dto.AuthRequest;
import com.mezunlar.mealdonation.dto.AuthResponse;
import com.mezunlar.mealdonation.jwt.JwtService;
import com.mezunlar.mealdonation.model.RefreshToken;
import com.mezunlar.mealdonation.model.User;
import com.mezunlar.mealdonation.repository.RefreshTokenRepository;
import com.mezunlar.mealdonation.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;


    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis()+ 1000*60*60*4));
        refreshToken.setUser(user);
        return refreshToken;
    }


    @Override
    public AuthResponse authenticate(AuthRequest request) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        authenticationProvider.authenticate(authInputToken);

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken = createRefreshToken(user);
        refreshTokenRepository.save(refreshToken);

        return new AuthResponse(accessToken, refreshToken.getRefreshToken());
    }


    @Override
    public DtoUser register(DtoRegister request) {

        DtoUser dto = new DtoUser();
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);

        User savedUser =  userRepository.save(user);
        BeanUtils.copyProperties(savedUser, dto);
        return dto;

    }







}
