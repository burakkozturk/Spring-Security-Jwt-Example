package spring.security.jwtexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import spring.security.jwtexample.dto.LoginDto;
import spring.security.jwtexample.dto.UserDto;
import spring.security.jwtexample.dto.UserResponse;
import spring.security.jwtexample.entity.User;
import spring.security.jwtexample.enums.Role;
import spring.security.jwtexample.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public UserResponse save(UserDto userDto) {

        User user = User.builder().username(userDto.getUsername())
                .password(userDto.getPassword()).nameSurname(userDto.getNameSurname())
                .role(Role.USER).build();


        userRepository.save(user);


        var token = jwtService.generateToken(user);

        return UserResponse.builder().token(token).build();


    }


    public UserResponse auth(LoginDto userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }
}
