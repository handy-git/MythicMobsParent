package com.handy.lib.mm;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.api.skills.placeholders.PlaceholderString;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * MythicMob 大于等于5.x版本工具类
 *
 * @author handy
 * @since 1.0.0
 */
public class MythicMobHighUtil {
    private MythicBukkit mythicMobs = null;

    private MythicMobHighUtil() {
    }

    private static final MythicMobHighUtil INSTANCE = new MythicMobHighUtil();

    /**
     * 获取唯一实例
     *
     * @return this
     */
    public static MythicMobHighUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 加载MythicMobs
     */
    private void loadMythicMobs() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("MythicMobs");
        if (plugin == null) {
            return;
        }
        this.mythicMobs = (MythicBukkit) plugin;
    }

    /**
     * 获取mm map
     *
     * @param pageNum 页数
     * @return key: displayName value: internalName
     */
    protected Map<String, String> getMythicMobMap(Integer pageNum) {
        Map<String, String> map = new LinkedHashMap<>();
        List<MythicMob> mythicMobs = this.getMythicMobs(pageNum);
        if (mythicMobs != null && !mythicMobs.isEmpty()) {
            for (MythicMob mythicMob : mythicMobs) {
                String displayName = mythicMob.getDisplayName() != null ? mythicMob.getDisplayName().get() : mythicMob.getInternalName();
                map.put(displayName, mythicMob.getInternalName());
            }
        }
        return map;
    }

    /**
     * 获取mm怪物
     *
     * @param pageNum 页数
     * @return mm怪物
     */
    protected List<MythicMob> getMythicMobs(Integer pageNum) {
        Collection<MythicMob> mythicMobs = MythicBukkit.inst().getMobManager().getMobTypes();
        Stream<MythicMob> limit = mythicMobs.stream().skip(pageNum * 45L).limit(45);
        return limit.collect(Collectors.toList());
    }

    /**
     * 获取单个怪物名称
     *
     * @param internalName 内部名称
     * @return 怪物名称
     */
    protected String getMythicMobName(String internalName) {
        Optional<MythicMob> mythicMobOptional = MythicBukkit.inst().getMobManager().getMythicMob(internalName);
        if (mythicMobOptional.isPresent()) {
            MythicMob mythicMob = mythicMobOptional.get();
            PlaceholderString placeholderString = mythicMob.getDisplayName();
            if (placeholderString == null) {
                return internalName;
            }
            return placeholderString.get();
        }
        return internalName;
    }

    /**
     * 获取mm怪物数量
     *
     * @return 怪物数量
     */
    protected Integer getMythicMobsCount() {
        Collection<MythicMob> mythicMobs = MythicBukkit.inst().getMobManager().getMobTypes();
        return mythicMobs.size();
    }

}