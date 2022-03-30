package com.handy.lib.mm;

import com.handy.lib.mm.listener.MythicMobDeathEventHideListener;
import com.handy.lib.mm.listener.MythicMobDeathEventLowListener;
import com.handy.lib.mm.listener.MythicMobDeathEventMiddleListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * MythicMob 工具类(使用这个即可)
 *
 * @author handy
 * @since 1.0.0
 */
public class MythicMobUtil {

    private static MythicMobVersionEnum MM_VERSION = null;

    private MythicMobUtil() {
    }

    private static final MythicMobUtil INSTANCE = new MythicMobUtil();

    /**
     * 获取实例
     *
     * @return this
     */
    public static MythicMobUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 初始化功能
     *
     * @param plugin 插件
     */
    public static void init(Plugin plugin) {
        Plugin mythicMobs = Bukkit.getPluginManager().getPlugin("MythicMobs");
        if (mythicMobs != null && MM_VERSION == null) {
            int firstPluginVersion = VersionUtil.getFirstPluginVersion(mythicMobs);
            int twoPluginVersion = VersionUtil.getTwoPluginVersion(mythicMobs);
            if (firstPluginVersion >= 5) {
                MM_VERSION = MythicMobVersionEnum.HIDE;
                plugin.getServer().getPluginManager().registerEvents(new MythicMobDeathEventHideListener(), plugin);
            } else if (twoPluginVersion < 7) {
                MM_VERSION = MythicMobVersionEnum.LOW;
                plugin.getServer().getPluginManager().registerEvents(new MythicMobDeathEventLowListener(), plugin);
            } else {
                MM_VERSION = MythicMobVersionEnum.MIDDLE;
                plugin.getServer().getPluginManager().registerEvents(new MythicMobDeathEventMiddleListener(), plugin);
            }
        }
    }

    /**
     * 获取MythicMob map
     * key为displayName value为internalName
     *
     * @param pageNum 页数
     * @return key: displayName value: internalName
     */
    public Map<String, String> getMythicMobMap(Integer pageNum) {
        if (MM_VERSION == null) {
            return new HashMap<>();
        }
        switch (MM_VERSION) {
            case LOW:
                return MythicMobLowUtil.getInstance().getMythicMobMap(pageNum);
            case HIDE:
                return MythicMobHighUtil.getInstance().getMythicMobMap(pageNum);
            case MIDDLE:
            default:
                return MythicMobMiddleUtil.getInstance().getMythicMobMap(pageNum);
        }
    }

    /**
     * 根据internalName获取MythicMob怪物名称
     *
     * @param internalName 内部名称
     * @return 怪物名称
     */
    public String getMythicMobName(String internalName) {
        if (MM_VERSION == null) {
            return internalName;
        }
        switch (MM_VERSION) {
            case LOW:
                return MythicMobLowUtil.getInstance().getMythicMobName(internalName);
            case HIDE:
                return MythicMobHighUtil.getInstance().getMythicMobName(internalName);
            case MIDDLE:
            default:
                return MythicMobMiddleUtil.getInstance().getMythicMobName(internalName);
        }
    }

    /**
     * 获取MythicMob怪物总数
     *
     * @return 怪物总数
     */
    public Integer getMythicMobsCount() {
        if (MM_VERSION == null) {
            return 0;
        }
        switch (MM_VERSION) {
            case LOW:
                return MythicMobLowUtil.getInstance().getMythicMobsCount();
            case HIDE:
                return MythicMobHighUtil.getInstance().getMythicMobsCount();
            case MIDDLE:
            default:
                return MythicMobMiddleUtil.getInstance().getMythicMobsCount();
        }
    }

}