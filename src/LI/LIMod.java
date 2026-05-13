package LI;

import arc.Events;
import arc.util.*;
import mindustry.mod.*;
import LI.type.ai.LIcommands;
import LI.content.*;
import LI.tech.ATD;

import static mindustry.game.EventType.*;

public class LIMod extends Mod{

    public LIMod(){
        Log.info("Loading: Liquid Industry Java Version");
        Events.on(ContentInitEvent.class, e -> {
            LIoverride.loadOverride(); //WIP
            ATD.load();
        });
    }

    @Override
    public void loadContent(){
        LIaudio.load();
        LIcommands.load();
        LIweathers.load();
        LIplanets.load(); //未添加卫星
        LImaps.load();
        LIitems.load();
        LIliquids.load();
        LIstatus.load();
        LIunits.load(); //导弹未添加
        LIblocks.load(); //部分方块未添加
    }
}
