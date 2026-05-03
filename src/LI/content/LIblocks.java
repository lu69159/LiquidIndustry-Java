package LI.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class LIblocks {
    public static Block
    //单位
    BCJDWZGGC,DMJDWZGGC,WLJDWZGGC,FZGC,GZQ,DXZHCSD,

    //电力
    CDJD,DXCDJD,CDDLT,CDDC,DXCDDC,TFDJ,HWKZRFDJ,HWSBRFDJ,ZSHFYD,SBFYD,BRFYL,

    //辅助
    ZXZMQ,DXZMQ,RZTY,YJLD,CSTQ,LTFPLC,LTTSLC,CPTY,BHTY,JDTY,ZTQD,SYTQ,RHTY,MBTY,HSTY,RHQD,
    MBQD,HSQD,

    //核心
    WXHXJZ,SDHX,LTHX,

    //炮塔
    DCFB,TFP,DLY,DL,JK,PF,MF,BP,ZBPT,

    //墙
    JDQT,ZJCYG,DXZJCYG,SGZJCYG,DXSGZJCYG,HJZJCYG,DXHJZJCYG,XZZJCYG,DXXZZJCYG,CNQ,DXCNQ,JXCNQ,LCQ,

    //生产
    BLFYFLJ,YJFYJLJ,EJFYJLQ,SJJHZHQ,SJJHZHY,JHNSC,FYLXJ,FYHHQ,ZJLGL,JHTQGC,SNPSJ,JNZJLL,QSZHCQ,ZYZYSJ,
    CDLJQ,GL,DXFSJ,MFSJ,LDYJBJ,CLHHQ,ZSSCQ,GL2,SGFJQ,XZBFJQ,JLHJFJQ,GYZHQ,JTRZQ,

    //物流
    TCSD,ZJCSGD,XZBXZQ,GYFSQ,WXZQ,

    //液流
    JXCYG,TDGQ,ZKB,YTZQ,WXYTZQ,

    //钻头
    WXCSJ,QXCSJ,DXCSJ,LDYCQJ,FYCQJ,BLZJ,YZSYZJ

    ;

    public static void load(){
        //region 单位
        BCJDWZGGC = new Reconstructor("倍乘级单位直构工厂"){{
            requirements(Category.units, with(Items.lead, 600, Items.titanium, 300, Items.thorium, 200, Items.silicon, 400, LIitems.ZYZ, 75));
            health = 1200;
            size = 5;
            consumePower(6f);
            consumeItems(with(Items.silicon, 130, LIitems.ZYZ, 30));
            upgrades.addAll(
                new UnitType[]{UnitTypes.dagger, UnitTypes.fortress},
                new UnitType[]{UnitTypes.nova, UnitTypes.quasar},
                new UnitType[]{UnitTypes.crawler, UnitTypes.spiroct},
                new UnitType[]{UnitTypes.flare, UnitTypes.zenith},
                new UnitType[]{UnitTypes.mono, UnitTypes.mega},
                new UnitType[]{UnitTypes.risso, UnitTypes.bryde},
                new UnitType[]{UnitTypes.retusa, UnitTypes.cyerce},
                new UnitType[]{LIunits.SM, LIunits.HL}
            );
            constructTime = 1800f;
        }};
        DMJDWZGGC = new Reconstructor("多幂级单位直构工厂"){{
            requirements(Category.units, with(Items.lead, 1800, Items.titanium, 1800, Items.thorium, 350, Items.silicon, 800, Items.plastanium, 450, Items.phaseFabric, 300, LIitems.ZYZ, 375));
            health = 3035;
            size = 7;
            liquidCapacity = 60f;
            consumePower(13f);
            consumeItems(with(Items.silicon, 850, LIitems.ZYZ, 350));
            consumeLiquid(Liquids.cryofluid, 1f);
            upgrades.addAll(
                new UnitType[]{UnitTypes.dagger, UnitTypes.scepter},
                new UnitType[]{UnitTypes.nova, UnitTypes.vela},
                new UnitType[]{UnitTypes.crawler, UnitTypes.arkyid},
                new UnitType[]{UnitTypes.flare, UnitTypes.antumbra},
                new UnitType[]{UnitTypes.mono, UnitTypes.quad},
                new UnitType[]{UnitTypes.risso, UnitTypes.sei},
                new UnitType[]{UnitTypes.retusa, UnitTypes.aegires},
                new UnitType[]{LIunits.SM, LIunits.DY}
            );
            constructTime = 5400f;
        }};
        WLJDWZGGC = new Reconstructor("多幂级单位直构工厂"){{
            requirements(Category.units, with(Items.lead, 4000, Items.thorium, 500, Items.silicon, 3000, Items.plastanium, 600, Items.phaseFabric, 325, Items.surgeAlloy, 800, LIitems.ZYZ, 400));
            health = 5830;
            size = 9;
            liquidCapacity = 180f;
            consumePower(25f);
            consumeItems(with(Items.silicon, 1000, LIitems.ZYZ, 630));
            consumeLiquid(Liquids.cryofluid, 3f);
            upgrades.addAll(
                new UnitType[]{UnitTypes.dagger, UnitTypes.reign},
                new UnitType[]{UnitTypes.nova, UnitTypes.corvus},
                new UnitType[]{UnitTypes.crawler, UnitTypes.toxopid},
                new UnitType[]{UnitTypes.flare, UnitTypes.eclipse},
                new UnitType[]{UnitTypes.mono, UnitTypes.oct},
                new UnitType[]{UnitTypes.risso, UnitTypes.omura},
                new UnitType[]{UnitTypes.retusa, UnitTypes.navanax},
                new UnitType[]{LIunits.SM, LIunits.JX}
            );
            constructTime = 14400f;
        }};
        FZGC = new UnitFactory("辅助工厂"){{
            requirements(Category.units, with(Items.copper, 60, Items.lead, 80, Items.plastanium, 15));
            health = 540;
            size = 3;
            consumePower(3f);
            plans = Seq.with(
                new UnitPlan(LIunits.ZLQ, 60f * 30, with(Items.silicon, 15, LIitems.ZYZ, 1)),
                new UnitPlan(LIunits.XFQ, 60f * 30, with(Items.silicon, 10, Items.phaseFabric, 2)),
                new UnitPlan(LIunits.JZQ, 60f * 30, with(Items.silicon, 40)),
                new UnitPlan(LIunits.ZTQ, 60f * 30, with(Items.silicon, 5, LIitems.QSZ, 3, LIitems.ZYZ, 1))
            );
        }};
        GZQ = new Constructor("构筑器"){{
            requirements(Category.units, with(Items.thorium, 80, Items.silicon, 150, Items.plastanium, 15));
            health = 800;
            size = 5;
            buildSpeed = 2f;
            hasPower = true;
            minBlockSize = 2;
            maxBlockSize = 5;
            consumePower(4f);
        }};
        DXZHCSD = new PayloadConveyor("大型载荷传送带"){{
            requirements(Category.units, with(Items.copper, 30, Items.graphite, 30));
            health = 800;
            size = 5;
            canOverdrive = false;
        }};

        //region 电力
        CDJD = new PowerNode("超导节点"){{
            requirements(Category.power, with(Items.titanium, 1, Items.lead, 2, LIitems.CDZ, 1));
            health = 120;
            maxNodes = 18;
            laserRange = 20;
            underBullets = true;
            crushFragile = true;
        }};
        DXCDJD = new PowerNode("大型超导节点"){{
            requirements(Category.power, with(Items.titanium, 4, Items.silicon, 5, LIitems.CDZ, 2));
            health = 480;
            size = 2;
            maxNodes = 30;
            laserRange = 45;
        }};
        CDDLT = new PowerNode("超导电力塔"){{
            requirements(Category.power, with(Items.titanium, 8, Items.silicon, 5, Items.surgeAlloy, 3, LIitems.CDZ, 5));
            health = 600;
            size = 2;
            maxNodes = 5;
            laserRange = 120;
            schematicPriority = -15;
        }};
        CDDC = new Battery("超导电池"){{
            requirements(Category.power, with(Items.titanium, 5, Items.lead, 5, LIitems.CDZ, 1));
            health = 120;
            consumePowerBuffered(20000f);
            baseExplosiveness = 3f;
            emptyLightColor = Color.valueOf("00A9A9");
            fullLightColor =  Color.valueOf("00FFFF");
        }};
        DXCDDC = new Battery("超导电池"){{
            requirements(Category.power, with(Items.titanium, 30, Items.lead, 50, Items.silicon, 30, LIitems.CDZ, 5));
            health = 1080;
            size = 3;
            consumePowerBuffered(250000f);
            baseExplosiveness = 15f;
            emptyLightColor = Color.valueOf("00A9A9");
            fullLightColor =  Color.valueOf("00FFFF");
        }};
        TFDJ = new ConsumeGenerator("碳发电机"){{
            requirements(Category.power, with(Items.copper, 4, Items.lead, 30));
            health = 120;
            size = 2;
            powerProduction = 3f;
            itemDuration = 60 * 7.5f;
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.04f;
            generateEffect = Fx.generatespark;

            consumeItem(Items.graphite);
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
        }};
    }
}
