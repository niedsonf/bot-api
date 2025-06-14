package br.com.botapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAttributes {
    private Integer currentHP;
    private Integer maxHP;
    private Integer defense;
}
