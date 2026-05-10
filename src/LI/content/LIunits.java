package LI.content;

import arc.func.Cons;
import arc.graphics.Color;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.content.*;
import mindustry.ctype.UnlockableContent;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.type.weapons.*;
import mindustry.type.*;
import mindustry.gen.Sounds;
import LI.type.ai.*;
import mindustry.world.Block;
import mindustry.world.blocks.units.Reconstructor;

import static mindustry.content.UnitTypes.*;
import static mindustry.Vars.*;

public class LIunits {
    public static UnitType
    //导弹
    //TF1,TF2,

    //纯辅助
    JZQ,XFQ,ZLQ,ZTQ,

    //核心
    JS,GMS,DET,

    //悬浮
    SM,FZ,HL,DY,JX,YA

    ;

    public static void load(){

        //region 纯辅助
        JZQ = new UnitType("建造球"){{
            constructor = flare.constructor;
            controller = u -> new BuilderAI(true, 400f);
            defaultCommand = UnitCommand.rebuildCommand;
            flying = true;
            faceTarget = true;
            isEnemy = false;
            health = 1000f;
            hitSize = 4f;
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            itemCapacity = 0;
            fogRadius = 0f;
            trailLength = 10;
            trailColor = Color.valueOf("B0BAC0");
            outlineColor = Color.valueOf("00000000");

            buildSpeed = 0.4f;
        }};
        XFQ = new UnitType("修复球"){{
            constructor = flare.constructor;
            controller = u -> new RepairAI();
            defaultCommand = UnitCommand.repairCommand;
            flying = true;
            faceTarget = true;
            isEnemy = false;
            health = 1000f;
            hitSize = 4f;
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            itemCapacity = 0;
            fogRadius = 0f;
            trailLength = 10;
            trailColor = Color.valueOf("FFD3D7");
            outlineColor = Color.valueOf("00000000");

            weapons.add(new Weapon(){{
                x = y = shootY = 0f;
                mirror = false;
                reload = 20f;
                bullet = new BasicBulletType(15f,0f){{
                    collidesTeam = true;
                    collidesAir = collidesGround =false;
                    lifetime = 16f;
                    width = 4f;
                    height = 14f;
                    trailLength = 2;
                    healPercent = 5f;
                    frontColor = Color.valueOf("84F491");
                    backColor = trailColor = Color.valueOf("6BC583");
                    hitEffect = despawnEffect = new WaveEffect(){{
                        lifetime = 16f;
                        sizeFrom = 1f;
                        sizeTo = 8f;
                        strokeFrom = 1f;
                        strokeTo = 0f;
                        colorFrom = Color.valueOf("84F491");
                        colorTo = Color.valueOf("84F49139");
                    }};
                }};
            }});
        }};
        ZLQ = new UnitType("治疗球"){{
            constructor = flare.constructor;
            controller = u -> u.team.isAI() ? new HealAI():new HealAI(true, 480f);
            commands.add(UnitCommand.moveCommand, UnitCommand.enterPayloadCommand, LIcommands.healCommand);
            defaultCommand = LIcommands.healCommand;
            flying = true;
            faceTarget = true;
            isEnemy = false;
            health = 1000f;
            hitSize = 4f;
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            itemCapacity = 0;
            fogRadius = 0f;
            trailLength = 10;
            trailColor = Color.valueOf("84F491");
            outlineColor = Color.valueOf("00000000");

            weapons.add(new RepairBeamWeapon(){{
                x = y = shootY = 0f;
                mirror = false;
                repairSpeed = 1.8f;
                healColor = Color.valueOf("84F491");
            }});
        }};
        ZTQ = new UnitType("状态球"){{
            constructor = flare.constructor;
            controller = u -> new DefenderAI();
            flying = true;
            faceTarget = true;
            isEnemy = false;
            health = 1000f;
            hitSize = 4f;
            speed = 2.7f;
            accel = 0.08f;
            drag = 0.04f;
            itemCapacity = 0;
            fogRadius = 0f;
            trailLength = 10;
            trailColor = Color.valueOf("F23A3A");
            outlineColor = Color.valueOf("00000000");

            abilities.add(new StatusFieldAbility(StatusEffects.shielded, 600f, 600f, 144f));
            abilities.add(new StatusFieldAbility(StatusEffects.overclock, 600f, 600f, 144f));
        }};

        //region 核心
        JS = new UnitType("基石"){{
            constructor = gamma.constructor;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            flying = true;
            faceTarget = true;
            isEnemy = false;
            lowAltitude = true;
            health = 50f;
            hitSize = 4f;
            rotateSpeed = 8f;
            speed = 2f;
            accel = 0.1f;
            drag = 0.05f;
            itemCapacity = 0;
            fogRadius = 0f;
            range = 80f; //虽然不知道加了有啥用但还是加了（）

            buildRange = 80f;
            buildSpeed = 0.2f;
            engineSize = 2f;
            engineOffset = 3.7f;
            mineTier = 1;
            mineSpeed = 3.5f;
        }};
        GMS = new UnitType("伽马-S"){{
            constructor = gamma.constructor;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            flying = true;
            faceTarget = true;
            isEnemy = false;
            lowAltitude = true;
            health = 280f;
            hitSize = 11f;
            rotateSpeed = 20f;
            speed = 3.6f;
            accel = 0.11f;
            drag = 0.05f;
            itemCapacity = 75;
            fogRadius = 0f;

            buildSpeed = 1.05f;
            engineOffset = 6f;
            mineTier = 2;
            mineSpeed = 8.5f;

            immunities.addAll(StatusEffects.freezing, LIstatus.XM);
            abilities.add(new EnergyFieldAbility(20f, 90f, 120f){{
                hitUnits = hitBuildings = targetAir = targetGround = true;
                color = Color.valueOf("00FFFFEF");
                effectRadius = 1f;
                maxTargets = 3;
                healPercent = 0.5f;
                sameTypeHealMult = 0.5f;
                shootSound = Sounds.shootArc;
                status = StatusEffects.shocked;
            }});

            weapons.add(new Weapon("伽马-S1"){{
                top = false;
                reload = 15f;
                x = 1f;
                y = 2f;
                inaccuracy = 3f;
                ejectEffect = Fx.casing1;

                shoot = new ShootSpread(2, 2f){{ shotDelay = 3f; }};
                bullet = new BasicBulletType(3.5f, 11f){{
                    lifetime = 70f;
                    width = 6.5f;
                    height = 11f;
                    homingPower = 0.04f;
                    buildingDamageMultiplier = 0.01f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    status = StatusEffects.shocked;
                }};
            }});
        }};
        DET = new UnitType("伽马-S"){{
            constructor = mega.constructor;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            flying = true;
            faceTarget = false;
            isEnemy = false;
            lowAltitude = true;
            health = 520f;
            hitSize = 16f;
            rotateSpeed = 20f;
            speed = 3.7f;
            accel = 0.06f;
            drag = 0.017f;
            itemCapacity = 90;
            payloadCapacity = 2 * 2 * tilePayload;
            fogRadius = 0f;

            buildSpeed = 2.6f;
            engineSize = 3f;
            engineOffset = 10.5f;
            mineTier = 3;
            mineSpeed = 9.5f;

            immunities.addAll(StatusEffects.freezing, LIstatus.XM);
            abilities.add(new EnergyFieldAbility(30f, 90f, 160f){{
                hitUnits = hitBuildings = targetAir = targetGround = true;
                color = Color.valueOf("00FFFFEF");
                effectRadius = 2f;
                maxTargets = 8;
                healPercent = 1f;
                sameTypeHealMult = 0.5f;
                shootSound = Sounds.shootArc;
                status = StatusEffects.shocked;
            }});

            weapons.add(
                new Weapon("德尔塔1"){{
                    shootSound = Sounds.shootLaser;
                    reload = 12f;
                    x = 8f;
                    y = -6f;
                    rotate = true;
                    bullet = new LaserBoltBulletType(5.2f, 15){{
                        lifetime = 35f;
                        healPercent = 5f;
                        homingPower = 0.04f;
                        buildingDamageMultiplier = 0.01f;
                        collidesTeam = true;
                        backColor = Color.valueOf("00FFFFEF");
                        frontColor = Color.white;
                        status = StatusEffects.shocked;
                    }};
                }},
                new Weapon("德尔塔1"){{
                    shootSound = Sounds.shootLaser;
                    reload = 7.5f;
                    x = 4f;
                    y = 5f;
                    rotate = true;
                    bullet = new LaserBoltBulletType(5.2f, 10f){{
                        lifetime = 35f;
                        healPercent = 3f;
                        homingPower = 0.04f;
                        buildingDamageMultiplier = 0.01f;
                        collidesTeam = true;
                        backColor = Color.valueOf("00FFFFEF");
                        frontColor = Color.white;
                        status = StatusEffects.shocked;
                    }};
                }}
            );
        }};

        //region 悬浮
        SM = new HoverTank("水黾");

    }

    public static class HoverTank extends UnitType{
        public HoverTank(String name) {
            super(name);
            constructor = elude.constructor;
        }

        @Override
        public void getDependencies(Cons<UnlockableContent> cons) {
            Block r1 = LIblocks.BCJDWZGGC, r2 = LIblocks.DMJDWZGGC, r3 = LIblocks.WLJDWZGGC;
            for(Block block : content.blocks()){
                if(block instanceof Reconstructor r && r != r1 && r != r2 && r != r3){
                    for(UnitType[] recipe : r.upgrades){
                        if(recipe[1] == this){
                            cons.get(block);
                        }
                    }
                }
            }

            for(ItemStack stack : researchRequirements()){
                cons.get(stack.item);
            }
        }
    }
}
