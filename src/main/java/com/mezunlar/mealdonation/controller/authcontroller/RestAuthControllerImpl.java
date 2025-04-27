package com.mezunlar.mealdonation.controller.authcontroller;


import com.mezunlar.mealdonation.dto.DtoRegister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mezunlar.mealdonation.dto.DtoUser;
import com.mezunlar.mealdonation.dto.AuthRequest;
import com.mezunlar.mealdonation.dto.AuthResponse;
import com.mezunlar.mealdonation.jwt.RefreshTokenRequest;
import com.mezunlar.mealdonation.service.auth.IAuthService;
import com.mezunlar.mealdonation.service.refreshtoken.IRefreshTokenService;

import jakarta.validation.Valid;

@RestController
public class RestAuthControllerImpl implements IRestAuthController{

    private final IAuthService authService;
    private final IRefreshTokenService refreshTokenService;

    public RestAuthControllerImpl(IAuthService authService, IRefreshTokenService refreshTokenService) {
        this.authService = authService;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody DtoRegister request) {
        return authService.register(request);
    }

    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }

    @PostMapping("/refreshToken")
    @Override
    public AuthResponse refreshToken(@RequestBody RefreshTokenRequest request) {
        return refreshTokenService.refreshToken(request);
    }


}
