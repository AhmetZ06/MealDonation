package com.mezunlar.mealdonation.controller.impl;


import com.mezunlar.mealdonation.dto.DtoRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mezunlar.mealdonation.controller.IRestAuthController;
import com.mezunlar.mealdonation.dto.DtoUser;
import com.mezunlar.mealdonation.dto.AuthRequest;
import com.mezunlar.mealdonation.dto.AuthResponse;
import com.mezunlar.mealdonation.jwt.RefreshTokenRequest;
import com.mezunlar.mealdonation.service.IAuthService;
import com.mezunlar.mealdonation.service.IRefreshTokenService;

import jakarta.validation.Valid;

@RestController
public class RestAuthControllerImpl implements IRestAuthController{

    @Autowired
    private IAuthService authService;

    @Autowired
    private IRefreshTokenService refreshTokenService;

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
