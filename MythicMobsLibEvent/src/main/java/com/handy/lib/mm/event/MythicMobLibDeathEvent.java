package com.handy.lib.mm.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * MythicMobDeathEvent 事件 兼容性封装
 *
 * @author handy
 * @since 1.0.1
 */
public class MythicMobLibDeathEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final String internalName;
    private final LivingEntity killer;
    private final List<ItemStack> drops;

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * 获取HandlerList
     *
     * @return HandlerList
     */
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * 初始化事件
     *
     * @param internalName InternalName怪物标识
     * @param killer       击杀者
     * @param drops        掉落物
     */
    public MythicMobLibDeathEvent(String internalName, LivingEntity killer, List<ItemStack> drops) {
        this.internalName = internalName;
        this.killer = killer;
        this.drops = drops;
    }

    /**
     * 获取MythicMob InternalName怪物标识
     *
     * @return InternalName怪物标识
     */
    public String getInternalName() {
        return internalName;
    }

    /**
     * 获取击杀者
     *
     * @return LivingEntity
     */
    public LivingEntity getKiller() {
        return killer;
    }

    /**
     * 获取掉落物
     *
     * @return 掉落物
     */
    public List<ItemStack> getDrops() {
        return drops;
    }

}
