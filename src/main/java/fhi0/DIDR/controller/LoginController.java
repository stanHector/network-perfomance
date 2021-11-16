package fhi0.DIDR.controller;

import fhi0.DIDR.dto.UserLoginDto;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.response.ApiResponse;
import fhi0.DIDR.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    UsersService usersService;

    //user login api
    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody UserLoginDto loginDto) throws ResourceNotFoundException {
        return usersService.login(loginDto);
    }
}