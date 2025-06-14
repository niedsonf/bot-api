package br.com.botapi.usecase;

import br.com.botapi.dto.UserJidNameDTO;
import br.com.botapi.model.User;
import br.com.botapi.model.UserFinances;
import br.com.botapi.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UserUseCase {
    @Inject
    UserRepository userRepository;

    public User getUserByJid(
            @Pattern(regexp = "^\\d{12,14}@s\\.whatsapp\\.net$", message = "Jid inválido")
            String jid) {
        User user = userRepository.findByJid(jid);
        if (user == null) {
            throw new NotFoundException("Usuário não cadastrado");
        }
        return user;
    }

    public void createUser(@Valid UserJidNameDTO userJidNameDTO) {
        User existingUser = userRepository.findByJid(userJidNameDTO.getJid());
        if (existingUser != null) {
            throw new RuntimeException(existingUser.getName() + " já está cadastrado");
        }
        userRepository.create(User.createNewUser(userJidNameDTO));
    }

    public void updateUserName(@Valid UserJidNameDTO userJidNameDTO) {
        Integer UPDATE_NAME_COST = 10000;
        User user = getUserByJid(userJidNameDTO.getJid());
        UserFinances finances = user.getFinances();
        if (finances.getWallet() < UPDATE_NAME_COST) {
            throw new RuntimeException("É necessário ter 10k na carteira para mudar o nome");
        }

        user.setName(userJidNameDTO.getName());
        finances.setWallet(finances.getWallet() - UPDATE_NAME_COST);

        userRepository.update(user);
    }
}
