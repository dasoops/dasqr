//package com.dasoops.dasq.core.dq;
//
//import cn.hutool.core.util.StrUtil;
//import com.dasoops.dasq.core.common.service.DictionaryService;
//import com.dasoops.dasq.core.dq.entity.pojo.Factor;
//import com.dasoops.dasq.core.dq.service.FactorService;
//import com.dasoops.dasq.core.dq.service.MutationService;
//import com.dasoops.dasq.core.image.entity.po.ImageInfo;
//import com.dasoops.dasq.core.image.service.ImageInfoService;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@SpringBootTest
//public class Test {
//
//    @Resource
//    private MutationService mutationService;
//    @Resource
//    private DictionaryService dictionaryService;
//    @Resource
//    private FactorService factorService;
//    @Resource
//    private ImageInfoService imageInfoService;
//
//    @org.junit.jupiter.api.Test
//    public void test() {
//
//        String str = "时间扭曲aaaaa地图上会周期性地部署敌人的时间扭曲。aaaaa1\n" +
//                "闪避机动aaaaa敌方单位受到伤害时将传送一小段距离。aaaaa1\n" +
//                "短视症aaaaa玩家单位及其建筑的视野范围缩短。aaaaa1\n" +
//                "震荡攻击aaaaa玩家单位会被所有敌方攻击减速。aaaaa1\n" +
//                "时空力场aaaaa地图上会周期性地部署敌人的时空力场。aaaaa1\n" +
//                "轨道轰炸aaaaa敌人会在地图上周期性地施放轨道轰炸。aaaaa1\n" +
//                "光子过载aaaaa所有敌方建筑会攻击附近的敌对单位。aaaaa1\n" +
//                "生命吸取aaaaa敌方单位和建筑在造成伤害时偷取生命值或护盾。aaaaa1\n" +
//                "强行征用aaaaa敌人摧毁你的建筑后将获得建筑的控制权。aaaaa1\n" +
//                "行尸走肉aaaaa敌方单位在死亡时生成大量的被感染的人类，具体数量由死亡单位的生命值决定。aaaaa2\n" +
//                "暗无天日aaaaa先前探索过的区域若离开了玩家的视野范围将会重新变成一片黑色。aaaaa2\n" +
//                "速度狂魔aaaaa敌方单位移动速度提高。aaaaa2\n" +
//                "晶矿护盾aaaaa玩家基地中的晶体矿簇会被周期性包覆一层护盾，必须将其摧毁才能继续采集资源。aaaaa2\n" +
//                "减伤屏障aaaaa敌方单位和建筑在第一次受到伤害时会获得一个临时护盾。aaaaa2\n" +
//                "焦土政策aaaaa敌方单位死亡时会点燃地面。aaaaa2\n" +
//                "异形寄生aaaaa所有敌方单位在死亡时会孵化巢虫。aaaaa2\n" +
//                "激光钻机aaaaa一台敌方激光钻机会不停地攻击位于敌人视野范围内的玩家单位。aaaaa2\n" +
//                "超远视距aaaaa敌方单位和建筑的武器射程与视野范围提高。aaaaa2\n" +
//                "龙卷风暴aaaaa多股龙卷风在地图上移动，对位于其行进路线上的玩家单位造成伤害并将其击退。aaaaa2\n" +
//                "净化光束aaaaa地图上会出现一道敌人的净化光束并朝附近的玩家单位移动。aaaaa2\n" +
//                "鼓舞人心aaaaa敌方英雄单位提高小范围内所有敌人的攻击速度和护甲。aaaaa2\n" +
//                "坚强意志aaaaa敌方英雄单位附近有任何非英雄敌方单位时，其所受到的伤害最高不超过10点。aaaaa2\n" +
//                "默哀aaaaa敌方英雄单位死亡时，在其周围的所有玩家单位都会反思自己的过错，无法攻击或使用技能。aaaaa2\n" +
//                "丧尸大战aaaaa敌方被感染的人类会不断地出现在地图上。aaaaa3\n" +
//                "岩浆爆发aaaaa岩浆会周期性地在随机位置从地下喷发，并对玩家的空中和地面单位造成伤害。aaaaa3\n" +
//                "自毁程序aaaaa敌方单位死亡时发生爆炸，并对附近的玩家单位造成伤害。aaaaa3\n" +
//                "进攻部署aaaaa周期性地将额外的敌方单位部署到战场上。aaaaa3\n" +
//                "来去无踪aaaaa所有敌方单位永久隐形。aaaaa3\n" +
//                "无边恐惧aaaaa玩家的单位在受到伤害时会不时地停止攻击，并且害怕地到处乱跑。aaaaa3\n" +
//                "核弹打击aaaaa核弹会随机在整张地图上进行发射。aaaaa3\n" +
//                "飞弹大战aaaaa你的建筑会不停地遭受飞弹轰炸的袭击，你必须将它们击落。aaaaa3\n" +
//                "伤害散射aaaaa对敌人造成的伤害将平摊给所有附近的单位，包括你的单位。aaaaa3\n" +
//                "双重压力aaaaa你的单位也会受到他们自身造成的所有伤害，但是会持续恢复。aaaaa3\n" +
//                "致命勾引aaaaa敌方单位或建筑被摧毁后，你附近的任何单位将被牵拉至被它们的位置。aaaaa3\n" +
//                "强磁雷场aaaaa麦格天雷会在任务一开始布满整个地图。aaaaa4\n" +
//                "暴风雪aaaaa风暴雷云在地图上飘荡，对位于其行进路线上的玩家单位造成伤害并将其冻结。aaaaa4\n" +
//                "复仇战士aaaaa当附近的敌方单位死亡时，敌方单位的攻击速度、移动速度、护甲、生命值以及生命回复速度提高。aaaaa5\n" +
//                "相互摧毁aaaaa敌方混合体死亡时会引爆一发核弹。aaaaa5\n" +
//                "小捞油水aaaaa玩家的工人单位采集资源的效率降低，但是地图上会生成可以拾取的资源。aaaaa5\n" +
//                "虚空重生者aaaaa虚空重生者游荡在战场上，不断地复活你的敌人。aaaaa5\n" +
//                "灵能爆表aaaaa所有敌方单位拥有能量并且使用随机技能。aaaaa5\n" +
//                "拿钱说话aaaaa对你的单位发出指令会消耗资源，数量取决于该单位的生产价格。aaaaa5\n" +
//                "扫雷专家aaaaa数量庞大的寡妇雷和蜘蛛雷遍布整个战场。aaaaa6\n" +
//                "杀戮机器人aaaaa来源不明的进攻性机器人已被释放到了科普卢星区，意图制造毁灭。经过用心险恶的工程改造后，它们在达到预先设定的击杀数量之前都是无敌的存在。只有在那之后，它们才能被阻止。不过，你能撑到最后吗？aaaaa6\n" +
//                "给我死吧aaaaa敌方单位死亡后会自动复活。aaaaa7\n" +
//                "极性不定aaaaa每一个敌方单位不是对你的单位免疫，就是对你盟友的单位免疫。aaaaa7\n" +
//                "力量蜕变aaaaa敌方单位造成伤害时有一定几率变形成更强大的单位。aaaaa7\n" +
//                "黑死病aaaaa一些敌方单位携带着一种疫病，不仅会持续造成伤害，还会传染给附近的其它单位。此类敌人被消灭时，他们会把这种疫病传染给你的单位。aaaaa7\n" +
//                "同化体aaaaa无形的软泥怪缓慢爬向你的基地，被其接触到的任何单位和建筑都将变成和它们一样的复制体。aaaaa8\n" +
//                "虚空裂隙aaaaa虚空裂隙周期性地出现在随机位置，并会不断地生成敌方单位，直至其被摧毁。aaaaa10\n" +
//                "风暴英雄aaaaa每一轮攻击波次都会由实力越来越强的英雄率领。aaaaa10\n" +
//                "上班偷睡aaaaa玩家的工人单位会周期性地陷入沉睡，必须使用命令面板上的“苏醒”技能才能将其唤醒。aaaaa-\n" +
//                "石像狂热者aaaaa敌人已部署石像狂热者。aaaaa-\n" +
//                "混乱工作室aaaaa突变因子会随机选择，并且在任务中周期性轮换。aaaaa-\n" +
//                "迷失方向aaaaa你的镜头会随机改变位置。aaaaa-\n" +
//                "不死邪魔aaaaa有只怪物缠上你了，而且你杀它的次数越多，你下一次遇到的它越强大。aaaaa-\n" +
//                "惧怕黑暗aaaaa通过各种方式提供的视野都会受到极大的限制，只有你镜头中的视野一切正常。aaaaa-\n" +
//                "不给糖果就捣蛋aaaaa平民们会拜访你的糖果碗寻找零食，这些零食是通过花费晶体矿产生的。如果没有零食可以享用，平民们就会变身成随机的敌方单位。aaaaa-\n" +
//                "捕杀火鸡aaaaa补给只能通过击杀火鸡产生，它们在整个地图上漫游。这么做可能会激怒其它的火鸡。aaaaa-\n" +
//                "补给共享aaaaa你和你的搭档共享补给，双方的部队单位会占用你们共有的补给。aaaaa-\n" +
//                "礼尚往来aaaaa地图上会周期性地放置一些礼物。你们不抢就会便宜了埃蒙哟！aaaaa-\n" +
//                "杀生业报aaaaa玩家的单位和建筑每消灭一个敌人，其所受到的伤害就会提高。aaaaa-\n" +
//                "极度谨慎aaaaa你的单位不会接受你在他们看不见的地方所下达的任何命令。aaaaa-\n" +
//                "刺头兵aaaaa你的单位不会准确地执行命令。aaaaa-\n" +
//                "焰火秀aaaaa敌人死亡时会发射灿烂的烟花，对你周围的单位造成伤害。aaaaa-\n" +
//                "幸运红包aaaaa塞满物资的节日红包，被随机丢弃在地图的各个角落。aaaaa-\n" +
//                "消极战斗aaaaa你的单位先加速，然后再减速。aaaaa-\n" +
//                "炸弹机器人aaaaa对一切都毫不在意的机器人携带着聚变弹头朝你的基地进发。一名玩家必须识别出拆弹的顺序，另一名玩家则必须正确输入才能解除危机。aaaaa-";
//
//
//        List<ImageInfo> list1 = imageInfoService.list();
//        Map<String, String> collect1 = list1.stream().collect(Collectors.toMap(ImageInfo::getKeyword, ImageInfo::getFileName));
//
//
//        List<String> list = StrUtil.split(str, "\n");
//        List<Factor> collect = list.stream().map(res -> {
//            List<String> aList = StrUtil.split(res, "aaaaa").stream().map(res2 -> res2.replace("aaaaa", "")).collect(Collectors.toList());
//
//            Factor factor = new Factor();
//            Integer integer = 0;
//            try {
//                integer = Integer.valueOf(aList.get(2));
//            } catch (NumberFormatException e) {
//
//            }
//            factor.setScore(integer);
//            factor.setDescription(aList.get(1));
//            factor.setName(aList.get(0));
//            factor.setCreateTime(new Date());
//            factor.setUpdateTime(new Date());
//            factor.setCreateUser("Das");
//            factor.setUpdateUser("Das");
//            factor.setIsDelete("0");
//            factor.setImageFileName(collect1.get(aList.get(0)));
//            if (collect1.get(aList.get(0))==null){
//                System.out.println(aList.get(0));
//            }
//            return factor;
//        }).collect(Collectors.toList());
//
//        factorService.saveBatch(collect);
//
//    }
//
//}
