package LI.content;

import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.gen.Unit;
import mindustry.entities.Effect;
import mindustry.entities.effect.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;

import static LI.content.LIfx.color.*;

public class LIfx {
    public static class color{
        public static final Color
            sparkColor = Color.valueOf("00FFFF"),
            sparkColorBack = Color.valueOf("8EFFEA");
    }

    public static final Effect
    sparkBomb = new Effect(15, 100, e -> {
        color(sparkColorBack);
        stroke(e.fout() * 4);
        circle(e.x, e.y, 4 + e.finpow() * 20);
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 6, 80 * e.fout(), i*90 + 45);
        }
        color();
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 3, 30 * e.fout(), i*90 + 45);
        }
        Drawf.light(e.x, e.y, 150f, sparkColorBack, 0.9f * e.fout());
    }),
    sparkTrail = new Effect(30, e -> {
        for(int i = 0; i < 2; i++){
            color(i == 0 ? sparkColorBack : sparkColor);

            float m = i == 0 ? 1f : 0.5f;
            float rot = e.rotation + 180f;
            float w = 15f * e.fout() * m;
            Drawf.tri(e.x, e.y, w, (30f + Mathf.randomSeedRange(e.id, 15f)) * m, rot);
            Drawf.tri(e.x, e.y, w, 10f * m, rot + 180f);
        }
        Drawf.light(e.x, e.y, 60f, sparkColor, 0.6f * e.fout());
    }),
    sparkShoot = new Effect(24f, e -> {
        e.scaled(10f, b -> {
            color(Color.white, sparkColorBack, b.fin());
            stroke(b.fout() * 3f + 0.2f);
            circle(b.x, b.y, b.fin() * 50f);
        });
        color(sparkColorBack);
        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 13f * e.fout(), 85f, e.rotation + 90f * i);
            Drawf.tri(e.x, e.y, 13f * e.fout(), 50f, e.rotation + 20f * i);
        }
        Drawf.light(e.x, e.y, 180f, sparkColorBack, 0.9f * e.fout());
    }),
    sparkHit = new Effect(20f, 200f, e -> {
        color(sparkColorBack);

        for(int i = 0; i < 2; i++){
            color(i == 0 ? sparkColorBack : sparkColor);

            float m = i == 0 ? 1f : 0.5f;

            for(int j = 0; j < 5; j++){
                float rot = e.rotation + Mathf.randomSeedRange(e.id + j, 50f);
                float w = 23f * e.fout() * m;
                Drawf.tri(e.x, e.y, w, (80f + Mathf.randomSeedRange(e.id + j, 40f)) * m, rot);
                Drawf.tri(e.x, e.y, w, 20f * m, rot + 180f);
            }
        }

        e.scaled(10f, c -> {
            color(sparkColor);
            stroke(c.fout() * 2f + 0.2f);
            circle(e.x, e.y, c.fin() * 30f);
        });

        e.scaled(12f, c -> {
            color(sparkColorBack);
            randLenVectors(e.id, 25, 5f + e.fin() * 80f, e.rotation, 60f, (x, y) -> {
                Fill.square(e.x + x, e.y + y, c.fout() * 3f, 45f);
            });
        });
    }),
    whiteRailShoot = new Effect(24f, e -> {
        e.scaled(10f, b -> {
            color(Color.white, Color.lightGray, b.fin());
                stroke(b.fout() * 3f + 0.2f);
                Lines.circle(b.x, b.y, b.fin() * 50f);
            });
        color(Color.white);
        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 13f * e.fout(), 85f, e.rotation + 90f * i);
        }
    }),
    whiteRailTrail = new Effect(16f, e -> {
        color(Color.white);
        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 10f * e.fout(), 24f, e.rotation + 90 + 90f * i);
        }
        Drawf.light(e.x, e.y, 60f * e.fout(), Color.white, 0.5f);
    }),
    whiteRailHit = new Effect(18f, 200f, e -> {
        color(Color.white);
        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 10f * e.fout(), 60f, e.rotation + 140f * i);
        }
    }),
    surgeAlloyShoot = new Effect(12, e -> {
        Draw.color(Color.white, Pal.surge, e.fin());
        Lines.stroke(e.fout() * 1.2f + 0.5f);

        Angles.randLenVectors(e.id, 7, 25 * e.finpow(), e.rotation, 50f, (x, y) -> {
                Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fin() * 5f + 2f);
        });
    }),
    blessApply = new Effect(120f, e -> {
        Unit unit = (Unit) e.data;
        var region = unit.type.fullIcon;
        color(e.color);
        alpha(e.fout() * 1);
        rect(region, unit.x, unit.y, region.width * 0.8f, region.height * 0.8f, unit.rotation - 90);
    }),
    moderateReactorExplosion = new MultiEffect(
        new WaveEffect(){{
            lifetime = 20f;
            sizeFrom = 0f;
            sizeTo = 300f;
            strokeFrom = 16f;
            strokeTo = 0f;
            colorFrom = Color.valueOf("A97BFF");
            colorTo = Color.white;
        }},
        new ParticleEffect(){{
            lifetime = 480;
            particles = 30;
            interp = Interp.pow5Out;
            sizeInterp = Interp.pow3In;
            sizeFrom = 40;
            sizeTo = 0;
            length = 250;
            baseLength = 0;
            colorFrom = Color.valueOf("A97BFF80");
            colorTo = Color.valueOf("A97BFF00");
        }},
        new ParticleEffect(){{
            lifetime = 50;
            particles = 20;
            line = true;
            interp = Interp.pow3Out;
            sizeInterp = Interp.pow2In;
            strokeFrom = 2f;
            strokeTo = 0f;
            lenFrom = 120f;
            lenTo = 0f;
            length = 180f;
            baseLength = 40f;
            colorFrom = Color.valueOf("C9A0FF");
            colorTo = Color.valueOf("C9A0FF");
        }}
    ),
    deflagExplosion = new MultiEffect(
        new WaveEffect(){{
            lifetime = 30f;
            sizeFrom = 0f;
            sizeTo = 512f;
            strokeFrom = 18f;
            strokeTo = 0f;
            colorFrom = Color.red;
            colorTo = Color.white;
        }},
        new ParticleEffect(){{
            lifetime = 600;
            particles = 25;
            interp = Interp.pow10Out;
            sizeFrom = 40;
            sizeTo = 0;
            length = 512;
            baseLength = 40;
            colorFrom = Color.red;
            colorTo = Color.valueOf("FFFFFF80");
        }},
        new ParticleEffect(){{
            lifetime = 600;
            particles = 75;
            interp = Interp.pow5Out;
            sizeFrom = 40;
            sizeTo = 0;
            length = 512;
            baseLength = 15;
            colorFrom = Color.red;
            colorTo = Color.valueOf("FFFFFF80");
        }}
    );

}
