package LI.type.blocks.effect;

import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.struct.Seq;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.Vars;
import mindustry.entities.*;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Unit;
import mindustry.type.StatusEffect;
import mindustry.world.blocks.defense.OverdriveProjector;
import mindustry.graphics.*;
import mindustry.world.meta.*;

public class StatusProjector extends OverdriveProjector {
    public Seq<StatusEffect> status = new Seq<>();
    public Effect applyEffect;
    public Color applyColor;

    public boolean applyOnEnemies = false;

    public StatusProjector(String name){
        super(name);
        range = 120f;
        useTime = 600f;
        reload = 240f;
        hasBoost = false;
        hasItems = false;
        canOverdrive = false;
        lightRadius = range * 1.1f;
        applyColor = status.size == 1 ? status.first().color : applyOnEnemies ? Color.gray : Color.white;
        applyEffect = new WaveEffect(){{
            sizeTo = range;
            colorFrom = colorTo = applyColor;
        }};

    }

    public void setStatus(StatusEffect... effects){
        status.addAll(effects);
    };

    @Override
    public void setStats() {
        super.setStats();
        stats.remove(Stat.speedIncrease);
        stats.remove(Stat.productionTime);
        String statusStr = "";
        for(var s : status){
            statusStr += (s.hasEmoji() ? s.emoji() : "") + "[stat]" + s.localizedName + " ";
        }
        stats.add(new Stat("status", StatCat.function), statusStr);
        stats.add(new Stat("statustime", StatCat.function), reload / 60, StatUnit.seconds);
        stats.add(new Stat("statusduration", StatCat.function), useTime / 60, StatUnit.seconds);
    }

    @Override
    public void setBars() {
        super.setBars();
        removeBar("boost");
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        drawPotentialLinks(x, y);
        drawOverlay(x * Vars.tilesize + offset, y * Vars.tilesize + offset, rotation);
        Drawf.dashCircle(x * Vars.tilesize + offset, y * Vars.tilesize + offset, range, applyColor);
    }

    public class StatusProjectorBuild extends OverdriveBuild{
        Seq<Unit> targets = new Seq<Unit>();
        float refresh;
        boolean done;

        @Override
        public void updateTile(){
            done = false;
            if(efficiency > 0 && (refresh += delta() * efficiency) >= reload){
                targets.clear();
                if(applyOnEnemies){
                    Units.nearbyEnemies(team, x, y, range, u -> {
                        targets.add(u);
                        if(!done) done = true;
                    });
                }else{
                    Units.nearby(team, x, y, range, u -> {
                        targets.add(u);
                        if(!done) done = true;
                    });
                }
            }

            if(refresh > reload) refresh = reload;

            if(done){
                refresh = 0;
                applyEffect.at(x, y);
                for(var u : targets){
                    for(var s : status){
                        u.apply(s, useTime);
                    }
                }
            }
        }

        @Override
        public void draw() {
            Draw.rect(region, x, y, 0);
            float f = 1f - (Time.time / 100f) % 1f;
            Draw.alpha(1);
            Draw.color(applyColor);
            Lines.stroke((2f * f + 0.2f) * efficiency);
            Lines.square(x, y, Math.min(1 + (1 - f) * size * Vars.tilesize / 2, (float) (size * Vars.tilesize) / 2));

            Draw.reset();
        }

        @Override
        public void drawSelect() {
            Drawf.dashCircle(x, y, range, applyColor);
        }

        @Override
        public void write(Writes write) {
            write.f(refresh);
        }

        @Override
        public void read(Reads read, byte revision) {
            refresh = read.f();
        }
    }
}
