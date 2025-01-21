package com.dms.search.client;


import com.dms.search.config.FeignConfig;
import com.dms.search.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("/api/v1/users")
    ResponseEntity<UserDto> getUserByUsername(@RequestParam("username") String username);
}
