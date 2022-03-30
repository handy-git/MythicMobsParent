package com.handy.lib.mm.listener;

import com.handy.lib.mm.event.MythicMobLibDeathEvent;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobDeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * MythicMob死亡时触发本事件
 *
 * @author handy
 * @since 1.0.1
 */
public class MythicMobDeathEventMiddleListener implements Listener {

    /**
     * MythicMob死亡时触发本事件.
     *
     * @param event 事件
     */
    @EventHandler
    public void onEntityDeath(MythicMobDeathEvent event) {
        // 发送兼容性事件
        Bukkit.getServer().getPluginManager().callEvent(new MythicMobLibDeathEvent(event.getMobType().getInternalName(), event.getKiller(), event.getDrops()));
    }

}
