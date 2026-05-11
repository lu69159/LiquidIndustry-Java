package LI.content;

import arc.struct.Seq;
import mindustry.type.SectorPreset;

public class LImaps {
    public static SectorPreset
    //主线
        map1,map2,map3,map4,map5,map6,

    //支线
        ZXmap1,ZXmap2,ZXmap3,

    //教程
        JCmap1,JCmap2
    ;
    public static Seq<SectorPreset> windMaps;

    public static void load(){

        windMaps = Seq.with(ZXmap3);
    }
}
