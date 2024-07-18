package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.dto.*;
import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.City;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.UserPrincipal;
import org.generation.italy.reshare.model.services.abstractions.AppUserService;
import org.generation.italy.reshare.model.services.abstractions.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {
    private AppUserService appUserService;
    private JwtService jwtService;
    AuthenticationManager authenticationManager;

    @Autowired
    public AppUserController(AppUserService appUserService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.appUserService = appUserService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public RegisterDto register(@RequestBody RegisterDto registerUser) {
        City city = appUserService.getCityByName(registerUser.getUser().getCityName());
        AppUser user = registerUser.toAppUser(city);
        AppUser savedUser = appUserService.saveUser(user);
        AppUserDto userDto = new AppUserDto(savedUser);
        return new RegisterDto(userDto, user.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginInfoDto login){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        if(authentication.isAuthenticated())
            return ResponseEntity.ok(new TokenDto(jwtService.generateToken(login.getEmail()),null));
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new TokenDto(null, "Login Failed"));

    }

    @GetMapping("/user")
    public ResponseEntity<?> getLoggedUser(@AuthenticationPrincipal UserPrincipal principal){
        try {
            System.out.println(principal.getUserId());
            AppUser result = appUserService.getUserById(principal.getUserId());
            return ResponseEntity.ok().body(result);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
