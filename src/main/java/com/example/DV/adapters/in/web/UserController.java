package com.example.DV.adapters.in.web;

import com.example.DV.application.dto.SignUpRequest;
import com.example.DV.application.service.UserService;
import com.example.DV.domain.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody @Valid SignUpRequest request) {
        User registeredUser = userService.signUp(request);
        return ResponseEntity.ok(registeredUser);
    }
}
