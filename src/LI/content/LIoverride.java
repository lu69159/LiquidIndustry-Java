package LI.content;

import mindustry.content.Items;
import mindustry.type.UnitType;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.units.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Blocks.*;

public class LIoverride {
    public static void loadOverride(){
        //region 地形
        ((Floor)hotrock).attributes.set(LIattr.cryofluid, -0.75f);
        ((Floor)magmarock).attributes.set(LIattr.cryofluid, -1f);
        ((Floor)snow).attributes.set(LIattr.cryofluid, 0.15f);
        ((Floor)iceSnow).attributes.set(LIattr.cryofluid, 0.3f);
        ((Floor)ice).attributes.set(LIattr.cryofluid, 0.5f);

        //region 液体相关
        liquidContainer.liquidCapacity = 1000f;
        liquidTank.liquidCapacity = 3000f;
        ((LiquidBridge)bridgeConduit).range = 6;
        ((LiquidBridge)phaseConduit).range = 24;

        //region 单位制造
        ((UnitFactory)navalFactory).plans.add(new UnitFactory.UnitPlan(LIunits.SM, 60 * 30f, with(Items.silicon, 10, LIitems.QSZ, 12)));
        ((Reconstructor)additiveReconstructor).upgrades.add(new UnitType[]{LIunits.SM, LIunits.FZ});
        ((Reconstructor)multiplicativeReconstructor).upgrades.add(new UnitType[]{LIunits.FZ, LIunits.HL});
        ((Reconstructor)exponentialReconstructor).upgrades.add(new UnitType[]{LIunits.HL, LIunits.DY});
        ((Reconstructor)tetrativeReconstructor).upgrades.add(new UnitType[]{LIunits.DY, LIunits.JX});
    };
}
