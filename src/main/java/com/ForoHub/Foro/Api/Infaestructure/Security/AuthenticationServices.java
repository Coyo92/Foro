package com.ForoHub.Foro.Api.Infaestructure.Security;

import com.ForoHub.Foro.Api.Domain.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String idemail) throws UsernameNotFoundException {
        return userRepository.findByIdemail ( idemail );
    }
}
