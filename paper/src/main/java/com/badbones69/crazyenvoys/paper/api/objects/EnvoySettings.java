package com.badbones69.crazyenvoys.paper.api.objects;

import ch.jalu.configme.SettingsManager;
import com.badbones69.crazyenvoys.paper.CrazyEnvoys;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import us.crazycrew.crazyenvoys.common.config.ConfigManager;
import us.crazycrew.crazyenvoys.common.config.types.Config;
import java.util.List;

public class EnvoySettings {
    
    private boolean isFallingBlocksEnabled;
    private Material fallingBlockMaterial;
    private short fallingBlockDurability;
    private int fallingHeight;
    private boolean isMaxCrateEnabled;
    private boolean randomAmount;
    private int minCrates;
    private int maxCrates;
    private boolean useRandomLocations;
    private int maxRadius;
    private int minRadius;
    private boolean isEnvoyRunTimerEnabled;
    private String envoyRunTimer;
    private boolean isEnvoyCooldownEnabled;
    private String envoyCooldown;

    private boolean envoyFilter;

    private String envoyClockTime;

    private boolean isEnvoyCountDownEnabled;
    private int envoyCountDownTimer;
    private String envoyCountDownMessage;
    private String envoyCountDownMessageSeconds;

    private boolean isMinPlayersEnabled;
    private boolean isMinFlareEnabled;
    private int minPlayers;
    private boolean isPickupBroadcastEnabled;
    private boolean isEnvoyCollectCooldownEnabled;
    private String envoyCollectCooldownTimer;
    private boolean isWorldMessagesEnabled;
    private List<String> worldMessagesWorlds;
    private List<String> envoyWarnings;
    private boolean isFlaresRegionEnabled;
    private List<String> flaresRegions;
    
    public void loadSettings() {
        ConfigManager configManager = JavaPlugin.getPlugin(CrazyEnvoys.class).getCrazyHandler().getConfigManager();
        SettingsManager config = configManager.getConfig();
        this.isFallingBlocksEnabled = config.getProperty(Config.envoy_falling_block_toggle);
        this.fallingBlockDurability = 15;
        String fallingBlock = config.getProperty(Config.envoy_falling_block_type);

        if (fallingBlock.contains(":")) {
            String[] split = fallingBlock.split(":");
            fallingBlock = split[0];
            fallingHeight = Integer.parseInt(split[1]);
        }
        
        this.fallingBlockMaterial = Material.matchMaterial(fallingBlock);
        
        if (fallingBlockMaterial == null) fallingBlockMaterial = Material.BEACON;
        
        this.fallingHeight = config.getProperty(Config.envoy_falling_height);
        this.isMaxCrateEnabled = config.getProperty(Config.envoys_max_drops_toggle);
        this.randomAmount = config.getProperty(Config.envoys_random_drops);
        this.minCrates = config.getProperty(Config.envoys_min_drops);
        this.maxCrates = config.getProperty(Config.envoys_max_drops);
        this.useRandomLocations = config.getProperty(Config.envoys_random_locations);
        this.maxRadius = config.getProperty(Config.envoys_max_radius);
        this.minRadius = config.getProperty(Config.envoys_min_radius);
        this.isEnvoyRunTimerEnabled = config.getProperty(Config.envoys_run_time_toggle);
        this.envoyRunTimer = config.getProperty(Config.envoys_run_time).toLowerCase();
        this.isEnvoyCooldownEnabled = config.getProperty(Config.envoys_countdown);
        this.envoyCooldown = config.getProperty(Config.envoys_cooldown);
        this.envoyFilter = config.getProperty(Config.envoys_ignore_empty_server);

        this.isEnvoyCountDownEnabled = config.getProperty(Config.envoys_grace_period_toggle);
        this.envoyCountDownTimer = config.getProperty(Config.envoys_grace_period_timer);
        this.envoyCountDownMessage = config.getProperty(Config.envoys_grace_period_unlocked);
        this.envoyCountDownMessageSeconds = config.getProperty(Config.envoys_grace_period_time_unit);

        this.envoyClockTime = config.getProperty(Config.envoys_time);
        this.isMinPlayersEnabled = config.getProperty(Config.envoys_minimum_players_toggle);
        this.isMinFlareEnabled = config.getProperty(Config.envoys_flare_minimum_players_toggle);
        this.minPlayers = config.getProperty(Config.envoys_minimum_players_amount);
        this.isPickupBroadcastEnabled = config.getProperty(Config.envoys_announce_player_pickup);
        this.isEnvoyCollectCooldownEnabled = config.getProperty(Config.envoys_grab_cooldown_toggle);
        this.envoyCollectCooldownTimer = config.getProperty(Config.envoys_grab_cooldown_timer);
        this.isWorldMessagesEnabled = config.getProperty(Config.envoys_world_messages);
        this.worldMessagesWorlds = config.getProperty(Config.envoys_allowed_worlds);
        this.envoyWarnings = config.getProperty(Config.envoys_warnings);
        this.isFlaresRegionEnabled = config.getProperty(Config.envoys_flare_world_guard_toggle);
        this.flaresRegions = config.getProperty(Config.envoys_flare_world_guard_regions);
    }
    
    public boolean isFallingBlocksEnabled() {
        return this.isFallingBlocksEnabled;
    }
    
    public EnvoySettings setFallingBlocksEnabled(boolean fallingBlocksEnabled) {
        this.isFallingBlocksEnabled = fallingBlocksEnabled;
        return this;
    }
    
    public Material getFallingBlockMaterial() {
        return this.fallingBlockMaterial;
    }
    
    public EnvoySettings setFallingBlockMaterial(Material fallingBlockMaterial) {
        this.fallingBlockMaterial = fallingBlockMaterial;
        return this;
    }
    
    public short getFallingBlockDurability() {
        return this.fallingBlockDurability;
    }
    
    public EnvoySettings setFallingBlockDurability(short fallingBlockDurability) {
        this.fallingBlockDurability = fallingBlockDurability;
        return this;
    }
    
    public int getFallingHeight() {
        return this.fallingHeight;
    }
    
    public EnvoySettings setFallingHeight(int fallingHeight) {
        this.fallingHeight = fallingHeight;
        return this;
    }
    
    public boolean isMaxCrateEnabled() {
        return this.isMaxCrateEnabled;
    }
    
    public EnvoySettings setMaxCrateEnabled(boolean maxCrateEnabled) {
        this.isMaxCrateEnabled = maxCrateEnabled;
        return this;
    }

    public boolean isEnvoyFilterEnabled() {
        return this.envoyFilter;
    }

    public EnvoySettings setEnvoyFilterEnabled(boolean envoyFilter) {
        this.envoyFilter = envoyFilter;
        return this;
    }

    public boolean isEnvoyCountDownEnabled() {
        return this.isEnvoyCountDownEnabled;
    }

    public int getEnvoyCountDownTimer() {
        return this.envoyCountDownTimer;
    }

    public String getEnvoyCountDownMessage() {
        return this.envoyCountDownMessage;
    }

    public String getEnvoyCountDownMessageSeconds() {
        return this.envoyCountDownMessageSeconds;
    }

    public boolean isRandomAmount() {
        return this.randomAmount;
    }
    
    public int getMinCrates() {
        return this.minCrates;
    }
    
    public int getMaxCrates() {
        return this.maxCrates;
    }
    
    public EnvoySettings setMaxCrates(int maxCrates) {
        this.maxCrates = maxCrates;
        return this;
    }
    
    public boolean isRandomLocationsEnabled() {
        return this.useRandomLocations;
    }
    
    public EnvoySettings setUseRandomLocations(boolean useRandomLocations) {
        this.useRandomLocations = useRandomLocations;
        return this;
    }
    
    public int getMaxRadius() {
        return this.maxRadius;
    }
    
    public EnvoySettings setMaxRadius(int maxRadius) {
        this.maxRadius = maxRadius;
        return this;
    }
    
    public int getMinRadius() {
        return this.minRadius;
    }
    
    public EnvoySettings setMinRadius(int minRadius) {
        this.minRadius = minRadius;
        return this;
    }
    
    public boolean isEnvoyRunTimerEnabled() {
        return this.isEnvoyRunTimerEnabled;
    }
    
    public EnvoySettings setEnvoyRunTimerEnabled(boolean envoyRunTimerEnabled) {
        this.isEnvoyRunTimerEnabled = envoyRunTimerEnabled;
        return this;
    }
    
    public String getEnvoyRunTimer() {
        return this.envoyRunTimer;
    }
    
    public EnvoySettings setEnvoyRunTimer(String envoyRunTimer) {
        this.envoyRunTimer = envoyRunTimer;
        return this;
    }
    
    public boolean isEnvoyCooldownEnabled() {
        return this.isEnvoyCooldownEnabled;
    }
    
    public EnvoySettings setEnvoyCooldownEnabled(boolean envoyCooldownEnabled) {
        this.isEnvoyCooldownEnabled = envoyCooldownEnabled;
        return this;
    }
    
    public String getEnvoyCooldown() {
        return this.envoyCooldown;
    }
    
    public EnvoySettings setEnvoyCooldown(String envoyCooldown) {
        this.envoyCooldown = envoyCooldown;
        return this;
    }
    
    public String getEnvoyClockTime() {
        return this.envoyClockTime;
    }
    
    public EnvoySettings setEnvoyClockTime(String envoyClockTime) {
        this.envoyClockTime = envoyClockTime;
        return this;
    }
    
    public boolean isMinPlayersEnabled() {
        return this.isMinPlayersEnabled;
    }
    
    public EnvoySettings setMinPlayersEnabled(boolean minPlayersEnabled) {
        this.isMinPlayersEnabled = minPlayersEnabled;
        return this;
    }
    
    public boolean isMinFlareEnabled() {
        return this.isMinFlareEnabled;
    }
    
    public EnvoySettings setMinFlareEnabled(boolean minFlareEnabled) {
        this.isMinFlareEnabled = minFlareEnabled;
        return this;
    }
    
    public int getMinPlayers() {
        return this.minPlayers;
    }
    
    public EnvoySettings setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
        return this;
    }
    
    public boolean isPickupBroadcastEnabled() {
        return this.isPickupBroadcastEnabled;
    }
    
    public EnvoySettings setPickupBroadcastEnabled(boolean pickupBroadcastEnabled) {
        this.isPickupBroadcastEnabled = pickupBroadcastEnabled;
        return this;
    }
    
    public boolean isEnvoyCollectCooldownEnabled() {
        return this.isEnvoyCollectCooldownEnabled;
    }
    
    public EnvoySettings setEnvoyCollectCooldownEnabled(boolean envoyCollectCooldownEnabled) {
        this.isEnvoyCollectCooldownEnabled = envoyCollectCooldownEnabled;
        return this;
    }
    
    public String getEnvoyCollectCooldownTimer() {
        return this.envoyCollectCooldownTimer;
    }
    
    public EnvoySettings setCrateCooldownTimer(String envoyCollectCooldownTimer) {
        this.envoyCollectCooldownTimer = envoyCollectCooldownTimer;
        return this;
    }
    
    public boolean isWorldMessagesEnabled() {
        return this.isWorldMessagesEnabled;
    }
    
    public EnvoySettings setWorldMessagesEnabled(boolean worldMessagesEnabled) {
        this.isWorldMessagesEnabled = worldMessagesEnabled;
        return this;
    }
    
    public List<String> getWorldMessagesWorlds() {
        return this.worldMessagesWorlds;
    }
    
    public EnvoySettings setWorldMessagesWorlds(List<String> worldMessagesWorlds) {
        this.worldMessagesWorlds = worldMessagesWorlds;
        return this;
    }
    
    public List<String> getEnvoyWarnings() {
        return this.envoyWarnings;
    }
    
    public EnvoySettings setEnvoyWarnings(List<String> envoyWarnings) {
        this.envoyWarnings = envoyWarnings;
        return this;
    }
    
    public boolean isFlaresRegionEnabled() {
        return this.isFlaresRegionEnabled;
    }
    
    public EnvoySettings setFlaresRegionEnabled(boolean flaresRegionEnabled) {
        this.isFlaresRegionEnabled = flaresRegionEnabled;
        return this;
    }
    
    public List<String> getFlaresRegions() {
        return this.flaresRegions;
    }
    
    public EnvoySettings setFlaresRegions(List<String> flaresRegions) {
        this.flaresRegions = flaresRegions;
        return this;
    }
}