package br.com.botapi.dto;

import br.com.botapi.model.*;
import com.google.cloud.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class FirebaseUserDTO {
    private String jid;
    private String name;
    private Timestamp createdAt;

    private Integer xp;
    private Integer level;
    private FirebaseUserHPDTO hp;
    private Integer def;

    private Integer wallet;
    private Integer bank;

    private Integer salesValue;
    private ArrayList<Integer> achievements;
    private ArrayList<InventoryItem> inventory;
    private Integer gambledValue;

    private Timestamp dailyCooldown;
    private Timestamp weeklyCooldown;
    private Timestamp monthlyCooldown;

    private Timestamp fishCooldown;
    private Timestamp mineCooldown;
    private Timestamp chopCooldown;
    private Timestamp harvestCooldown;
    private Timestamp huntCooldown;

    public User toDomain() {
        Timestamp currentTimestamp = Timestamp.now();

        User user = new User();
        UserFinances finances = new UserFinances();
        UserAttributes attributes = new UserAttributes();
        UserCooldowns cooldowns = new UserCooldowns();
        UserStatistics statistics = new UserStatistics();

        user.setJid(this.jid);
        user.setName(this.name);
        user.setCreatedAt(this.createdAt);
        user.setLevel(this.level);
        user.setXp(this.xp);

        finances.setWallet(this.wallet);
        finances.setBank(this.bank);
        user.setFinances(finances);

        attributes.setCurrentHP(this.hp.current);
        attributes.setMaxHP(this.hp.max);
        attributes.setDefense(this.def);
        user.setAttributes(attributes);

        cooldowns.setDailyCooldown(this.dailyCooldown);
        cooldowns.setWeeklyCooldown(this.weeklyCooldown);
        cooldowns.setMonthlyCooldown(this.monthlyCooldown);
        cooldowns.setFishCooldown(this.fishCooldown);
        cooldowns.setChopCooldown(this.chopCooldown);
        cooldowns.setHarvestCooldown(this.harvestCooldown);
        cooldowns.setMineCooldown(this.mineCooldown);
        cooldowns.setHuntCooldown(this.huntCooldown);
        user.setCooldowns(cooldowns);

        statistics.setGambledValue(this.gambledValue);
        statistics.setSalesValue(this.salesValue);
        user.setStatistics(statistics);

        user.setAchievements(this.achievements);
        user.setInventory(this.inventory);

        return user;
    }

    public static FirebaseUserDTO fromDomain(User user) {
        FirebaseUserDTO firebaseUserDTO = new FirebaseUserDTO();
        firebaseUserDTO.setJid(user.getJid());
        firebaseUserDTO.setName(user.getName());
        firebaseUserDTO.setCreatedAt(user.getCreatedAt());
        firebaseUserDTO.setXp(user.getXp());
        firebaseUserDTO.setLevel(user.getLevel());

        UserAttributes attributes = user.getAttributes();
        FirebaseUserHPDTO hp = new FirebaseUserHPDTO();
        hp.setCurrent(attributes.getCurrentHP());
        hp.setMax(attributes.getMaxHP());
        firebaseUserDTO.setHp(hp);
        firebaseUserDTO.setDef(attributes.getDefense());

        UserFinances finances = user.getFinances();
        firebaseUserDTO.setWallet(finances.getWallet());
        firebaseUserDTO.setBank(finances.getBank());

        UserStatistics statistics = user.getStatistics();
        firebaseUserDTO.setSalesValue(statistics.getSalesValue());
        firebaseUserDTO.setGambledValue(statistics.getGambledValue());

        UserCooldowns cooldowns = user.getCooldowns();
        firebaseUserDTO.setDailyCooldown(cooldowns.getDailyCooldown());
        firebaseUserDTO.setWeeklyCooldown(cooldowns.getWeeklyCooldown());
        firebaseUserDTO.setMonthlyCooldown(cooldowns.getMonthlyCooldown());
        firebaseUserDTO.setFishCooldown(cooldowns.getFishCooldown());
        firebaseUserDTO.setMineCooldown(cooldowns.getMineCooldown());
        firebaseUserDTO.setChopCooldown(cooldowns.getChopCooldown());
        firebaseUserDTO.setHarvestCooldown(cooldowns.getHarvestCooldown());
        firebaseUserDTO.setHuntCooldown(cooldowns.getHuntCooldown());

        firebaseUserDTO.setAchievements(user.getAchievements());
        firebaseUserDTO.setInventory(user.getInventory());

        return firebaseUserDTO;
    }
}

@Getter
@Setter
class FirebaseUserHPDTO {
    protected Integer current;
    protected Integer max;
}