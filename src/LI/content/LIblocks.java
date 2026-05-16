package LI.content;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
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
import LI.type.blocks.defense.turrets.*;
import LI.type.blocks.distribution.itemLiquid.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class LIblocks {
    /** 部分方块还未搬入JAVA：力场墙，极光。液体质驱和卸载类。所有生产类。 */
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
    DCFB,TFP,DLY,DL,JK,PF,MF,BP,JG,ZBPT,

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
    JXLTCG,TDGQ,ZKB, //YTZQ,WXYTZQ,

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
                    new DrawDefault(){
                        @Override
                        public void draw(Building build) {
                            Draw.z(Layer.blockAfterCracks);
                            Draw.rect(build.block.region, build.x, build.y, build.drawrot());
                        }
                    }
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
        CPTY = new StatusProjector("超频投影"){{
            requirements(Category.effect, with(Items.lead, 100, Items.graphite, 75, Items.silicon, 40, Items.thorium, 15));
            health = 260;
            size = 2;
            setStatus(StatusEffects.overclock);
            consumePower(2f);
        }};
        BHTY = new StatusProjector("保护投影"){{
            requirements(Category.effect, with(Items.lead, 100, Items.graphite, 75, Items.silicon, 40, Items.phaseFabric, 5));
            health = 260;
            size = 2;
            setStatus(StatusEffects.shielded);
            consumePower(2f);
        }};
        JDTY = new StatusProjector("解冻投影"){{
            requirements(Category.effect, with(Items.lead, 100, Items.graphite, 75, Items.silicon, 40, LIitems.GTLDY, 1));
            health = 260;
            size = 2;
            range = 80f;
            setStatus(LIstatus.JD);
            consumePower(1.5f);
            consumeLiquid(Liquids.cryofluid, 3f / 60f);
        }};
        ZTQD = new StatusProjector("状态穹顶"){{
            requirements(Category.effect, with(Items.lead, 220, Items.graphite, 165, Items.silicon, 100, Items.phaseFabric, 25, LIitems.NRJT, 1));
            health = 680;
            size = 3;
            range = 200f;
            useTime = 1200f;
            reload = 180f;
            setStatus(StatusEffects.overclock, StatusEffects.shielded, StatusEffects.fast);
            consumePower(8f);
            consumeLiquid(Liquids.cryofluid, 21f / 60f);
        }};
        SYTQ = new StatusProjector("神佑天穹"){{
            requirements(Category.effect, with(Items.lead, 350, Items.titanium, 180, Items.silicon, 180, Items.plastanium, 130, Items.surgeAlloy, 150, LIitems.NRJT, 10, LIitems.SMSP, 5));
            health = 1260;
            size = 4;
            range = 240f;
            reload = 300f;
            setStatus(LIstatus.SY);
            consumePower(8.5f);
            consumeLiquid(LIliquids.FY5, 3f / 60f);
        }};
        RHTY = new StatusProjector("弱化投影"){{
            requirements(Category.effect, with(Items.lead, 100, Items.coal, 85, Items.silicon, 40, Items.thorium, 10));
            health = 280;
            size = 2;
            range = 160f;
            useTime = 600f;
            reload = 600f;
            applyOnEnemies = true;
            setStatus(StatusEffects.sapped);
            consumePower(3f);
        }};
        MBTY = new StatusProjector("麻痹投影"){{
            requirements(Category.effect, with(Items.lead, 100, Items.plastanium, 25, Items.silicon, 40, Items.thorium, 10));
            health = 280;
            size = 2;
            range = 160f;
            useTime = 600f;
            reload = 600f;
            applyOnEnemies = true;
            setStatus(StatusEffects.electrified);
            consumePower(3f);
        }};
        HSTY = new StatusProjector("缓速投影"){{
            requirements(Category.effect, with(Items.lead, 100, Items.scrap, 165, Items.silicon, 40, Items.thorium, 10));
            health = 280;
            size = 2;
            range = 160f;
            useTime = 600f;
            reload = 600f;
            applyOnEnemies = true;
            setStatus(StatusEffects.slow);
            consumePower(3f);
        }};
        RHQD = new StatusProjector("弱化穹顶"){{
            requirements(Category.effect, with(Items.lead, 220, Items.coal, 250, Items.silicon, 120,Items.phaseFabric, 55, Items.surgeAlloy, 105));
            health = 780;
            size = 3;
            range = 360f;
            useTime = 720f;
            reload = 300f;
            applyOnEnemies = true;
            setStatus(StatusEffects.sapped);
            consumePower(12f);
            consumeLiquid(Liquids.oil, 12f / 60f);
        }};
        MBQD = new StatusProjector("麻痹穹顶"){{
            requirements(Category.effect, with(Items.lead, 220, Items.plastanium, 125, Items.silicon, 120,Items.phaseFabric, 55, Items.surgeAlloy, 105));
            health = 780;
            size = 3;
            range = 360f;
            useTime = 720f;
            reload = 300f;
            applyOnEnemies = true;
            setStatus(StatusEffects.electrified);
            consumePower(12f);
            consumeLiquid(LIliquids.ZS, 15f / 60f);
        }};
        HSQD = new StatusProjector("缓速穹顶"){{
            requirements(Category.effect, with(Items.lead, 220, Items.scrap, 425, Items.silicon, 120,Items.phaseFabric, 55, Items.surgeAlloy, 105));
            health = 780;
            size = 3;
            range = 360f;
            useTime = 720f;
            reload = 300f;
            applyOnEnemies = true;
            setStatus(StatusEffects.slow);
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
        DCFB = new ItemTurret("电磁风暴"){{
            requirements(Category.turret, with(Items.lead, 1500, Items.metaglass, 1000, Items.silicon, 750, Items.graphite,750, Items.surgeAlloy, 500, LIitems.QSZ, 125, LIitems.GTS, 10));
            health = 3200;
            size = 4;
            range = 768f;
            reload = 300f;
            maxAmmo = 15;
            ammoPerShot = 3;
            recoilTime = 60f;
            recoil = 4f;
            buildCostMultiplier = 0.6f;
            shootSound = Sounds.shootFuse;
            shootCone = 0.5f;
            shake = 6f;
            rotateSpeed = 4f;
            shootY = 8f;
            shoot = new ShootPattern() {{
                shots = 1;
                firstShotDelay = 30f;
                shotDelay = 0f;
            }};
            consumePower(24f);
            coolant = consumeCoolant(1.5f);
            coolantMultiplier = 0.35f;
            destroyBullet = new LightningBulletType(){{
                damage = 1000f;
                lightning = 3;
                lightningLength = 60;
                lightningColor = Color.white.cpy();
                despawnSound = hitSound = Sounds.shootArc;
                collides = absorbable = false;
                pierceArmor = true;
                hitEffect = new WaveEffect(){{
                    lifetime = 5f;
                    sizeFrom = 0f;
                    sizeTo = 8f;
                    strokeFrom = 1f;
                    strokeTo = 0f;
                    colorFrom = Color.white.cpy();
                    colorTo = Color.white.cpy().a(40f/255);
                }};
            }};
            destroyBulletSameTeam = true;
            ammo(
                    LIitems.GTS, new BasicBulletType(12.8f, 2000f){{
                        lifetime = 60f;
                        ammoMultiplier = 1f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = Color.white;
                        splashDamage = 540;
                        splashDamageRadius = 40f;
                        puddles = 1;
                        puddleAmount = 450f;
                        puddleLiquid = Liquids.water;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.wet;
                        statusDuration = 300f;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.shootArc;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Color.white;
                            damage = 10f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 5;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Color.white;
                            damage = 150f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 25;
                        }};
                        fragBullets = 16;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                    }},
                    LIitems.GTZS, new BasicBulletType(12.8f, 2000f){{
                        lifetime = 60f;
                        ammoMultiplier = 1f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = LIcolor.ZScolor;
                        splashDamage = 540;
                        splashDamageRadius = 40f;
                        puddles = 1;
                        puddleAmount = 450f;
                        puddleLiquid = LIliquids.ZS;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.electrified;
                        statusDuration = 300f;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.shootArc;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.ZScolor;
                            damage = 10f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 5;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.ZScolor;
                            damage = 150f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 25;
                        }};
                        fragBullets = 16;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                    }},
                    LIitems.GTSY, new BasicBulletType(12.8f, 200f){{
                        lifetime = 60f;
                        ammoMultiplier = 1f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = LIcolor.oilColor;
                        splashDamage = 540;
                        splashDamageRadius = 160f;
                        splashDamagePierce = true;
                        puddles = 1;
                        puddleAmount = 450f;
                        puddleLiquid = Liquids.oil;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.tarred;
                        statusDuration = 300f;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.explosionMissile;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.oilColor;
                            damage = 1f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 4;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.oilColor;
                            damage = 20f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 15;
                            hitSound = despawnSound = Sounds.shootArc;
                        }};
                        fragBullets = 6;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                        hitEffect = despawnEffect = LIfx.DCFBsplash(hitColor);

                        trailEffect = new ParticleEffect(){{
                            lifetime = 30f;
                            particles = 2;
                            interp = Interp.circleOut;
                            sizeInterp = Interp.circleIn;
                            sizeFrom = 3f;
                            sizeTo = 0f;
                            length = 24f;
                            baseLength = 0f;
                            colorFrom = colorTo = LIcolor.oilColor;
                        }};
                        trailInterval = 5f;
                        trailChance = 1f;
                    }},
                    LIitems.GTLDY, new BasicBulletType(12.8f, 200f){{
                        lifetime = 60f;
                        ammoMultiplier = 1f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = LIcolor.cryofluidColor;
                        splashDamage = 108;
                        splashDamageRadius = 160f;
                        splashDamagePierce = true;
                        puddles = 1;
                        puddleAmount = 450f;
                        puddleLiquid = Liquids.cryofluid;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.freezing;
                        statusDuration = 300f;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.explosionMissile;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.cryofluidColor;
                            damage = 1f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 4;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new EmptyBulletType(){{
                            lifetime = 600f;
                            damage = speed = 0f;
                            absorbable = reflectable = hittable = collides = false;
                            hitEffect = despawnEffect = Fx.none;
                            intervalBullet = new BasicBulletType(){{
                                instantDisappear = splashDamagePierce = true;
                                absorbable = reflectable = false;
                                damage = 0f;
                                splashDamage = 108f;
                                splashDamageRadius = 160f;
                                status = StatusEffects.freezing;
                                hitEffect = despawnEffect = new MultiEffect(
                                        new WaveEffect(){{
                                            lifetime = 120f;
                                            sizeFrom = 161f;
                                            sizeTo = 160f;
                                            strokeFrom = 3f;
                                            strokeTo = 3f;
                                            colorFrom = LIcolor.cryofluidColor;
                                            colorTo = LIcolor.cryofluidColor.cpy().a(0f);
                                        }},
                                        new ParticleEffect(){{
                                            lifetime = 120f;
                                            particles = 30;
                                            interp = Interp.circleOut;
                                            sizeInterp = Interp.circleIn;
                                            sizeFrom = 2f;
                                            sizeTo = 2f;
                                            length = 44f;
                                            baseLength = 132f;
                                            colorFrom = LIcolor.cryofluidColor;
                                            colorTo = LIcolor.cryofluidColor.cpy().a(0f);
                                        }}
                                );
                            }};
                            bulletInterval = 60f;
                            intervalBullets = 1;
                        }};
                        fragBullets = 1;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                        hitEffect = despawnEffect = LIfx.DCFBsplash(hitColor);

                        trailEffect = new ParticleEffect(){{
                            lifetime = 30f;
                            particles = 2;
                            interp = Interp.circleOut;
                            sizeInterp = Interp.circleIn;
                            sizeFrom = 3f;
                            sizeTo = 0f;
                            length = 24f;
                            baseLength = 0f;
                            colorFrom = colorTo = LIcolor.cryofluidColor;
                        }};
                        trailInterval = 5f;
                        trailChance = 1f;
                    }},
                    LIitems.GTCJLDY, new BasicBulletType(12.8f, 200f){{
                        lifetime = 60f;
                        ammoMultiplier = 1f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = LIcolor.CJLDYcolor;
                        splashDamage = 108;
                        splashDamageRadius = 160f;
                        splashDamagePierce = true;
                        puddles = 1;
                        puddleAmount = 450f;
                        puddleLiquid = LIliquids.CJLDY;
                        buildingDamageMultiplier = 0.05f;
                        status = LIstatus.BF;
                        statusDuration = 300f * 2;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.explosionMissile;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.CJLDYcolor;
                            damage = 1f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 4;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.CJLDYcolor;
                            damage = 20f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 15;
                            hitSound = despawnSound = Sounds.shootArc;
                        }};
                        fragBullets = 6;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                        hitEffect = despawnEffect = LIfx.DCFBsplash(hitColor, "液体工艺-snow");

                        trailEffect = new ParticleEffect(){{
                            lifetime = 30f;
                            region = "液体工艺-snow";
                            particles = 2;
                            interp = Interp.circleOut;
                            sizeInterp = Interp.circleIn;
                            sizeFrom = 3f;
                            sizeTo = 0f;
                            length = 24f;
                            baseLength = 0f;
                            colorFrom = colorTo = LIcolor.CJLDYcolor;
                        }};
                        trailInterval = 5f;
                        trailChance = 1f;
                    }},
                    LIitems.HWKZJT, new BasicBulletType(12.8f, 200f){{
                        lifetime = 60f;
                        ammoMultiplier = 1f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = LIcolor.slagColor;
                        splashDamage = 1080;
                        splashDamageRadius = 160f;
                        splashDamagePierce = true;
                        incendAmount = 3;
                        incendChance = 1f;
                        puddles = 1;
                        puddleAmount = 450f;
                        puddleLiquid = Liquids.slag;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.melting;
                        statusDuration = 300f;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.explosionMissile;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.slagColor;
                            damage = 1f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 4;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = LIcolor.slagColor;
                            damage = 20f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 15;
                            hitSound = despawnSound = Sounds.shootArc;
                        }};
                        fragBullets = 6;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                        hitEffect = despawnEffect = LIfx.DCFBsplash(hitColor, "液体工艺-sTar");

                        trailEffect = new ParticleEffect(){{
                            lifetime = 30f;
                            region = "液体工艺-sTar";
                            particles = 2;
                            interp = Interp.circleOut;
                            sizeInterp = Interp.circleIn;
                            sizeFrom = 3f;
                            sizeTo = 0f;
                            length = 24f;
                            baseLength = 0f;
                            colorFrom = colorTo = LIcolor.slagColor;
                        }};
                        trailInterval = 5f;
                        trailChance = 1f;
                    }},
                    LIitems.HWSBJT, new BasicBulletType(12.8f, 200f){{
                        lifetime = 60f;
                        ammoMultiplier = 1f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = Color.red;
                        splashDamage = 3080;
                        splashDamageRadius = 160f;
                        splashDamagePierce = true;
                        incendAmount = 5;
                        incendChance = 1f;
                        puddles = 1;
                        puddleAmount = 450f;
                        puddleLiquid = LIliquids.SBRY;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.burning;
                        statusDuration = 300f * 2;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.explosionMissile;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Color.red;
                            damage = 1f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 4;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Color.red;
                            damage = 20f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 15;
                            hitSound = despawnSound = Sounds.shootArc;
                        }};
                        fragBullets = 6;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                        hitEffect = despawnEffect = LIfx.DCFBsplash(hitColor, "液体工艺-sTar");

                        trailEffect = new MultiEffect(
                                Fx.fireHit,
                                Fx.fire,
                                new ParticleEffect(){{
                                    lifetime = 30f;
                                    region = "液体工艺-sTar";
                                    particles = 2;
                                    interp = Interp.circleOut;
                                    sizeInterp = Interp.circleIn;
                                    sizeFrom = 3f;
                                    sizeTo = 0f;
                                    length = 24f;
                                    baseLength = 0f;
                                    colorFrom = colorTo = Color.red;
                                }}
                        );
                        trailInterval = 5f;
                        trailChance = 1f;
                    }},
                    LIitems.CDZ, new BasicBulletType(12.8f, 4200f){{
                        lifetime = 69.375f;
                        rangeChange = 120f;
                        reloadMultiplier = 0.5f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = Color.cyan;
                        splashDamage = 540;
                        splashDamageRadius = 40f;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.electrified;
                        statusDuration = 300f * 3;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.shootArc;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Color.cyan;
                            damage = 20f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 5;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Color.cyan;
                            damage = 300f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 40;
                        }};
                        fragBullets = 20;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                    }},
                    Items.surgeAlloy, new BasicBulletType(12.8f, 800f){{
                        lifetime = 50.625f;
                        rangeChange = -120f;
                        ammoMultiplier = 1f;
                        reloadMultiplier = 0.8f;
                        backColor = frontColor = Color.valueOf("00000000");
                        hitColor = Pal.surge;
                        splashDamage = 540;
                        splashDamageRadius = 40f;
                        buildingDamageMultiplier = 0.05f;
                        status = StatusEffects.shocked;
                        hitSize = 24f;
                        hitSound = despawnSound = Sounds.shootArc;

                        intervalBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Pal.surge;
                            damage = 10f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 5;
                        }};
                        bulletInterval = 3f;
                        intervalBullets = 3;
                        intervalRandomSpread = 30f;
                        intervalSpread = 60f;
                        intervalAngle = 0f;

                        fragBullet = new LightningBulletType(){{
                            pierceArmor = true;
                            lightningColor = Pal.surge;
                            damage = 50f;
                            buildingDamageMultiplier = 0.05f;
                            lightningLength = 25;
                        }};
                        fragBullets = 16;

                        shootEffect = LIfx.DCFBshoot(hitColor);
                    }}
            );
        }
            @Override
            public void setStats() {
                super.setStats();
                if(destroyBullet != null) stats.add(new Stat("damageondestroy", StatCat.function), StatValues.ammo(ObjectMap.of(this, destroyBullet), true, false));
            }
        };
        TFP = new ThoriumReactorLauncher("钍反炮"){{ //显示尚有问题
            requirements(Category.turret, with(Items.thorium, 175, Items.graphite, 75, Items.silicon, 75, Items.plastanium, 25, Items.surgeAlloy, 25, LIitems.GTLDY, 1));
            predictTarget = false;
            health = 4800;
            size = 5;
            range = 760f;
            reload = 120f;
            recoilTime = 75f;
            recoil = 4f;
            inaccuracy = 10f;
            shootCone = 10f;
            shake = 6f;
            rotateSpeed = 0.8f;
            maxAmmo = 1;
            shootSound = Sounds.shootTank;
            shootEffect = Fx.none;
            shootY = 2f;
            shootWarmupSpeed = 0.015f;
            warmupMaintainTime = 300f;
            minWarmup = 0.9f;
            consumePower(15f);

            ammo(
                    Blocks.thoriumReactor, new BulletType(0f, 0f){{
                        shootEffect = Fx.shootBig;
                        smokeEffect = Fx.shootSmokeMissileColor;
                        hitColor = Color.valueOf("BF92F9");
                        ammoMultiplier = 1;
                        spawnUnit = LIunits.TF1;
                    }},
                    LIblocks.ZSHFYD, new BulletType(0f, 0f){{
                        shootEffect = Fx.shootBig;
                        smokeEffect = Fx.shootSmokeMissileColor;
                        hitColor = Color.valueOf("BF92F9");
                        ammoMultiplier = 1;
                        reloadMultiplier = 0.8f;
                        spawnUnit = LIunits.TF2;
                    }}
            );
            drawer = new DrawTurret(){{
                parts.addAll(
                        new RegionPart("-main"){{
                            mirror = false;
                            heatColor = Color.valueOf("BF92F9");
                            heatProgress = DrawPart.PartProgress.warmup;
                            moveY = 0f;
                        }},
                        new RegionPart("-side"){{
                            mirror = under = true;
                            heatColor = Color.valueOf("BF92F9");
                            heatProgress = progress = PartProgress.warmup;
                            moveX = 3f;
                            moveY = -2f;
                        }}
                );
            }};
            ammoparts(
                    Blocks.thoriumReactor,
                    Seq.with(new RegionPart("-钍反1") {{
                        progress = PartProgress.reload.curve(Interp.pow2In);
                        color = Color.white;
                        colorTo = new Color(1, 1, 1, 0);
                        outline = false;
                        under = true;
                        layerOffset = -0.01f;
                        moves = Seq.with(new DrawPart.PartMove(PartProgress.warmup.inv(), 0, -6, 0));
                    }}),
                    ZSHFYD,
                    Seq.with(new RegionPart("-钍反2") {{
                        progress = PartProgress.reload.curve(Interp.pow2In);
                        color = Color.white;
                        colorTo = new Color(1, 1, 1, 0);
                        outline = false;
                        under = true;
                        layerOffset = -0.01f;
                        moves = Seq.with(new DrawPart.PartMove(PartProgress.warmup, 0, 2, 0));
                    }})
            );
        }};
        DLY = new PowerTurret("德鲁伊"){{
            requirements(Category.turret, with(Items.copper, 200, Items.lead, 150, Items.graphite, 50, LIitems.ZYZ, 5));
            canOverdrive = targetGround = targetAir = false;
            targetHealing = true;
            health = 1000;
            size = 3;
            range = 280f;
            reload = recoilTime = 5.4f;
            recoil = 1f;
            shootSound = LIaudio.laser;
            shootCone = 1f;
            rotateSpeed = 6f;
            shootY = 12f;
            shoot = new ShootPattern();
            consumePower(3.6f);
            shootType = new BasicBulletType(15f, 10f){{
                collidesAir = false;
                pierceArmor = true;
                healPercent = 3f;
                trailLength = 3;
                trailWidth = 1.6f;
                frontColor = Color.valueOf("84F491");
                backColor = trailColor = Color.valueOf("6BC583");
                width = 8f;
                height = 26f;
                lifetime = 18.67f;
                hitEffect = despawnEffect = new WaveEffect(){{
                    lifetime = 16f;
                    sizeFrom = 1f;
                    sizeTo = 16f;
                    strokeFrom = 2f;
                    strokeTo = 0f;
                    colorFrom = Color.valueOf("84F491");
                    colorTo = Color.valueOf("84F49139");
                }};
            }};
        }};
        DL = new PowerTurret("电裂"){{
            requirements(Category.turret, with(Items.copper, 125, Items.lead, 105, Items.graphite, 75, LIitems.CDZ, 1));
            targetGround = false;
            health = 800;
            size = 2;
            range = 260f;
            reload = recoilTime = 30f;
            recoil = 1f;
            inaccuracy = 15f;
            shootCone = 30f;
            rotateSpeed = 15f;
            shoot = new ShootPattern(){{
                shots = 5;
                shotDelay = 2f;
            }};
            consumePower(2.8f);
            coolant = consumeCoolant(0.2f);
            shootType = new FlakBulletType(6f, 5f){{
                collidesAir = false;
                lifetime = 46.67f;
                splashDamage = 50f;
                splashDamageRadius = 36f;
                status = StatusEffects.electrified;
                statusDuration = 180f;
                width = 9f;
                height = 12f;
                frontColor = Color.white;
                hitColor = backColor = Color.valueOf("00FFFFA0");
                shootEffect = Fx.sparkShoot;
                hitEffect = despawnEffect = LIfx.DLsparkExplosion;
            }};
            drawer = new DrawTurret(){{
                parts.add(
                        new RegionPart("-mid"){{
                            progress = PartProgress.recoil;
                            moveY = -1.25f;
                        }}
                );
            }};
        }};
        JK = new PowerTurret("禁空") {{
            requirements(Category.turret, with(Items.lead, 6000, Items.graphite, 3500, Items.surgeAlloy, 1800, Items.plastanium, 1200, LIitems.CDZ, 125, LIitems.SMWZ, 1));
            canOverdrive = targetGround = false;
            unitSort = UnitSorts.strongest;
            researchCostMultiplier = 0.6f;
            health = 10800;
            armor = 10;
            size = 5;
            range = 1240f;
            reload = 45f;
            recoilTime = 30f;
            recoil = 5f;
            shootCone = 5f;
            shake = 9f;
            rotateSpeed = 1.5f;
            shootWarmupSpeed = 0.02f;
            warmupMaintainTime = 180f;
            minWarmup = 0.9f;
            shootSound = Sounds.explosionTitan;

            consumePower(546f);
            coolant = consumeCoolant(5f);
            coolantMultiplier = 0.1f;

            shoot = new ShootSpread(5, 6f);
            shootEffect = new MultiEffect(
                    new ParticleEffect(){{
                        particles = 6;
                        line = true;
                        lenFrom = 120f;
                        lenTo = 0f;
                        strokeFrom = 3f;
                        strokeTo = 0f;
                        interp = Interp.pow5Out;
                        length = 160f;
                        lifetime = 60f;
                        colorFrom = Color.cyan;
                        colorTo = Color.cyan.cpy().a(40f/255);
                        cone = 60f;
                    }},
                    new ParticleEffect(){{
                        particles = 9;
                        line = true;
                        lenFrom = 40f;
                        lenTo = 0f;
                        strokeFrom = 2f;
                        strokeTo = 0f;
                        interp = Interp.pow3Out;
                        length = 90f;
                        lifetime = 35f;
                        colorFrom = Color.cyan;
                        colorTo = Color.cyan.cpy().a(40f/255);
                        cone = 120f;
                    }},
                    new ParticleEffect(){{
                        particles = 12;
                        sizeFrom = 2f;
                        sizeTo = 0f;
                        interp = Interp.circleOut;
                        length = 40f;
                        lifetime = 20f;
                        colorFrom = Color.cyan;
                        colorTo = Color.cyan.cpy().a(40f/255);
                        cone = 180f;
                    }}
            );
            shootType = new FlakBulletType(10f, 700f) {{
                reflectable = collidesGround = false;
                pierceCap = 3;
                splashDamage = 700f;
                splashDamageRadius = 40f;
                splashDamagePierce = true;
                lifetime = 128f;
                width = 12f;
                height = 40f;
                trailLength = 12;
                trailWidth = 5f;
                lightRadius = 80f;
                hitColor = backColor = trailColor = lightColor = lightningColor = Color.cyan;
                hitEffect = new WaveEffect(){{
                    lifetime = 20f;
                    sizeFrom = 0f;
                    sizeTo = 40f;
                    strokeFrom = 3f;
                    strokeTo = 0f;
                    colorFrom = Color.cyan;
                    colorTo = Color.cyan.cpy().a(66f/255);
                }};
                despawnEffect = Fx.none;
                hitSound = Sounds.shootArc;
                despawnSound = Sounds.none;
                status = StatusEffects.electrified;
                statusDuration = 360f;
                lightning = 6;
                lightningCone = 360f;
                lightningLength = 15;
                lightningLengthRand = 15;
                lightningDamage = 15f;
                fragBullet = new BasicBulletType(4f, 350f) {{
                    absorbable = reflectable = collidesGround = false;
                    damage = 350f;
                    splashDamage = 350f;
                    splashDamageRadius = 96f;
                    splashDamagePierce = true;
                    lifetime = 90f;
                    homingPower = 0.06f;
                    homingRange = 120f;
                    width = 12f;
                    height = 40f;
                    trailLength = 12;
                    trailWidth = 5f;
                    trailRotation = true;
                    lightRadius = 80f;
                    hitColor = backColor = trailColor = lightColor = Color.cyan;
                    hitEffect = new WaveEffect(){{
                        lifetime = 20f;
                        sizeFrom = 0f;
                        sizeTo = 112f;
                        strokeFrom = 3f;
                        strokeTo = 0f;
                        colorFrom = Color.cyan;
                        colorTo = Color.cyan.cpy().a(66f/255);
                    }};
                    despawnEffect = new WaveEffect(){{
                        lifetime = 20f;
                        sizeFrom = 0f;
                        sizeTo = 112f;
                        strokeFrom = 3f;
                        strokeTo = 0f;
                        colorFrom = Color.cyan;
                        colorTo = Color.cyan.cpy().a(66f/255);
                    }};
                    hitSound = Sounds.explosionTitan;
                    despawnSound = Sounds.explosionTitan;
                    status = StatusEffects.electrified;
                    statusDuration = 180f;
                    lightning = 6;
                    lightningCone = 360f;
                    lightningLength = 15;
                    lightningLengthRand = 15;
                    lightningDamage = 50f;
                    lightningColor = Color.cyan;
                }};
                delayFrags = fragOnHit = true;
                fragBullets = 5;
                fragSpread = 5f;
                fragOnAbsorb = true;
            }};
            drawer = new DrawTurret(){{
                parts.addAll(
                        new RegionPart("-head"){{
                            heatColor = Color.cyan.cpy().a(80f/255);
                            heatProgress = PartProgress.warmup;
                            moveY = 0f;
                        }},
                        new RegionPart("-main"){{
                            heatColor = Color.cyan.cpy().a(80f/255);
                            heatProgress = PartProgress.warmup;
                            moveY = -2f;
                        }},
                        new RegionPart("-end"){{
                            heatColor = Color.cyan.cpy().a(80f/255);
                            heatProgress = PartProgress.warmup;
                            moveY = 0f;
                        }},
                        new RegionPart("-wing"){{
                            mirror = true;
                            heatColor = Color.cyan.cpy().a(80f/255);
                            heatProgress = PartProgress.warmup;
                            moveRot = 25f;
                            moveX = 3f;
                            moveY = -12f;
                        }},
                        new RegionPart("-front"){{
                            mirror = true;
                            heatColor = Color.cyan.cpy().a(80f/255);
                            heatProgress = PartProgress.warmup;
                            moveX = -1f;
                            moveY = -6f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup;
                            y = -15f;
                            color = Color.cyan;
                            radius = 0f;
                            radiusTo = 10f;
                            stroke = 0f;
                            strokeTo = 2f;
                            circle = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup;
                            y = -15f;
                            color = Color.cyan;
                            rotateSpeed = 3f;
                            radius = 0f;
                            radiusTo = 9f;
                            stroke = 0f;
                            strokeTo = 2f;
                            sides = 3;
                            circle = false;
                            hollow = true;
                            layer = 110;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup;
                            y = -15f;
                            color = Color.cyan;
                            rotateSpeed = -3f;
                            radius = 0f;
                            radiusTo = 9f;
                            stroke = 0f;
                            strokeTo = 2f;
                            sides = 3;
                            circle = false;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            y = -15f;
                            color = Color.cyan;
                            haloRotateSpeed = 2f;
                            haloRadius = 0f;
                            haloRadiusTo = 15f;
                            stroke = 0f;
                            strokeTo = 2f;
                            sides = 3;
                            shapes = 3;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            y = -15f;
                            color = Color.cyan;
                            haloRotateSpeed = -2f;
                            haloRadius = 0f;
                            haloRadiusTo = 15f;
                            stroke = 0f;
                            strokeTo = 2f;
                            sides = 3;
                            shapes = 3;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            x = -20f;
                            y = -20f;
                            color = Color.cyan;
                            haloRotation = 135f;
                            stroke = 0f;
                            strokeTo = 2f;
                            triLength = 0f;
                            triLengthTo = 44f;
                            sides = 3;
                            shapes = 1;
                            radius = 0f;
                            radiusTo = 6f;
                            tri = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            x = 24f;
                            y = -24f;
                            color = Color.cyan;
                            haloRotation = 225f;
                            stroke = 0f;
                            strokeTo = 2f;
                            triLength = 0f;
                            triLengthTo = 44f;
                            sides = 3;
                            shapes = 1;
                            radius = 0f;
                            radiusTo = 6f;
                            tri = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            x = -26.6f;
                            y = -13.3f;
                            color = Color.cyan;
                            haloRotation = 117f;
                            stroke = 0f;
                            strokeTo = 2f;
                            triLength = 0f;
                            triLengthTo = 44f;
                            sides = 3;
                            shapes = 1;
                            radius = 0f;
                            radiusTo = 6f;
                            tri = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            x = 26.6f;
                            y = -13.3f;
                            color = Color.cyan;
                            haloRotation = 243f;
                            stroke = 0f;
                            strokeTo = 2f;
                            triLength = 0f;
                            triLengthTo = 44f;
                            sides = 3;
                            shapes = 1;
                            radius = 0f;
                            radiusTo = 6f;
                            tri = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            x = -13.3f;
                            y = -26.6f;
                            color = Color.cyan;
                            haloRotation = 153f;
                            stroke = 0f;
                            strokeTo = 2f;
                            triLength = 0f;
                            triLengthTo = 44f;
                            sides = 3;
                            shapes = 1;
                            radius = 0f;
                            radiusTo = 6f;
                            tri = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup;
                            x = 13.3f;
                            y = -26.6f;
                            color = Color.cyan;
                            haloRotation = 207f;
                            stroke = 0f;
                            strokeTo = 2f;
                            triLength = 0f;
                            triLengthTo = 44f;
                            sides = 3;
                            shapes = 1;
                            radius = 0f;
                            radiusTo = 6f;
                            tri = true;
                            hollow = true;
                            layer = 110;
                        }}
                );
            }};
        }};
        PF = new PowerTurret("破防"){{
            requirements(Category.turret, with(Items.titanium, 12, Items.silicon, 36, Items.blastCompound, 5));
            health = 140;
            size = 3;
            shake = 0.05f;
            inaccuracy = 2f;
            recoil = 2f;
            recoilTime = 10f;
            cooldownTime = 80f;
            consumePower(4);
            coolant = consumeCoolant(0.8f);
            coolantMultiplier = 0.5f;
            reload = 30;
            rotateSpeed = 6;
            range = 240f;
            buildCostMultiplier = 2;
            shootSound = Sounds.shootArtillerySmall;
            shootEffect = Fx.shootBig;
            shootType = new PointBulletType() {{
                buildingDamageMultiplier = 0.2f;
                trailEffect = new ParticleEffect() {{
                    sizeInterp = Interp.pow5Out;
                    particles = 1;
                    length = 0;
                    baseLength = 0.2f;
                    lifetime = 30;
                    line = true;
                    randLength = false;
                    lenFrom = 13;
                    lenTo = 13;
                    strokeFrom = 6;
                    strokeTo = 0;
                    colorFrom = Color.valueOf("FF795EFF");
                    colorTo = Color.valueOf("FF795E80");
                    cone = 0;
                }};
                hitEffect = despawnEffect = Fx.none;
                damage = 0f;
                splashDamageRadius = 24;
                splashDamage = 45;
                knockback = 2.5f;
                speed = 20;
                lifetime = 37;
                ammoMultiplier = 1;
                fragBullets = 4;
                fragBullet = new PointBulletType() {{
                    buildingDamageMultiplier = 0.2f;
                    pierceArmor = true;
                    trailEffect = new ParticleEffect() {{
                        sizeInterp = Interp.pow5Out;
                        particles = 1;
                        length = 0;
                        baseLength = 0.2f;
                        lifetime = 30;
                        line = true;
                        randLength = false;
                        lenFrom = 13;
                        lenTo = 13;
                        strokeFrom = 4;
                        strokeTo = 0;
                        colorFrom = Color.valueOf("FF795EFF");
                        colorTo = Color.valueOf("FF795E80");
                        cone = 0;
                    }};
                    hitEffect = despawnEffect = Fx.flakExplosion;
                    damage = 0f;
                    splashDamageRadius = 16;
                    splashDamage = 34;
                    status = StatusEffects.blasted;
                    statusDuration = 30;
                    speed = 27;
                    lifetime = 1;
                    fragBullets = 3;
                    fragBullet = new BasicBulletType(0, 0) {{
                        buildingDamageMultiplier = 0.2f;
                        pierceArmor = true;
                        trailEffect = Fx.none;
                        hitEffect = despawnEffect = Fx.flakExplosion;
                        splashDamageRadius = 16;
                        splashDamage = 22;
                        status = StatusEffects.blasted;
                        statusDuration = 30;
                        speed = 29;
                        lifetime = 1;
                        fragBullets = 3;
                        fragBullet = new LightningBulletType() {{
                            damage = 21;
                            buildingDamageMultiplier = 0.007f;
                            lightningLength = 3;
                        }};
                    }};
                }};
            }};

            destroyBullet = new ExplosionBulletType(10f, 160f) {{
                makeFire = true;
                incendAmount = 6;
                splashDamagePierce = true;
                buildingDamageMultiplier = 50;
                lightning = 6;
                lightningDamage = 25;
                lightningLength = 40;
                lightningColor = Color.valueOf("E46B58");
                lightningAngle = 60;
            }};
            destroyEffect = new WaveEffect() {{
                lifetime = 20;
                sizeFrom = 0;
                sizeTo = 160;
                strokeFrom = 2;
                strokeTo = 0;
                colorFrom = colorTo = Color.valueOf("E46B58");
            }};
        }};
        MF = new ItemTurret("埋伏"){{
            requirements(Category.turret, with(Items.thorium, 75, Items.silicon, 90, Items.blastCompound, 25));
            targetAir = false;
            health = 1050;
            size = 3;
            rotateSpeed = 2f;
            range = 400f;
            recoil = 2f;
            maxAmmo = 8;
            shootCone = 15f;
            inaccuracy = 5f;
            shootY = 12f;
            shoot = new ShootPattern(){{
                shots = 1;
            }};
            reload = 180f;
            coolant = consumeCoolant(0.3f);
            ammo(
                    Items.blastCompound, new ArtilleryBulletType(8f, 1){{
                        backColor = hitColor = trailColor = Color.valueOf("FF795E");
                        ammoMultiplier = 4;
                        width = 16f;
                        height = 16f;
                        lifetime = 50f;
                        damage = 1f;
                        pierceBuilding = true;
                        collidesAir = false;
                        collideTerrain = true;
                        fragBullets = 1;
                        fragOnHit = fragOnAbsorb = true;
                        fragBullet = new EmptyBulletType(){{
                            instantDisappear = true;
                            damage = speed = 0f;
                            despawnUnit = LIunits.MF1;
                        }};
                    }},
                    LIitems.GTSY, new ArtilleryBulletType(8f, 1){{
                        backColor = hitColor = trailColor = Color.valueOf("43434F");
                        ammoMultiplier = 4;
                        width = 16f;
                        height = 16f;
                        lifetime = 50f;
                        damage = 1f;
                        pierceBuilding = true;
                        collidesAir = false;
                        collideTerrain = true;
                        fragBullets = 1;
                        fragOnHit = fragOnAbsorb = true;
                        fragBullet = new EmptyBulletType(){{
                            instantDisappear = true;
                            damage = speed = 0f;
                            despawnUnit = LIunits.MF2;
                        }};
                    }},
                    LIitems.SMSP, new ArtilleryBulletType(10f, 1){{
                        backColor = hitColor = trailColor = Color.white;
                        rangeChange = 400f;
                        reloadMultiplier = 0.5f;
                        ammoMultiplier = 1;
                        width = 32f;
                        height = 32f;
                        lifetime = 80f;
                        damage = 1f;
                        pierceBuilding = true;
                        collidesAir = false;
                        collideTerrain = true;
                        fragBullets = 1;
                        fragOnHit = fragOnAbsorb = true;
                        fragBullet = new EmptyBulletType(){{
                            instantDisappear = true;
                            damage = speed = 0f;
                            despawnUnit = LIunits.MF3;
                        }};
                    }}
            );
        }
            @Override
            public void setStats() {
                super.setStats();
                stats.remove(Stat.ammo);

                var turret = this;
                stats.add(Stat.ammo, table -> {
                    table.row();
                    var map = turret.ammoTypes;
                    var orderedKeys = map.keys().toSeq();

                    orderedKeys.sort();
                    orderedKeys.each(t ->{
                        var type = map.get(t);
                        try{
                            StatValues.ammo(ObjectMap.of(t, type.fragBullet.despawnUnit.weapons.first().bullet), false, false).display(table);
                        } catch (Exception ignored) {}
                    });
                });
            }
        };
        BP = new ItemTurret("爆破"){{
            requirements(Category.turret, with( Items.thorium, 125, Items.silicon, 400, Items.blastCompound, 70, LIitems.GTSY, 5));
            targetAir = false;
            health = 4200;
            size = 4;
            range = 560f;
            reload = 20f;
            recoilTime = 45f;
            recoil = 5f;
            inaccuracy = 10f;
            shootCone = 10f;
            shake = 7f;
            rotateSpeed = 1f;
            shootWarmupSpeed = 0.015f;
            warmupMaintainTime = 90f;
            minWarmup = 0.9f;
            maxAmmo = 8;
            shootSound = Sounds.shootTank;
            consumePower(10f);
            coolant = consumeCoolant(1.5f);
            coolantMultiplier = 0.6f;
            shoot = new ShootBarrel(){{
                barrels = new float[]{0f,1f,0f, -9f,-8f,0f, 9f,-8f,0f};
            }};

            ammo(
                    Items.blastCompound, new BasicBulletType(8f, 0f) {{
                        ammoMultiplier = 4;
                        absorbable = reflectable = hittable = collides = false;
                        pierce = true;
                        height = 1f;
                        width = 1f;
                        lifetime = 75f;
                        speed = 8f;
                        damage = 0f;
                        backColor = hitColor = trailColor = Pal.missileYellowBack;
                        frontColor = Pal.missileYellow;
                        intervalBullets = 1;
                        bulletInterval = 2f;
                        intervalBullet = new BasicBulletType(0f, 0f) {{
                            buildingDamageMultiplier = 0.03f;
                            collidesAir = false;
                            instantDisappear = true;
                            damage = 0f;
                            splashDamage = 80f;
                            splashDamageRadius = 32f;
                            status = StatusEffects.blasted;
                            hitEffect = Fx.explosion;
                            hitSound = Sounds.explosion;
                            hitSoundVolume = 0.6f;
                        }};
                    }},
                    LIitems.GTSY, new BasicBulletType(8f, 0f) {{
                        ammoMultiplier = 4;
                        absorbable = reflectable = hittable = collides = false;
                        pierce = true;
                        height = 1f;
                        width = 1f;
                        lifetime = 75f;
                        speed = 8f;
                        damage = 0f;
                        backColor = hitColor = trailColor = Color.valueOf("FF0000");
                        frontColor = Color.valueOf("FF0000");
                        intervalBullets = 1;
                        bulletInterval = 2f;
                        intervalBullet = new BasicBulletType(0f, 0f) {{
                            buildingDamageMultiplier = 0.03f;
                            collidesAir = false;
                            instantDisappear = true;
                            damage = 0f;
                            splashDamage = 160f;
                            splashDamageRadius = 40f;
                            status = StatusEffects.melting;
                            statusDuration = 60f;
                            hitEffect = Fx.explosion;
                            hitSound = Sounds.explosion;
                            hitSoundVolume = 0.6f;
                        }};
                    }}
            );

            drawer = new DrawTurret(){{
                parts.addAll(
                        new RegionPart("-mid") {{
                            mirror = false;
                            heatColor = Color.valueOf("FDDDC7FF");
                            heatProgress = PartProgress.warmup;
                            moveY = 0;
                        }},
                        new RegionPart("-side") {{
                            mirror = true;
                            heatColor = Color.valueOf("FDDDC780");
                            heatProgress = PartProgress.warmup;
                            moveX = 2;
                            moveY = 0;
                        }},
                        new HaloPart() {{
                            shapeRotation = 60f;
                            y = -12f;
                            sides = 3;
                            shapes = 2;
                            color = Color.valueOf("FEB380");
                            colorTo = Color.valueOf("FDDDC7");
                            tri = hollow = true;
                            radius = 0f;
                            radiusTo = 6f;
                            triLength = 0f;
                            triLengthTo = 25f;
                            haloRadius = 0f;
                            haloRotation = 0f;
                            layer = 110;
                        }},
                        new HaloPart() {{
                            shapeRotation = 30f;
                            y = -12f;
                            sides = 3;
                            shapes = 2;
                            color = Color.valueOf("FEB380");
                            colorTo = Color.valueOf("FDDDC7");
                            tri = hollow = true;
                            radius = 0f;
                            radiusTo = 6f;
                            triLength = 0f;
                            triLengthTo = 25f;
                            haloRadius = 0f;
                            haloRotation = 90f;
                            layer = 110;
                        }},
                        new HaloPart() {{
                            shapeRotation = 0f;
                            y = -24f;
                            sides = 3;
                            shapes = 2;
                            color = Color.valueOf("FEB380");
                            colorTo = Color.valueOf("FDDDC7");
                            tri = hollow = true;
                            radius = 0f;
                            radiusTo = 5f;
                            triLength = 0f;
                            triLengthTo = 6f;
                            haloRadius = 0f;
                            haloRotation = 0f;
                            layer = 110;
                        }},
                        new ShapePart() {{
                            y = 16f;
                            color = Color.valueOf("FDDDC7");
                            radius = 0f;
                            radiusTo = 4f;
                            stroke = 0f;
                            strokeTo = 1f;
                            circle = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new ShapePart() {{
                            y = 16f;
                            color = Color.valueOf("FDDDC7");
                            radius = 0f;
                            radiusTo = 2f;
                            stroke = 0f;
                            strokeTo = 1f;
                            hollow = true;
                            rotateSpeed = 3f;
                            layer = 110;
                        }},
                        new ShapePart() {{
                            x = 8f;
                            y = 4f;
                            color = Color.valueOf("FDDDC7");
                            radius = 0f;
                            radiusTo = 4f;
                            stroke = 0f;
                            strokeTo = 1f;
                            circle = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new ShapePart() {{
                            x = 8f;
                            y = 4f;
                            color = Color.valueOf("FDDDC7");
                            radius = 0f;
                            radiusTo = 2f;
                            stroke = 0f;
                            strokeTo = 1f;
                            hollow = true;
                            rotateSpeed = 3f;
                            layer = 110;
                        }},
                        new ShapePart() {{
                            x = -8f;
                            y = 4f;
                            color = Color.valueOf("FDDDC7");
                            radius = 0f;
                            radiusTo = 4f;
                            stroke = 0f;
                            strokeTo = 1f;
                            circle = true;
                            hollow = true;
                            layer = 110;
                        }},
                        new ShapePart() {{
                            x = -8f;
                            y = 4f;
                            color = Color.valueOf("FDDDC7");
                            radius = 0f;
                            radiusTo = 2f;
                            stroke = 0f;
                            strokeTo = 1f;
                            hollow = true;
                            rotateSpeed = 3f;
                            layer = 110;
                        }}
                );
            }};
        }};
        //极光
        ZBPT = new PowerTurret("作弊炮塔"){{
            requirements(Category.turret, BuildVisibility.sandboxOnly, with());
            connectedPower = false;
            health = 555555;
            armor = 666666;
            range = 12000f;
            reload = recoilTime = 60f;
            shoot = new ShootPattern();
            shootSound = LIaudio.FFF;
            shootType = new BasicBulletType(25f, 114514){{
                buildingDamageMultiplier = 10;
                width = 36f;
                height = 72f;
                splashDamage = 1919810f;
                splashDamageRadius = 12000f;
                splashDamagePierce = true;
                speed = 25f;
                lifetime = 400f;
                hitSound = LIaudio.FFF;
                hitSoundVolume = 0.8f;
            }};
        }};

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
        JXLTCG = new LiquidRouter("巨型储液罐"){{
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
