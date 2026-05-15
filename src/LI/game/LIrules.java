package LI.game;

import arc.Events;
import mindustry.game.Rules;
import LI.content.LIplanets;

import static mindustry.Vars.*;
import static mindustry.game.EventType.*;

public class LIrules {
    public LIrules(){
        Events.on(SectorLaunchEvent.class, (e) -> { setRules(); });
        Events.on(SaveLoadEvent.class, (e) -> { setRules(); });
    }

    public void setRules(){
        if(state.isCampaign() && state.rules.planet == LIplanets.NT && state.rules.sector != null){
            Rules rule = new Rules();
            state.rules.sector.preset.rules.get(rule);
            if(state.rules.sector.isCaptured() && rule.attackMode) rule.attackMode = false;
            state.rules = rule;
        }
    }
}
