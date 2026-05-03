package LI.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import mindustry.entities.Effect;
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
    });
}
