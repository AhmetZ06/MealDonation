package com.mezunlar.mealdonation.service;

import com.mezunlar.mealdonation.dto.AuthResponse;
import com.mezunlar.mealdonation.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

    public AuthResponse refreshToken(RefreshTokenRequest request);
}
