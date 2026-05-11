package LI;

import arc.Events;
import arc.util.*;
import mindustry.mod.*;
import LI.content.*;
import LI.type.ai.LIcommands;

import static mindustry.game.EventType.*;

public class LIMod extends Mod{

    public LIMod(){
        Log.info("Loading: Liquid Industry Java Version");
        Events.on(ContentInitEvent.class, e -> {
            LIoverride.loadOverride(); //WIP
        });
    }

    @Override
    public void loadContent(){
        LIsoundsAndMusic.load();
        LIcommands.load();
        LIweathers.load();
        LIplanets.load(); //未添加卫星
        LImaps.load(); //WIP
        LIitems.load();
        LIliquids.load();
        LIstatus.load();
        LIunits.load(); //导弹未添加
        LIblocks.load(); //部分方块未添加
    }
}
