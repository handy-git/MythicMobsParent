# MythicMobsLib

#### 介绍
MythicMobs全版本兼容性lib 作者 handy(米饭)

#### 项目层级
1. MythicMobsHide 大于等于5.x 版本兼容
2. MythicMobsLib MythicMobsLib最终打包的框架
3. MythicMobsLibEvent 对MythicMobs的原生事件兼容包
4. MythicMobsLow 小于4.7 版本兼容
5. MythicMobsMiddle 4.7-4.14.2 版本兼容
6. docs javadoc目录

#### 打包方式
maven 打包父层级parent  
注意: 需配置maven setting.yml 里的私库地址  
私库需包含依赖的spigot和MythicMobs相关版本

#### 成品
MythicMobsLib

#### 使用方式
1. 引入MythicMobsLib依赖
2. 调用初始化方法 MythicMobUtil.init(Plugin)
3. 之后调用 MythicMobUtil.getInstance()获取唯一实例来调用方法
##### MythicMob已兼容方法
[javadoc](https://server-ct.gitee.io/mythicmobsparent/com/handy/lib/mm/MythicMobUtil.html)
##### MythicMob已兼事件兼容
MythicMobDeathEvent 请监听 MythicMobLibDeathEvent