package spring.security.jwtexample.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.jwtexample.dto.LoginDto;
import spring.security.jwtexample.dto.UserDto;
import spring.security.jwtexample.dto.UserResponse;
import spring.security.jwtexample.service.AuthenticationService;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private final AuthenticationService authenticationService;

    @PostMapping("/save")
    public ResponseEntity<UserResponse> save (@RequestBody UserDto userDto){

        return ResponseEntity.ok(authenticationService.save(userDto));

    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> auth(@RequestBody LoginDto userRequest) {
        return ResponseEntity.ok(authenticationService.auth(userRequest));
    }



}
