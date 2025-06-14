package br.com.botapi.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class UserJidNameDTO {
    @Pattern(regexp = "^\\d{12,14}@s\\.whatsapp\\.net$", message = "Jid inválido")
    private String jid;

    @Length(min = 3, message = "Nome deve ter no mínimo 3 letras")
    private String name;
}
