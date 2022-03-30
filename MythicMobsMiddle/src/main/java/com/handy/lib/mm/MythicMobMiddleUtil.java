package com.handy.lib.mm;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.MythicMob;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * MythicMob 4.7-4.14.2 工具类
 *
 * @author handy
 * @since 1.0.0
 */
public class MythicMobMiddleUtil {
    private MythicMobMiddleUtil() {
    }

    private static final MythicMobMiddleUtil INSTANCE = new MythicMobMiddleUtil();

    /**
     * 获取唯一实例
     *
     * @return this
     */
    public static MythicMobMiddleUtil getInstance() {
        return INSTANCE;
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
        Collection<MythicMob> mythicMobs = MythicMobs.inst().getMobManager().getMobTypes();
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
        MythicMob mythicMob = MythicMobs.inst().getMobManager().getMythicMob(internalName);
        if (mythicMob == null || mythicMob.getDisplayName() == null) {
            return internalName;
        }
        String mythicMobName = mythicMob.getDisplayName().get();
        if (mythicMobName == null || "".equals(mythicMobName)) {
            return internalName;
        }
        return mythicMobName;
    }

    /**
     * 获取mm怪物数量
     *
     * @return 怪物数量
     */
    protected Integer getMythicMobsCount() {
        Collection<MythicMob> mythicMobs = MythicMobs.inst().getMobManager().getMobTypes();
        return mythicMobs.size();
    }

}