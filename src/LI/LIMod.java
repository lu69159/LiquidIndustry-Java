package LI;

import arc.Events;
import arc.util.*;
import mindustry.mod.*;
import LI.content.tech.LItechTree;
import LI.game.LIrules;
import LI.ui.dialogs.*;
import LI.type.ai.LIcommands;
import LI.content.*;
import LI.content.tech.ATD;

import static mindustry.game.EventType.*;
import static mindustry.Vars.*;

public class LIMod extends Mod{
    public LIstartDialog start;
    public LIrules rules;

    public LIMod(){
        Log.info("Loading: Liquid Industry Java Version");
        Events.on(ContentInitEvent.class, e -> {
            LIoverride.loadOverride(); //WIP
            ATD.load();
        });
    }

    @Override
    public void init() {
        rules = new LIrules();
        start = new LIstartDialog();
        ui.research = new LIresearchDialog();
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
        LIblocks.load(); //部分方块未添加，炮塔添加中
        LItechTree.load(); //未添加的内容无法加入
    }
}
