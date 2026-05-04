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

import LI.type.blocks.power.*;
import LI.type.blocks.defense.*;

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
        HWKZRFDJ = new ConsumeGenerator("恒温矿渣热发电机"){{
            requirements(Category.power, with(Items.copper, 90, Items.lead, 100, Items.metaglass, 60, Items.graphite, 45, Items.silicon, 45, LIitems.HWKZJT, 4));
            health = 300;
            size = 3;
            itemCapacity = 0;
            powerProduction = 6.12f;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;
            generateEffect = Fx.redgeneratespark;
            effectChance = 0.011f;
            explosionPuddles = 12;
            explosionPuddleLiquid = Liquids.slag;
            explosionPuddleAmount = 150;
        }};
        HWSBRFDJ = new ConsumeGenerator("恒温衰变热发电机"){{
            requirements(Category.power, with(Items.copper, 90, Items.lead, 100, Items.metaglass, 60, Items.graphite, 45, Items.silicon, 45, LIitems.HWSBJT, 4));
            health = 300;
            size = 3;
            itemCapacity = 0;
            powerProduction = 21.6f;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;
            generateEffect = Fx.redgeneratespark;
            effectChance = 0.011f;
            explosionDamage = 2000;
            explosionPuddles = 12;
            explosionPuddleLiquid = LIliquids.SBRY;
            explosionPuddleAmount = 150;
        }};
        ZSHFYD = new ModerateNuclearReactor("重水核反应堆"){{
            requirements(Category.power, with(Items.lead, 400, Items.metaglass, 80, Items.graphite, 200, Items.thorium, 150, Items.silicon, 300, LIitems.GTZS, 1));
            health = 1000;
            size = 4;
            itemDuration = 480f;
            powerProduction = 52.5f;
            heating = 0.05f;
            heatOutput = 20f;

            ambientSound = Sounds.loopThoriumReactor;
            ambientSoundVolume = 0.11f;

            moderator = LIliquids.ZS;
            coolant = Liquids.cryofluid;

            consumeItem(Items.thorium);
            consumeLiquid(moderator, 1.8f/60);
        }};
        SBFYD = new ModerateNuclearReactor("衰变反应堆"){{
            requirements(Category.power, with(Items.lead, 1500, Items.metaglass, 1080, Items.graphite, 720, Items.silicon, 350, Items.surgeAlloy, 300, Items.plastanium, 210, LIitems.NRJT, 15));
            health = 1600;
            size = 5;
            itemDuration = 90f;
            powerProduction = 360f;
            heating = 0.125f;
            heatOutput = 30f;
            fuelItem = Items.phaseFabric;

            outputLiquid = new LiquidStack(LIliquids.SBRY, 6f / 60);
            explodeOnFull = true;

            ambientSound = Sounds.loopPulse;
            ambientSoundVolume = 0.11f;

            consumeItem(Items.phaseFabric);
            consumeLiquid(moderator, 3f/60);

            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawLiquidRegion(LIliquids.SBRY),
                    new DrawArcSmelt(){{
                        flameColor = Color.valueOf("00FFFF");
                        midColor = Color.valueOf("ADFCB6");
                        flameRad = 3f;
                        circleSpace = 3f;
                        particles = 20;
                        particleRad = 12f;
                        particleLen = 5f;
                        particleStroke = 0.5f;
                        particleLife = 30f;
                        alpha = 0.5f;
                    }},
                    new DrawPlasma(){{
                        plasma1 = Color.valueOf("00A9A9");
                        plasma2 = Color.valueOf("008282");
                        flameRadiusScl = 0.5f;
                    }},
                    new DrawDefault()
            );
        }};
        BRFYL = new OutputsItemNuclearReactor("爆燃反应炉"){{
            requirements(Category.power, with(Items.lead, 1800, Items.metaglass, 880, Items.graphite, 360, Items.titanium, 420, Items.silicon, 550, Items.plastanium, 320, LIitems.CDZ, 30, LIitems.GTCJLDY, 4));
            health = 2800;
            size = 5;
            itemDuration = 30f;
            powerProduction = 833.3f;
            heating = 0.06f;
            coolantPower = 1.5f;
            lightColor = Color.valueOf("FFEEEE");
            fuelItem = LIitems.GTSY;

            explosionPuddles = 256;
            explosionPuddleLiquid = Liquids.oil;
            explosionPuddleAmount = 650;
            explosionPuddleRange = 80;
            explosionMinWarmup = 0.25f;
            explosionShake = 12f;
            explosionShakeDuration = 240f;
            explosionRadius = 64;
            explosionDamage = 28500;
            explodeSound = Sounds.explosionReactorNeoplasm;
            explodeEffect = LIfx.deflagExplosion;
        }};

        //region 辅助
        ZXZMQ = new LightBlock("中型照明器"){{
            requirements(Category.effect, with(Items.graphite, 24, Items.silicon, 15, Items.lead, 12));
            health = 120;
            size = 2;
            brightness = 0.8f;
            radius = 320f;
            canOverdrive = false;
            consumePower(0.25f);
        }};
        DXZMQ = new LightBlock("大型照明器"){{
            requirements(Category.effect, with(Items.graphite, 24, Items.silicon, 15, Items.titanium, 12));
            health = 400;
            size = 3;
            brightness = 0.83f;
            radius = 560f;
            canOverdrive = false;
            consumePower(0.6f);
        }};
        RZTY = new LightBlock("人造太阳"){{
            requirements(Category.effect, with(Items.graphite, 68, Items.silicon, 42, Items.plastanium, 12, Items.phaseFabric, 6));
            health = 840;
            size = 4;
            brightness = 0.99f;
            radius = 8000f;
            canOverdrive = false;
            consumePower(1.8f);
        }};
        YJLD = new Radar("预警雷达"){{
            requirements(Category.effect, BuildVisibility.fogOnly, with(Items.graphite, 24, Items.silicon, 15, Items.metaglass, 12));
            glowColor = Color.valueOf("FFFFFF60");
            fogRadius = 70;
            discoveryTime = 180f;

            consumePower(1f);
        }};
        CSTQ = new OverdriveProjector("超速天穹");
    }
}
