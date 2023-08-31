package com.example.schoolapi.Controller;

import com.example.schoolapi.Api.ApiResponse;
import com.example.schoolapi.Dto.StudentDto;
import com.example.schoolapi.Dto.TecherDto;
import com.example.schoolapi.Model.User;
import com.example.schoolapi.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {


    private final AuthService authService;

    @PostMapping("/register/teacher")
    public ResponseEntity register(@RequestBody @Valid TecherDto user){
        authService.register(user);
        return ResponseEntity.status(200).body(new ApiResponse("user registered"));
    }


    @PostMapping("/register/student")
    public ResponseEntity registerStudent(@RequestBody @Valid StudentDto user){
        authService.registerUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user registered"));
    }

    @GetMapping("/get")
    public ResponseEntity getAlll(){
        return ResponseEntity.status(200).body(authService.getAll());
    }



}
