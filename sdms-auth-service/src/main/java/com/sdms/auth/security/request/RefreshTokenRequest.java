package com.sdms.auth.security.request;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String refreshToken;
}