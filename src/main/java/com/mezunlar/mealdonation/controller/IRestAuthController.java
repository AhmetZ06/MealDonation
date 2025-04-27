package com.mezunlar.mealdonation.controller;

import com.mezunlar.mealdonation.dto.DtoRegister;
import com.mezunlar.mealdonation.dto.DtoUser;
import com.mezunlar.mealdonation.dto.AuthRequest;
import com.mezunlar.mealdonation.dto.AuthResponse;
import com.mezunlar.mealdonation.jwt.RefreshTokenRequest;

public interface IRestAuthController {

    public DtoUser register(DtoRegister request);

    public AuthResponse authenticate(AuthRequest request);

    public AuthResponse refreshToken(RefreshTokenRequest request);
}
