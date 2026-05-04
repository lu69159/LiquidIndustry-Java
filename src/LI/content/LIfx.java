package LI.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.math.Interp;
import arc.math.Mathf;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Unit;
import mindustry.graphics.Drawf;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;

public class LIfx {
    static Color sparkColor = Color.valueOf("00FFFF");
    static Color sparkColorBack = Color.valueOf("8EFFEA");

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
    blessApply = new Effect(120f, e -> {
        Unit unit = (Unit) e.data;
        var region = unit.type.fullIcon;
        color(e.color);
        alpha(e.fout() * 1);
        rect(region, unit.x, unit.y, region.width * 0.8f, region.height * 0.8f, unit.rotation - 90);
    }),
    moderateReactorExplosion = new Effect(480f, 300f, e -> {

        e.scaled(20f, wave -> {
            float fin = wave.fin();
            color(Color.valueOf("A97BFF"), Color.valueOf("FFFFFF"), fin);
            stroke(Interp.pow5Out.apply(16f, 0f, fin));
            circle(e.x, e.y, Interp.pow5Out.apply(0f, 300f, fin));
        });

        e.scaled(480f, particles1 -> {
            float fin = particles1.fin();
            color(Color.valueOf("A97BFF80"), Color.valueOf("A97BFF00"), fin);

            rand.setSeed(e.id);
            for(int i = 0; i < 30; i++){
                float l = 250f * fin;
                float angle = rand.range(180f);
                float dist = rand.random(l);
                float x = e.x + trnsx(angle, dist);
                float y = e.y + trnsy(angle, dist);

                float size = Interp.pow3In.apply(40f, 0f, fin) * 2;
                rect(Core.atlas.find("circle"), x, y, size, size);
            }
        });

        e.scaled(50f, particles2 -> {
            float fin = particles2.fin();
            color(Color.valueOf("C9A0FF"));
            stroke(Interp.pow2In.apply(2f, 0f, fin));

            rand.setSeed(e.id + 100);
            for(int i = 0; i < 20; i++){
                float l = 180f * fin + 40f;
                float angle = rand.range(180f);
                float dist = rand.random(l);
                float x = e.x + trnsx(angle, dist);
                float y = e.y + trnsy(angle, dist);

                float len = Interp.pow2In.apply(120f, 0f, fin);
                lineAngle(x, y, Mathf.angle(x - e.x, y - e.y), len, true);
            }
        });
    }),
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
            particles = 25;
            interp = Interp.pow10Out;
            sizeFrom = 40;
            sizeTo = 0;
            length = 512;
            baseLength = 40;
            lifetime = 600;
            colorFrom = Color.red;
            colorTo = Color.valueOf("FFFFFF80");
        }},
        new ParticleEffect(){{
            particles = 75;
            interp = Interp.pow5Out;
            sizeFrom = 40;
            sizeTo = 0;
            length = 512;
            baseLength = 15;
            lifetime = 600;
            colorFrom = Color.red;
            colorTo = Color.valueOf("FFFFFF80");
        }}
    );
}
