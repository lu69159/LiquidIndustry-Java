package LI;

import arc.util.*;
import mindustry.mod.*;

import LI.content.*;

public class LIMod extends Mod{

    public LIMod(){
        Log.info("Loading: Liquid Industry Java Version");
    }

    @Override
    public void loadContent(){
        LIitems.load();
        LIliquids.load();
        LIstatus.load();
        LIblocks.load();
        LIunits.load();
    }
}
