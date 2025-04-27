package com.mezunlar.mealdonation.service;

import com.mezunlar.mealdonation.dto.DtoRegister;
import com.mezunlar.mealdonation.dto.DtoUser;
import com.mezunlar.mealdonation.dto.AuthRequest;
import com.mezunlar.mealdonation.dto.AuthResponse;

public interface IAuthService {

    public DtoUser register(DtoRegister request);

    public AuthResponse authenticate(AuthRequest request);
}
