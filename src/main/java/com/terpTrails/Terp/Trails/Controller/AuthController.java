package com.terpTrails.Terp.Trails.Controller;


import com.terpTrails.Terp.Trails.dto.FirmRegisterRequest;
import com.terpTrails.Terp.Trails.dto.LoginRequest;
import com.terpTrails.Terp.Trails.dto.VolunteerRegisterRequest;
import com.terpTrails.Terp.Trails.service.AuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/volunteer")
    public ResponseEntity<?> registerVolunteer(@RequestBody VolunteerRegisterRequest request) {
        return authService.registerVolunteer(request);
    }

    @PostMapping("/register/research-firm")
    public ResponseEntity<?> registerResearchFirm(@RequestBody FirmRegisterRequest request) {
        return authService.registerResearchFirm(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        return authService.authenticate(request);
    }



}
