package com.helpdesk.application.security;

import com.helpdesk.application.app.data.entity.UsuarioSoporteEntity;
import com.helpdesk.application.app.data.repository.UsuarioSoporteRepository;
import com.vaadin.flow.spring.security.AuthenticationContext;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUser {

    private final UsuarioSoporteRepository usuarioSoporteRepository;
    private final AuthenticationContext authenticationContext;

    public AuthenticatedUser(AuthenticationContext authenticationContext, UsuarioSoporteRepository usuarioSoporteRepository) {
        this.usuarioSoporteRepository = usuarioSoporteRepository;
        this.authenticationContext = authenticationContext;
    }

    public Optional<UsuarioSoporteEntity> get() {
        return authenticationContext.getAuthenticatedUser(UserDetails.class)
                .map(userDetails -> usuarioSoporteRepository.findByNombreUsuario(userDetails.getUsername()));
    }

    public void logout() {
        authenticationContext.logout();
    }

}
