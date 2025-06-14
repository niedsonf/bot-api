package br.com.botapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFinances {
    private Integer wallet;
    private Integer bank;
}
