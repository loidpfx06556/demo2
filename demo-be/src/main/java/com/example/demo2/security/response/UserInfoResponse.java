package com.example.demo2.security.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class UserInfoResponse {
    private UUID userId;
    private String username;
    private String email;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private LocalDate credentialsExpiryDate;
    private LocalDate accountExpiryDate;
    private boolean isTwoFactorEnabled;
    private List<String> roles;

    public UserInfoResponse(UUID userId, String username, String email, boolean accountNonLocked, boolean accountNonExpired,
                            boolean credentialsNonExpired, boolean enabled, LocalDate credentialsExpiryDate,
                            LocalDate accountExpiryDate, boolean isTwoFactorEnabled, List<String> roles) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.credentialsExpiryDate = credentialsExpiryDate;
        this.accountExpiryDate = accountExpiryDate;
        this.isTwoFactorEnabled = isTwoFactorEnabled;
        this.roles = roles;
    }
}
