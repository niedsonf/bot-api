package br.com.botapi.model;

import br.com.botapi.dto.UserJidNameDTO;
import com.google.cloud.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String jid;
    private String name;
    private Timestamp createdAt;

    private Integer level;
    private Integer xp;

    private UserFinances finances;
    private UserAttributes attributes;
    private UserCooldowns cooldowns;
    private UserStatistics statistics;

    private ArrayList<InventoryItem> inventory;
    private ArrayList<Integer> achievements;

    public static User createNewUser(UserJidNameDTO userJidNameDTO) {
        Timestamp currentTimestamp = Timestamp.now();

        User user = new User();
        UserFinances finances = new UserFinances();
        UserAttributes attributes = new UserAttributes();
        UserCooldowns cooldowns = new UserCooldowns();
        UserStatistics statistics = new UserStatistics();

        user.setJid(userJidNameDTO.getJid());
        user.setName(userJidNameDTO.getName());
        user.setCreatedAt(currentTimestamp);
        user.setLevel(1);
        user.setXp(0);

        finances.setWallet(1000);
        finances.setBank(0);
        user.setFinances(finances);

        attributes.setCurrentHP(100);
        attributes.setMaxHP(100);
        attributes.setDefense(0);
        user.setAttributes(attributes);

        cooldowns.setDailyCooldown(currentTimestamp);
        cooldowns.setWeeklyCooldown(currentTimestamp);
        cooldowns.setMonthlyCooldown(currentTimestamp);
        cooldowns.setFishCooldown(currentTimestamp);
        cooldowns.setChopCooldown(currentTimestamp);
        cooldowns.setHarvestCooldown(currentTimestamp);
        cooldowns.setMineCooldown(currentTimestamp);
        cooldowns.setHuntCooldown(currentTimestamp);
        user.setCooldowns(cooldowns);

        statistics.setGambledValue(0);
        statistics.setSalesValue(0);
        user.setStatistics(statistics);

        user.setAchievements(new ArrayList<>());
        user.setInventory(new ArrayList<>());

        return user;
    }
}
