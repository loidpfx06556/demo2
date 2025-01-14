package com.example.demo2.controllers;

import com.example.demo2.dtos.UserDTO;
import com.example.demo2.dtos.response.AdminStats;
import com.example.demo2.dtos.response.ApiResponse;
import com.example.demo2.dtos.response.AuditLogEntry;
import com.example.demo2.entities.Role;
import com.example.demo2.services.AdminService;
import com.example.demo2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<Page<UserDTO>>> getAllUsers(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Boolean enabled,
            @RequestParam(required = false) String role,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.success(adminService.getAllUsers(search, enabled, role, pageable))
        );
    }

    @GetMapping("/roles")
    public ResponseEntity<ApiResponse<List<Role>>> getAllRoles() {
        return ResponseEntity.ok(
                ApiResponse.success(adminService.getAllRoles())
        );
    }

    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<AdminStats>> getSystemStats() {
        return ResponseEntity.ok(
                ApiResponse.success(adminService.getSystemStats())
        );
    }

    @GetMapping("/audit-logs")
    public ResponseEntity<ApiResponse<Page<AuditLogEntry>>> getAuditLogs(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.success(adminService.getAuditLogs(username, action, fromDate, toDate, pageable))
        );
    }
}

