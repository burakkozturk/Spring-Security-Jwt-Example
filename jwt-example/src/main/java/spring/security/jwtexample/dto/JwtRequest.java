package spring.security.jwtexample.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private String email; // username yerine email kullanıyoruz
    private String password;

    //default constructor for JSON Parsing
    public JwtRequest() {}

    public JwtRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    //getters and setters
}