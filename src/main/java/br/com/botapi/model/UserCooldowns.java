package br.com.botapi.model;

import com.google.cloud.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCooldowns {
    private Timestamp dailyCooldown;
    private Timestamp weeklyCooldown;
    private Timestamp monthlyCooldown;

    private Timestamp fishCooldown;
    private Timestamp mineCooldown;
    private Timestamp chopCooldown;
    private Timestamp harvestCooldown;
    private Timestamp huntCooldown;
}
