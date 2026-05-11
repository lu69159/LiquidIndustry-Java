package LI.content;

import arc.Core;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import LI.type.blocks.power.*;
import LI.type.blocks.defense.walls.*;
import LI.type.blocks.effect.*;
import LI.type.blocks.storage.*;
import LI.type.blocks.distribution.itemLiquid.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class LIblocks {
    /** 部分方块还未搬入JAVA：力场墙。液体质驱类。所有炮塔，生产类。 */
    public static Block
    //地板
    JHXQ,

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
    //DCFB,TFP,DLY,DL,JK,PF,MF,BP,ZBPT,

    //墙
    JDQT,ZJCYG,DXZJCYG,SGZJCYG,DXSGZJCYG,HJZJCYG,DXHJZJCYG,XZZJCYG,DXXZZJCYG,CNQ,DXCNQ,JXCNQ, //LCQ,

    //生产
    /*
    BLFYFLJ,YJFYJLJ,EJFYJLQ,SJJHZHQ,SJJHZHY,JHNSC,FYLXJ,FYHHQ,ZJLGL,JHTQGC,SNPSJ,JNZJLL,QSZHCQ,ZYZYSJ,
    CDLJQ,GL,DXFSJ,MFSJ,LDYJBJ,CLHHQ,ZSSCQ,GL2,SGFJQ,XZBFJQ,JLHJFJQ,GYZHQ,JTRZQ,

    */

    //物流
    SCD,SCQ,SCLYQ,SCJCQ,TCSD,ZJCSGD,XZBXZQ,GYFSQ,WXZQ,

    //液流
    JXCYG,TDGQ,ZKB, //YTZQ,WXYTZQ,

    //钻头
    WXCSJ,QXCSJ,DXCSJ,LDYCQJ,FYCQJ,BLZJ,YZSYZJ

    ;

    public static void load(){
        //region 地板
        JHXQ = new Floor("禁核心区"){{
            variants = 0;
        }};
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
        WLJDWZGGC = new Reconstructor("无量级单位直构工厂"){{
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
        DXCDDC = new Battery("大型超导电池"){{
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
        CSTQ = new OverdriveProjector("超速天穹"){{
            requirements(Category.effect, with(Items.lead, 350, Items.graphite, 50, Items.titanium, 180, Items.silicon, 180, Items.plastanium, 130, Items.surgeAlloy, 150, Items.phaseFabric, 40));
            health = 865;
            size = 4;
            range = 240f;
            speedBoost = 2.5f;
            speedBoostPhase = 0.5f;
            phaseRangeBoost = 80f;
            useTime = 300f;
            ambientSoundVolume = 0.15f;
            consumePower(14f);
            consumeLiquid(Liquids.cryofluid, 12f / 60f);
            consumeItem(Items.phaseFabric).boost();
        }};
        LTFPLC = new LiquidProjector("流体分配力场"){{
            requirements(Category.liquid, with(Items.metaglass, 125, Items.plastanium, 40, LIitems.QSZ, 3));
            health = 300;
            size = 2;
            consumePower(2f);
            consumeItem(LIitems.QSZ).boost();
        }};
        LTTSLC = new LiquidProjector("流体投射力场"){{
            requirements(Category.liquid, with(Items.metaglass, 175, Items.plastanium, 50, LIitems.QSZ, 3, LIitems.GTS, 1));
            health = 500;
            size = 3;
            liquidCapacity = 1200f;
            boostRange = 120f;
            useTime = 720f;
            reload = 5f;
            consumePower(5.5f);
            consumeItem(LIitems.QSZ).boost();
        }};
        CPTY = new StatusProjector("超频投影", StatusEffects.overclock){{
            requirements(Category.effect, with(Items.lead, 100, Items.graphite, 75, Items.silicon, 40, Items.thorium, 15));
            health = 260;
            size = 2;
            consumePower(2f);
        }};
        BHTY = new StatusProjector("保护投影", StatusEffects.shielded){{
            requirements(Category.effect, with(Items.lead, 100, Items.graphite, 75, Items.silicon, 40, Items.phaseFabric, 5));
            health = 260;
            size = 2;
            consumePower(2f);
        }};
        JDTY = new StatusProjector("解冻投影", LIstatus.JD){{
            requirements(Category.effect, with(Items.lead, 100, Items.graphite, 75, Items.silicon, 40, LIitems.GTLDY, 1));
            health = 260;
            size = 2;
            range = 80f;
            consumePower(1.5f);
            consumeLiquid(Liquids.cryofluid, 3f / 60f);
        }};
        ZTQD = new StatusProjector("状态穹顶", Seq.with(StatusEffects.overclock, StatusEffects.shielded, StatusEffects.fast)){{
            requirements(Category.effect, with(Items.lead, 220, Items.graphite, 165, Items.silicon, 100, Items.phaseFabric, 25, LIitems.NRJT, 1));
            health = 680;
            size = 3;
            range = 200f;
            useTime = 1200f;
            reload = 180f;
            consumePower(8f);
            consumeLiquid(Liquids.cryofluid, 21f / 60f);
        }};
        SYTQ = new StatusProjector("神佑天穹", LIstatus.SY){{
            requirements(Category.effect, with(Items.lead, 350, Items.titanium, 180, Items.silicon, 180, Items.plastanium, 130, Items.surgeAlloy, 150, LIitems.NRJT, 10, LIitems.SMSP, 5));
            health = 1260;
            size = 4;
            range = 240f;
            reload = 300f;
            consumePower(8.5f);
            consumeLiquid(LIliquids.FY5, 3f / 60f);
        }};
        RHTY = new StatusProjector("弱化投影", StatusEffects.sapped){{
            requirements(Category.effect, with(Items.lead, 100, Items.coal, 85, Items.silicon, 40, Items.thorium, 10));
            health = 280;
            size = 2;
            range = 160f;
            useTime = 600f;
            reload = 600f;
            applyOnEnemies = true;
            consumePower(3f);
        }};
        MBTY = new StatusProjector("麻痹投影", StatusEffects.electrified){{
            requirements(Category.effect, with(Items.lead, 100, Items.plastanium, 25, Items.silicon, 40, Items.thorium, 10));
            health = 280;
            size = 2;
            range = 160f;
            useTime = 600f;
            reload = 600f;
            applyOnEnemies = true;
            consumePower(3f);
        }};
        HSTY = new StatusProjector("缓速投影", StatusEffects.slow){{
            requirements(Category.effect, with(Items.lead, 100, Items.scrap, 165, Items.silicon, 40, Items.thorium, 10));
            health = 280;
            size = 2;
            range = 160f;
            useTime = 600f;
            reload = 600f;
            applyOnEnemies = true;
            consumePower(3f);
        }};
        RHQD = new StatusProjector("弱化穹顶", StatusEffects.sapped){{
            requirements(Category.effect, with(Items.lead, 220, Items.coal, 250, Items.silicon, 120,Items.phaseFabric, 55, Items.surgeAlloy, 105));
            health = 780;
            size = 3;
            range = 360f;
            useTime = 720f;
            reload = 300f;
            applyOnEnemies = true;
            consumePower(12f);
            consumeLiquid(Liquids.oil, 12f / 60f);
        }};
        MBQD = new StatusProjector("麻痹穹顶", StatusEffects.electrified){{
            requirements(Category.effect, with(Items.lead, 220, Items.plastanium, 125, Items.silicon, 120,Items.phaseFabric, 55, Items.surgeAlloy, 105));
            health = 780;
            size = 3;
            range = 360f;
            useTime = 720f;
            reload = 300f;
            applyOnEnemies = true;
            consumePower(12f);
            consumeLiquid(LIliquids.ZS, 15f / 60f);
        }};
        HSQD = new StatusProjector("缓速穹顶", StatusEffects.slow){{
            requirements(Category.effect, with(Items.lead, 220, Items.scrap, 425, Items.silicon, 120,Items.phaseFabric, 55, Items.surgeAlloy, 105));
            health = 780;
            size = 3;
            range = 360f;
            useTime = 720f;
            reload = 300f;
            applyOnEnemies = true;
            consumePower(12f);
            consumeLiquid(LIliquids.FY0, 30f / 60f);
        }};

        //region 核心
        WXHXJZ = new CoreBlock("微型核心基座"){{
            requirements(Category.effect, with(Items.copper, 125, Items.lead, 100));
            health = 140;
            itemCapacity = 0;
            unitCapModifier = 0;

            unitType = LIunits.JS;
        }
            @Override
            public boolean canBreak(Tile tile) {
                return state.teams.cores(tile.team()).size > 1;
            }

            @Override
            public boolean canReplace(Block other) {
                return other.alwaysReplace;
            }

            @Override
            public boolean canPlaceOn(Tile tile, Team team, int rotation){
                if(tile == null || tile.floor() == JHXQ) return false;
                return state.teams.cores(team).size < 12;
            }

            @Override
            public void drawPlace(int x, int y, int rotation, boolean valid) {
                if(world.tile(x, y) == null) return;

                if ((player.team().core() != null && !player.team().core().items.has(this.requirements, state.rules.buildCostMultiplier)) && !state.rules.infiniteResources) {
                    drawPlaceText(Core.bundle.get("bar.noresources"), x, y, false);
                    return;
                }
                if(!(state.teams.cores(player.team()).size < 12)){
                    drawPlaceText(Core.bundle.get("maxcores"), x, y, valid);
                }
            }
        };
        SDHX = new PowerCore("闪电核心"){{
            requirements(Category.effect, with(Items.copper, 12000, Items.lead, 12000, Items.titanium, 8000, Items.thorium, 4000, Items.silicon, 7000, Items.plastanium, 500, Items.surgeAlloy, 1500));
            health = 8000;
            armor = 10;
            size = 5;
            itemCapacity = 18000;
            unitCapModifier = 36;
            researchCostMultiplier = 0.4f;
            thrusterLength = 40/4f;

            unitType = LIunits.GMS;
        }};
        LTHX = new PowerCore("雷霆核心"){{
            requirements(Category.effect, with(Items.copper, 18000, Items.lead, 18000, Items.titanium, 10000, Items.thorium, 6000, Items.silicon, 8000, Items.plastanium, 100, Items.surgeAlloy, 2000, LIitems.CDZ, 100));
            health = 15600;
            size = 7;
            itemCapacity = 24000;
            unitCapModifier = 48;
            researchCostMultiplier = 0.4f;
            thrusterLength = 50/4f;

            damage = 20f;
            range = 36f;
            reload = 20f;
            powerout = 800f;

            unitType = LIunits.DET;
        }};

        //region 炮塔
        /* 弹药部分需要搬过来的内容很多，后面再说... */


        //region 墙
        JDQT = new Wall("基地墙体"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with());
            health = 5000;
            size = 2;
        }};
        ZJCYG = new WallLiquidRouter("装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 8, Items.titanium, 6, LIitems.QSZ, 1));
            health = 520;
            liquidCapacity = 400f;
        }};
        DXZJCYG = new WallLiquidRouter("大型装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 32, Items.titanium, 24, LIitems.QSZ, 4));
            health = 520 * 4;
            size = 2;
            liquidCapacity = 400f * 4;
        }};
        SGZJCYG = new WallLiquidRouter("塑钢装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 8, Items.titanium, 6, Items.plastanium, 5, LIitems.QSZ, 1));
            health = 640;
            armor = 5;
            liquidCapacity = 500f;

            absorbLasers = true;
            insulated = true;
        }};
        DXSGZJCYG = new WallLiquidRouter("大型塑钢装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 32, Items.titanium, 24, Items.plastanium, 20, LIitems.QSZ, 4));
            health = 640 * 4;
            armor = 5;
            size = 2;
            liquidCapacity = 500f * 4;

            absorbLasers = true;
            insulated = true;
        }};
        HJZJCYG = new WallLiquidRouter("合金装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 8, Items.titanium, 6, Items.surgeAlloy, 6, LIitems.QSZ, 1));
            health = 1100;
            armor = 10;
            liquidCapacity = 500f;

            lightningChance = 0.05f;
            lightningLength = 25;
            lightningDamage = 30f;
        }};
        DXHJZJCYG = new WallLiquidRouter("大型合金装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 32, Items.titanium, 24, Items.surgeAlloy, 24, LIitems.QSZ, 4));
            health = 1100 * 4;
            armor = 10;
            size = 2;
            liquidCapacity = 500f * 4;

            lightningChance = 0.05f;
            lightningLength = 25;
            lightningDamage = 30f;
        }};
        XZZJCYG = new WallLiquidRouter("相织装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 8, Items.phaseFabric, 6, LIitems.QSZ, 1));
            health = 840;
            armor = 5;
            liquidCapacity = 500f;

            chanceDeflect = 20f;
        }};
        DXXZZJCYG = new WallLiquidRouter("大型相织装甲储液罐"){{
            requirements(Category.defense, with(Items.metaglass, 32, Items.phaseFabric, 24, LIitems.QSZ, 4));
            health = 840 * 4;
            armor = 5;
            liquidCapacity = 500 * 4f;

            chanceDeflect = 20f;
        }};
        CNQ = new WallLiquidRouter("超能墙"){{
            requirements(Category.defense, with(Items.metaglass, 12, Items.titanium, 18, Items.surgeAlloy, 6, Items.phaseFabric, 6, Items.phaseFabric, 5, LIitems.QSZ, 3));
            health = 2800;
            armor = 30;
            liquidCapacity = 1200f;

            absorbLasers = true;
            insulated = true;
            placeableLiquid = true;
            lightningChance = 0.2f;
            lightningLength = 30;
            lightningDamage = 50f;
            chanceDeflect = 40f;
        }};
        DXCNQ = new WallLiquidRouter("大型超能墙"){{
            requirements(Category.defense, with(Items.metaglass, 48, Items.titanium, 72, Items.surgeAlloy, 24, Items.phaseFabric, 24, Items.phaseFabric, 20, LIitems.QSZ, 12));
            health = 2800 * 4;
            armor = 30;
            size = 2;
            liquidCapacity = 1200f * 4;

            absorbLasers = true;
            insulated = true;
            placeableLiquid = true;
            lightningChance = 0.2f;
            lightningLength = 30;
            lightningDamage = 50f;
            chanceDeflect = 40f;
        }};
        JXCNQ = new WallLiquidRouter("巨型超能墙"){{
            requirements(Category.defense, with(Items.metaglass, 108, Items.titanium, 162, Items.surgeAlloy, 54, Items.phaseFabric, 54, Items.phaseFabric, 45, LIitems.QSZ, 27));
            health = 2800 * 9;
            armor = 30;
            size = 3;
            liquidCapacity = 1200 * 9f;

            absorbLasers = true;
            insulated = true;
            placeableLiquid = true;
            lightningChance = 0.2f;
            lightningLength = 30;
            lightningDamage = 50f;
            chanceDeflect = 40f;
        }};

        //region 生产
        /* 太多了... */

        //region 物流
        SCD = new ILduct("双传带"){{
            requirements(Category.distribution, with(Items.metaglass, 1, Items.plastanium, 1, Items.surgeAlloy, 1, Items.phaseFabric, 1, LIitems.QSZ, 0));
        }};
        SCQ = new ILbridge("双传桥"){{
            requirements(Category.distribution, with(Items.metaglass, 5, Items.plastanium, 5, Items.surgeAlloy, 8, Items.phaseFabric, 12, LIitems.QSZ, 1));
        }};
        SCLYQ = new ILrouter("双传路由器"){{
            requirements(Category.distribution, with(Items.metaglass, 3, Items.plastanium, 1, Items.surgeAlloy, 1, LIitems.QSZ, 0));
        }};
        SCJCQ = new ILjunction("双传交叉器"){{
            requirements(Category.distribution, with(Items.metaglass, 8, Items.plastanium, 2, Items.surgeAlloy, 2, LIitems.QSZ, 0));
        }};
        TCSD = new Conveyor("钍传送带"){{
            requirements(Category.distribution, with(Items.copper, 1, Items.lead, 1, Items.thorium, 1));
            health = 95;
            speed = 0.3f;
            displayedSpeed = 30f;
        }};
        ZJCSGD = new ArmoredConveyor("重甲传送轨道"){{
            requirements(Category.distribution, with(Items.copper, 6, Items.lead, 6, Items.thorium, 1, Items.surgeAlloy, 2, Items.plastanium, 1));
            health = 750;
            armor = 30;
            speed = 0.3f;
            displayedSpeed = 30f;

            destroyBulletSameTeam = true;
            destroyBullet = new LightningBulletType(){{
                damage = 50f;
                lightning = 1;
                lightningLength = 8;
                lightningColor = Color.valueOf("CFCFCF");
                absorbable = false;
                despawnSound = Sounds.shootArc;
                despawnEffect = Fx.none;
                hitSound = Sounds.shootArc;
                hitEffect = new WaveEffect(){{
                    lifetime = 5f;
                    sizeFrom = 0f;
                    sizeTo = 4f;
                    strokeFrom = 1f;
                    strokeTo = 0f;
                    colorFrom = Color.valueOf("CFCFCFFF");
                    colorTo = Color.valueOf("CFCFCF40");
                }};

            }};
        }
            @Override
            public void setStats() {
                super.setStats();
                if(destroyBullet != null) stats.add(new Stat("damageondestroy", StatCat.function), StatValues.ammo(ObjectMap.of(this, destroyBullet), true, false));
            }
        };
        XZBXZQ = new Unloader("相织布卸载器"){{
            requirements(Category.distribution, with(Items.titanium, 30, Items.silicon, 40, Items.phaseFabric, 10));
            health = 105;
            speed = 60f / 45f;
            group = BlockGroup.transportation;
        }};
        GYFSQ = new MassDriver("高压发射器"){{
            requirements(Category.distribution, with(Items.copper, 40, Items.metaglass, 20, Items.silicon, 5));
            health = 240;
            size = 3;
            hasPower = false;
            itemCapacity = 70;
            reload = 300f;
            range = 400f;

            consumeLiquid(Liquids.water, 9f/60f);
        }};
        WXZQ = new MassDriver("微型质驱"){{
            requirements(Category.distribution, with(Items.copper, 30, Items.lead, 30, Items.silicon, 15, Items.thorium, 10));
            health = 50;
            itemCapacity = 50;
            minDistribute = 5;
            reload = 150f;
            range = 176f;
            consumePower(0.3f);
        }};

        //region 液流
        JXCYG = new LiquidRouter("巨型储液罐"){{
            requirements(Category.liquid, with(Items.titanium, 80, Items.metaglass, 120, LIitems.QSZ, 2));
            health = 960;
            size = 4;
            liquidCapacity = 9000f;
        }};
        TDGQ = new LiquidBridge("钛导管桥"){{
            requirements(Category.liquid, with(Items.titanium, 6, Items.metaglass, 12, LIitems.QSZ, 0));
            health = 60;
            floating = true;
            fadeIn = moveArrows = false;
            liquidCapacity = 50f;
            range = 12;
            explosivenessScale = flammabilityScale = 20f/100f;
        }};
        ZKB = new Pump("真空泵"){{
            requirements(Category.liquid, with(Items.copper, 200, Items.metaglass, 220, Items.titanium, 100, Items.thorium, 50, Items.silicon, 40, LIitems.QSZ, 5));
            health = 860;
            size = 4;
            liquidCapacity = 120f;
            pumpAmount = 0.7f;
            hasPower = true;
            consumePower(5.2f);
        }};

        //region 钻头
        WXCSJ = new SolidPump("微型抽水机"){{
            requirements(Category.production, with(Items.metaglass, 12, Items.graphite, 8, Items.lead, 8, Items.titanium, 8, LIitems.QSZ, 0));
            result = Liquids.water;
            pumpAmount = 0.08f;
            liquidCapacity = 10f;
            rotateSpeed = 2f;
            attribute = Attribute.water;
            consumePower(0.5f);
        }};
        QXCSJ = new SolidPump("强效抽水机"){{
            requirements(Category.production, with(Items.metaglass, 30, Items.graphite, 30, Items.titanium, 50, LIitems.QSZ, 1));
            health = 200;
            size = 2;
            result = Liquids.water;
            pumpAmount = 0.26f;
            liquidCapacity = 30f;
            rotateSpeed = 3f;
            attribute = Attribute.water;
            consumePower(2f);
        }};
        DXCSJ = new SolidPump("大型抽水机"){{
            requirements(Category.production, with(Items.metaglass, 45, Items.graphite, 75, Items.titanium, 100, LIitems.QSZ, 7));
            health = 450;
            size = 3;
            result = Liquids.water;
            pumpAmount = 1.5f;
            liquidCapacity = 30f;
            rotateSpeed = 1.5f;
            attribute = Attribute.water;
            consumePower(7f);
        }};
        LDYCQJ = new SolidPump("冷冻液抽取机"){{
            requirements(Category.production, with(Items.metaglass, 30, Items.graphite, 30, Items.titanium, 40, Items.thorium, 30, LIitems.QSZ, 5));
            health = 220;
            size = 2;
            result = Liquids.cryofluid;
            pumpAmount = 0.25f;
            baseEfficiency = 0f;
            liquidCapacity = 30f;
            rotateSpeed = 3f;
            attribute = LIattr.cryofluid;
            consumePower(3.25f);
        }};
        FYCQJ = new SolidPump("废液抽取机"){{
            requirements(Category.production, with(Items.metaglass, 45, Items.graphite, 75, Items.titanium, 100, LIitems.QSZ, 7));
            health = 480;
            size = 3;
            result = LIliquids.FY0;
            pumpAmount = 2f;
            baseEfficiency = 0.25f;
            liquidCapacity = 30f;
            rotateSpeed = 1.5f;
            attribute = LIattr.scrapfluid;
            consumePower(3f);

            updateEffect = new ParticleEffect(){{
                lifetime = 50f;
                particles = 5;
                baseLength = 0f;
                length = 6f;
                interp = Interp.pow3Out;
                sizeInterp = Interp.pow5In;
                sizeFrom = 2f;
                sizeTo = 0f;
                region = "液体工艺-square";
                lightColor = colorFrom = colorTo = Color.valueOf("9B928B");
            }};
            updateEffectChance = 0.03f;
        }
            @Override
            public boolean canPlaceOn(Tile tile, Team team, int rotation) {
                var rules = Vars.state.rules;
                return rules.planet == LIplanets.NT || rules.editor;
            }

            @Override
            public void drawPlace(int x, int y, int rotation, boolean valid) {
                var rules = Vars.state.rules;
                if(rules.planet != LIplanets.NT && !rules.editor){
                    this.drawPlaceText(Core.bundle.get("canonlyplaceon") + LIplanets.NT.localizedName, x, y, false);
                    return;
                }
                super.drawPlace(x, y, rotation, valid);
            }
        };
        BLZJ = new Fracker("冰冷钻井"){{
            requirements(Category.production, with(Items.titanium, 180, Items.thorium, 125, Items.metaglass, 55, Items.silicon, 75, LIitems.GTLDY, 5));
            health = 540;
            size = 3;
            result = Liquids.cryofluid;
            pumpAmount = 2.5f;
            liquidCapacity = 90f;
            attribute = LIattr.cryofluid;
            consumePower(7.1f);
            consumeLiquid(Liquids.water, 3.5f);

            updateEffect = new ParticleEffect(){{
                lifetime = 50f;
                particles = 5;
                baseLength = 0f;
                length = 6f;
                interp = Interp.pow3Out;
                sizeInterp = Interp.pow5In;
                sizeFrom = 2f;
                sizeTo = 0f;
                region = "液体工艺-square";
                lightColor = colorFrom = colorTo = Color.valueOf("87CEEB");
            }};
            updateEffectChance = 0.04f;
        }};
        YZSYZJ = new Fracker("硬质石油钻井"){{
            requirements(Category.production, with(Items.copper, 400, Items.titanium, 220, Items.thorium, 175, Items.graphite, 300, Items.plastanium, 25, Items.silicon, 75));
            health = 760;
            size = 4;
            result = Liquids.oil;
            pumpAmount = 0.75f;
            liquidCapacity = 60f;
            attribute = Attribute.oil;
            itemUseTime = 30f;
            consumeItem(Items.sand);
            consumePower(13.5f);
            consumeLiquid(Liquids.water, 0.5f);

            updateEffect = Fx.pulverize;
            updateEffectChance = 0.08f;
        }};
    }
}
