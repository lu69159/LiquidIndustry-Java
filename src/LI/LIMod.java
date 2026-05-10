package LI;

import LI.type.ai.LIcommands;
import arc.util.*;
import mindustry.mod.*;

import LI.content.*;

public class LIMod extends Mod{

    public LIMod(){
        Log.info("Loading: Liquid Industry Java Version");
    }

    @Override
    public void loadContent(){
        LIcommands.load();
        LIplanets.load(); //WIP
        LImaps.load(); //WIP
        LIitems.load();
        LIliquids.load();
        LIstatus.load();
        LIblocks.load(); //WIP
        LIunits.load(); //WIP
    }
}
