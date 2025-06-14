package br.com.botapi.repository;

import br.com.botapi.dto.UserJidNameDTO;
import br.com.botapi.model.User;

public interface UserRepository {
    void create(User user);

    User findByJid(String jid);

    void update(User user);
}
