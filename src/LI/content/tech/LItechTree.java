package LI.content.tech;

import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.UnlockableContent;
import mindustry.type.Planet;

import static mindustry.content.TechTree.*;
import static mindustry.game.Objectives.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.Planets.*;
import static LI.content.LIplanets.*;
import static LI.content.LIblocks.*;
import static LI.content.LIunits.*;
import static LI.content.LIitems.*;
import static LI.content.LIliquids.*;
import static LI.content.LImaps.*;

public class LItechTree {
    public static void load(){
        loadNT();
        loadOverride();
    }

    private static void loadNT(){
        NT.techTree = TechTree.nodeRoot(NT.localizedName, NT, () -> {
            node(WXHXJZ, Seq.with(new OnSector(map1)), () -> {
                node(SDHX, () -> {
                    node(LTHX, Seq.with(new SectorComplete(map4)), () -> {});
                });
            });

            node(BCJDWZGGC, Seq.with(new SectorComplete(ZXmap2)), () -> {
                node(DMJDWZGGC, () -> {
                    node(WLJDWZGGC, Seq.with(new SectorComplete(map5)), () -> {});
                });
            });

            node(illuminator, () -> {
                node(ZXZMQ , Seq.with(new Research(WXHXJZ)), () -> {
                    node(DXZMQ, () -> {
                        node(RZTY);
                    });
                });
            });

            //NT生产建筑科技树后续插入在这里

            node(PF, Seq.with(new Research(WXHXJZ)), () -> {
                node(YJLD, Seq.with(new OnSector(ZXmap3)), () -> {});
                node(MF, Seq.with(new SectorComplete(ZXmap1)), () -> {
                    node(BP, Seq.with(new SectorComplete(map5)), () -> {});
                });
                node(DL, () -> {
                    //极光
                    node(JK, Seq.with(new SectorComplete(ZXmap3), new OnSector(map6)), () -> {});
                });
                node(CNQ, Seq.with(new OnSector(map6)/* 要求:研究力场墙 */), () -> {
                    node(DXCNQ, () -> {
                        node(JXCNQ);
                    });
                });
                //力场墙
            });

            node(CDJD, Seq.with(new SectorComplete(map2)), () -> {
                node(DXCDJD, () -> {
                    node(CDDLT);
                });

                node(CDDC, () -> {
                    node(DXCDDC);
                });

                node(CPTY, () -> {
                    node(BHTY, () -> {
                        node(RHTY, Seq.with(new SectorComplete(map3)), () ->{
                            node(MBTY, () -> {
                                node(MBQD, Seq.with(new SectorComplete(map4)), () -> {});
                            });
                            node(HSTY, () -> {
                                node(HSQD, Seq.with(new SectorComplete(map4)), () -> {});
                            });
                            node(RHQD, Seq.with(new SectorComplete(map4)), () -> {});
                        });

                        node(ZTQD, Seq.with(new SectorComplete(map4), new Research(JDTY)), () -> {
                            node(SYTQ, Seq.with(new Research(MBQD), new Research(HSQD), new Research(RHQD)), () -> {});
                        });

                        node(JDTY, Seq.with(new OnSector(map3)), () -> {});
                    });
                });
            });

            node(map1, Seq.with(new SectorComplete(planetaryTerminal)), () -> {
                node(map2, Seq.with(new SectorComplete(map1), new Research(WXHXJZ)), () -> {
                    node(map3, Seq.with(new SectorComplete(map2)/* 冰冷废液分离机 */), () -> {
                        node(map4, Seq.with(new SectorComplete(map3), new Research(SDHX), new Research(DL)/* 二液? */), () -> {
                            node(map5, Seq.with(new SectorComplete(map4), new Research(ZTQD)/* 三液转 */), () -> {
                                node(map6, Seq.with(new SectorComplete(map5)), () -> {});
                            });

                            node(ZXmap1, Seq.with(new SectorComplete((map4))), () -> {
                                node(ZXmap2, Seq.with(new SectorComplete(ZXmap1)), () -> {
                                    node(ZXmap3, Seq.with(new SectorComplete(ZXmap2)/* 废液混合器 */), () -> {});
                                });
                            });
                        });
                    });
                });
            });

            nodeProduce(FY0, () -> {
                nodeProduce(FY1, () -> {
                    nodeProduce(FY2, () -> {
                        nodeProduce(FY3, () -> {
                            nodeProduce(FY4, () -> {
                                nodeProduce(FY5, () -> {
                                    nodeProduce(FY6, () -> {});
                                });

                                nodeProduce(SBRY, () -> {});

                                nodeProduce(SMWZ, () -> {
                                    nodeProduce(SMSP, () -> {});
                                });
                            });

                            nodeProduce(CJLDY, () -> {});
                        });
                    });
                });
            });
        });
    }

    private static void loadOverride(){
        addTechNode(XZBXZQ, unloader);
        addTechNode(GYFSQ, itemBridge);
        addTechNode(DXZHCSD, payloadConveyor);
        addTechNode(GZQ, payloadConveyor);
        addTechNode(TCSD, titaniumConveyor);
        addTechNode(armoredConveyor, TCSD);
        addTechNode(ZJCSGD, armoredConveyor);
        addTechNode(node(SCD, Seq.with(new Research(platedConduit)), () -> {
            node(SCJCQ, () -> {
                node(SCLYQ, () -> {
                    node(SCQ, Seq.with(new Research(massDriver)/* 液体质驱 */), () -> {});
                });
            });
        }), plastaniumConveyor);
        addTechNode(JXLTCG, liquidTank);
        //液体卸载器
        addTechNode(TDGQ, bridgeConduit);
        //液体质驱，微型液体质驱
        addTechNode(ZKB, impulsePump);
        addTechNode(YZSYZJ, oilExtractor);
        addTechNode(node(LDYCQJ, () -> {
            node(BLZJ);
        }), waterExtractor);
        addTechNode(node(QXCSJ, () -> {
            node(DXCSJ);
        }), waterExtractor);
        addTechNode(WXCSJ, waterExtractor);

        //没添加的生产建筑...

        addTechNode(CSTQ, overdriveDome);
        addTechNode(node(LTFPLC, () -> {
            node(LTTSLC);
        }), overdriveProjector);
        addTechNode(DLY, mendProjector);
        addTechNode(node(ZSHFYD, () -> {
            node(SBFYD, Seq.with(new OnSector(planetaryTerminal)), () -> {});
        }), thoriumReactor);
        addTechNode(HWKZRFDJ, thermalGenerator);
        addTechNode(HWSBRFDJ, thermalGenerator);
        addTechNode(node(SGZJCYG, () -> {
            node(DXSGZJCYG, Seq.with(new Research(DXZJCYG)), () -> {});
        }), plastaniumWall);
        addTechNode(node(XZZJCYG, () -> {
            node(DXXZZJCYG, Seq.with(new Research(DXZJCYG)), () -> {});
        }), phaseWall);
        addTechNode(node(HJZJCYG, () -> {
            node(DXHJZJCYG, Seq.with(new Research(DXZJCYG)), () -> {});
        }), surgeWall);
        addTechNode(node(ZJCYG, () -> {
            node(DXZJCYG);
        }), titaniumWall);

        addTechNode(node(DCFB, Seq.with(new SectorComplete(desolateRift)), () -> {}), foreshadow);
        addTechNode(node(TFP, Seq.with(new Research(thoriumReactor), new Research(GZQ)), () -> {}), foreshadow);

        addTechNode(node(SM, () -> {
            node(FZ, () -> {
                node(HL, Seq.with(new SectorComplete(coastline)), () -> {
                    node(DY, Seq.with(new SectorComplete(navalFortress)), () -> {
                        node(JX, Seq.with(new SectorComplete(weatheredChannels)), () -> {});
                    });
                });
            });
        }), navalFactory);
        addTechNode(node(FZGC, () -> {
            node(XFQ);
            node(ZLQ);
            node(JZQ);
            node(ZTQ);
        }), airFactory);
        addTechNode(nodeProduce(QSZ, () -> {
            nodeProduce(GTS, () -> {
                nodeProduce(CDZ, () -> {});
            });
            nodeProduce(GTLDY, () -> {});
            nodeProduce(GTCJLDY, () -> {});
            nodeProduce(GTZS, () -> {});
            nodeProduce(GTSY, () -> {});
            nodeProduce(ZYZ, () -> {});
        }), graphite);
        addTechNode(nodeProduce(TF, () -> {
            nodeProduce(NRJT, () -> {
                nodeProduce(HWKZJT, () -> {});
                nodeProduce(HWSBJT, () -> {});
            });
        }), coal);
    }


    private static void addTechNode(UnlockableContent content, UnlockableContent parent){
        var newNode = new TechNode(null, content, content.researchRequirements());
        addTechNode(newNode, serpulo, content, parent);
    }
    private static void addTechNode(TechNode newNode, UnlockableContent parent){
        addTechNode(newNode, serpulo, newNode.content, parent);
    }
    private static void addTechNode(TechNode newNode, Planet planet, UnlockableContent content, UnlockableContent parent){
        planet.techTree.each( t -> {
            if(t.content == content){
                for(var c : t.children){
                    if(!newNode.children.contains(c)) newNode.children.add(c);
                }
                t.remove();
            }
        });
        planet.techTree.each( t -> {
            if(t.content == parent){
                if(!t.children.contains(newNode)) t.children.add(newNode);
                newNode.parent = t;
            }
        });
    }
}
