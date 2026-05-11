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
import mindustry.world.meta.BlockFlag;

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
        SM = new HoverTank("水黾"){{ //海军工厂制造添加
            faceTarget = targetAir = false;
            health = 220f;
            armor = 6f;
            hitSize = 9f;
            rotateSpeed = 12f;
            speed = 3.6f;
            accel = 0.2f;
            itemCapacity = 0;

            weapons.add(new Weapon("水黾1"){{
                rotate = true;
                mirror = false;
                reload = 20f;
                recoil = 0.5f;
                x = y = 0f;
                rotateSpeed = 12f;
                ejectEffect = Fx.sparkShoot;
                shootSound = Sounds.shootArc;
                bullet = new LightningBulletType(){{
                    damage = 15f;
                    lightningLength = 25;
                    collidesAir = false;
                }};
            }});
        }};
        FZ = new HoverTank("筏蛛"){{
            faceTarget = false;
            health = 640f;
            armor = 10f;
            hitSize = 15f;
            rotateSpeed = 8f;
            speed = 2f;
            accel = 0.15f;
            itemCapacity = 10;

            weapons.add(new Weapon("筏蛛1"){{
                rotate = true;
                mirror = false;
                reload = 135f;
                recoil = 1f;
                x = y = 0f;
                rotateSpeed = 1.5f;
                ejectEffect = Fx.lancerLaserShoot;
                shootSound = Sounds.shootLancer;
                bullet = new LaserBulletType(160f){{
                    length = 220f;
                    width = 16f;
                    pierceCap = 4;
                    hitSize = 4f;
                    hitEffect = Fx.hitLaser;
                }};
            }});
        }};
        HL = new HoverTank("河狸"){{
            faceTarget = false;
            health = 2300f;
            armor = 16f;
            hitSize = 20f;
            rotateSpeed = 2.5f;
            speed = 1.1f;
            accel = 0.08f;
            itemCapacity = 30;

            weapons.add(new Weapon("河狸1"){{
                rotate = true;
                mirror = false;
                cooldownTime = 120f;
                reload = 360f;
                recoil = 3f;
                x = y = 0f;
                shootY = 15f;
                rotateSpeed = 1f;
                shake = 6f;
                shootSound = Sounds.shootCorvus;
                bullet = new LaserBulletType(505f){{
                    length = 300f;
                    width = 40f;
                    sideAngle = 30f;
                    hitEffect = Fx.hitLaser;

                    lightningSpacing = 20f;
                    lightningLength = 3;
                    lightningLengthRand = 12;
                    lightningDelay = 0.1f;
                    lightningDamage = 15f;
                    lightningAngleRand = 45f;
                    lightningColor = Color.valueOf("FFFFFFA0");
                }};
            }});
        }};
        DY = new HoverTank("电鳐"){{
            faceTarget = false;
            health = 10500f;
            armor = 24f;
            hitSize = 35f;
            rotateSpeed = 2.5f;
            speed = 0.65f;
            accel = 0.07f;
            itemCapacity = 50;
            immunities.add(StatusEffects.burning);

            abilities.add(new EnergyFieldAbility(220f, 75f, 260f){{
                color = Color.valueOf("8AA3F4");
                sectors = 1;
                sectorRad = 1f;
                maxTargets = 12;
                healPercent = 3f;
                sameTypeHealMult = 1/3f;
                status = StatusEffects.shocked;
            }});

            weapons.add(
                new Weapon("电鳐1"){{
                    rotate = continuous = true;
                    mirror = false;
                    cooldownTime = 150f;
                    reload = 150f;
                    x = y = 0f;
                    shootY = 4f;
                    rotateSpeed = 2f;
                    shootSound = Sounds.beamMeltdown;

                    bullet = new ContinuousLaserBulletType(32f){{
                        largeHit = false;
                        pierceArmor = true;
                        colors = new Color[]{Color.white, Color.valueOf("FFFFFF70")};
                        lifetime = 180f;
                        incendAmount = 0;
                        width = 4f;
                        length = 144f;
                        maxRange = 120f;
                        shake = 2f;
                        shootEffect = Fx.shootHeal;
                        hitEffect = Fx.hitMeltdown;
                        status = StatusEffects.shocked;
                    }};
                }},
                new Weapon("电鳐2"){{
                    rotate = true;
                    reload = 30f;
                    x = 13.25f;
                    y = -12f;
                    shootX = shootY = 0f;
                    rotateSpeed = 9f;
                    ejectEffect = Fx.sparkShoot;
                    bullet = new BasicBulletType(12f, 0f){{
                        frontColor = Color.white;
                        backColor = trailColor =Color.valueOf("FFFFFF80");
                        lifetime = 21 + 2/3f;
                        trailLength = 4;
                        trailWidth = 2f;
                        width = 18f;
                        height = 18f;
                        splashDamage = 5f;
                        splashDamageRadius = 64f;
                        homingPower = 0.1f;
                        homingRange = 40f;
                        status = StatusEffects.wet;
                        statusDuration = 300f;
                        hitSound = despawnSound = Sounds.shootArc;
                        hitEffect = despawnEffect = new WaveEffect(){{
                            lifetime = 15f;
                            sizeFrom = 1f;
                            sizeTo = 32f;
                            strokeFrom = 3f;
                            strokeTo = 0f;
                            colorFrom = Color.white;
                            colorTo = Color.valueOf("FFFFFF39");
                        }};

                        fragBullets = 8;
                        fragBullet = new LightningBulletType(){{
                            lightningLength = 15;
                            lightningColor = Color.white;
                            damage = 20f;
                        }};
                    }};
            }});
        }};
        JX = new HoverTank("巨蟹");

    }

    public static class HoverTank extends UnitType{
        public HoverTank(String name) {
            super(name);
            drag = 0.05f;
            hovering = true;
            canDrown = false;
            constructor = elude.constructor;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.core, null};
            immunities.addAll(StatusEffects.wet, StatusEffects.freezing);
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
