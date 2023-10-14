package spring.security.jwtexample.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.security.jwtexample.enums.Role;


import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String nameSurname;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));


        // getAuthorities metodu kullanıcıların sahip olduğu rolleri döndürür.
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;


        // kullanıcı hesabının süresini dolup dolmadığını kontrol eder.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;


        // kullanıcı hesabının kitli olup olmadığını kontrol eder.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;


        // kullanıcı aktifliğini kontrol eder.
    }
}
