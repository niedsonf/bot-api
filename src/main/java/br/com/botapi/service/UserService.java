package br.com.botapi.service;

import br.com.botapi.dto.UserJidNameDTO;
import br.com.botapi.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;



    public void updateUserName(@Valid UserJidNameDTO userJidNameDTO) {

    }
}
