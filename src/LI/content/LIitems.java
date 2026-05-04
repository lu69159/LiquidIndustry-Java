package LI.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class LIitems {
    public static Item QSZ,ZYZ,CDZ,TF,NRJT,SMWZ,SMSP,GTS,GTZS,GTLDY,GTSY,GTCJLDY,HWKZJT,HWSBJT;

    public static void load(){
        QSZ = new Item("亲水质", Color.valueOf("4DA6FF")){{
            cost = 1.4f;
        }};
        ZYZ = new Item("治愈质", Color.valueOf("6BC583")){{
            cost = 1.5f;
        }};
        CDZ = new Item("超导质", Color.valueOf("8EFFEA")){{
            cost = 1.4f;
            charge = 1.5f;
        }};
        TF = new Item("碳粉", Color.valueOf("272727")){{
            cost = 1f;
            flammability = 1.25f;
            explosiveness = 0.25f;
        }};
        NRJT = new Item("耐热晶体", Color.valueOf("EA8878")){{
            cost = 1.6f;
            flammability = 0.05f;
        }};
        SMWZ = new Item("神秘物质", Color.valueOf("FFFFFF")){{
            cost = 5f;
            charge = 10f;
            radioactivity = 50f;

            frames = 19;
            transitionFrames = 1;
            frameTime = 3f;
        }
            @Override
            public void setStats(){}
        };
        SMSP = new Item("神秘碎片", Color.valueOf("FFFFFF")){{
            cost = 2.1f;
            charge = 1f;
            radioactivity = 5f;
        }
            @Override
            public void setStats(){}
        };
        GTS = new Item("固态水", Color.valueOf("4DA6FF")){{
            cost = 1.5f;
        }};
        GTZS = new Item("固态重水", Color.valueOf("3D6E70")){{
            cost = 1.5f;
            radioactivity = 1.5f;
        }};
        GTLDY = new Item("固态冷冻液", Color.valueOf("3DEEEB")){{
            cost = 1.5f;
        }};
        GTSY = new Item("固态石油", Color.valueOf("43434F")){{
            cost = 1.5f;
            flammability = 1.5f;
            explosiveness = 2.5f;
        }};
        GTCJLDY = new Item("固态超级冷冻液", Color.valueOf("C0ECFF")){{
            cost = 1.5f;
        }};
        HWKZJT = new Item("恒温矿渣晶体", Color.valueOf("FFA166")){{
            cost = 1.8f;
            flammability = 6f;
        }};
        HWSBJT = new Item("恒温衰变晶体", Color.valueOf("FF0000")){{
            cost = 2f;
            flammability = 12f;
            explosiveness = 12f;
        }};
    }
}
