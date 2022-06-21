package cn.handyplus.lib.mm;

import org.bukkit.plugin.Plugin;

/**
 * MythicMob版本工具类
 *
 * @author handy
 * @since 1.0.0
 */
public class VersionUtil {

    /**
     * 获取版本第一位
     *
     * @param plugin 插件
     * @return 版本第一位
     * @since 1.0.0
     */
    protected static int getFirstPluginVersion(Plugin plugin) {
        String version = plugin.getDescription().getVersion();
        String[] split = version.split("\\.");
        return Integer.parseInt(split[0]);
    }

    /**
     * 获取版本第二位
     *
     * @param plugin 插件
     * @return 版本第二位
     * @since 1.0.0
     */
    protected static int getTwoPluginVersion(Plugin plugin) {
        String version = plugin.getDescription().getVersion();
        String[] split = version.split("\\.");
        return Integer.parseInt(split[1]);
    }

}
