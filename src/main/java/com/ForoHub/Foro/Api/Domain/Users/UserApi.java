package com.ForoHub.Foro.Api.Domain.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "userapi")
@Entity(name = "UserApi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idemail")
public class UserApi implements UserDetails {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;
    private String nombre;
    private String idemail;
    private String password;
    private int idperfil;
    private int status;
    private LocalDateTime dateregister;

    public UserApi(UserData userData, int idt, String pass) {

        this.iduser = idt;
        this.status = 1;
        this.nombre = userData.nombre ();
        this.idemail = userData.idemail ();
        this.password = pass;
        this.idperfil = userData.idperfil ();
        this.dateregister = LocalDateTime.now();
    }

    public void udpateUserApi(UserData userData, String pass) {
        if (userData.nombre () != null) {
            this.nombre = userData.nombre ();
        }
        if (userData.password () != null) {
            this.password = pass;
        }
        if (userData.idperfil () != 0) {
            this.idperfil = userData.idperfil ();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of ( new SimpleGrantedAuthority ("ROLE_USER") );
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return idemail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //UserDetails.super.isAccountNonExpired ( );
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //UserDetails.super.isAccountNonLocked ( );
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //UserDetails.super.isCredentialsNonExpired ( );
    }

    @Override
    public boolean isEnabled() {
        return true; //UserDetails.super.isEnabled ( );
    }
}
