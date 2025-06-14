package br.com.botapi.dto;

import br.com.botapi.model.UserCooldowns;

public record UserCooldownsDTO(String name, UserCooldowns cooldowns) {
}
