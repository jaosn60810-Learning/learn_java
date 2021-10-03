package com.company;

import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

public class WareHouse {

    public static Card[] AllWareHouse = {
            new Card(1, "照顧新人的戰士\t", 1, "自己之後打出的卡片數值 * 2", 5, 2, 1, 1, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p1.addEffects(new Effect() {

                            @Override
                            public void doBuff(Player p1, Player p2) {

                                Card a = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                                a.setPoint(a.getPoint() * 2);

                            }
                        });


                    }
                }

                @Override
                protected void actionForRemove(Player p1, Player cpu, int index) {
                    p1.removeEffect(index);
                    {

                    }
                }
            },
            new Card(2, "嘴賤的牧師\t\t", 1, "對手之後打出的卡片數值 / 2", 5, 2, 2, 1, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p2.addEffects(new Effect() {

                            @Override
                            public void doBuff(Player p1, Player p2) {

                                Card tmp = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                                tmp.setPoint(tmp.getPoint() / 2);
                            }
                        });

                    }

                }

                @Override
                protected void actionForRemove(Player p1, Player p2, int index) {
                    p2.removeEffect(index);
                    {

                    }
                }
            },
            new Card(3, "鼓舞現場的法師\t", 1, "自己之前打出所有卡片，數值 * 2", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        for (int i = 0; i < p1.getCardonDesk().length - 1; i++) {
                            p1.getCardonDesk()[i].setPoint(p1.getCardonDesk()[i].getPoint() * 2);
                        }

                    }

                }
            },
            new Card(4, "恫嚇現場的武僧\t", 1, "對手之前打出所有卡片，數值 / 2", 5, 2, 4, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        for (int i = 0; i < p2.getCardonDesk().length; i++) {
                            p2.getCardonDesk()[i].setPoint(p2.getCardonDesk()[i].getPoint() / 2);
                        }

                    }

                }
            },
            new Card(5, "多拿一把劍的戰士\t", 2, "抽一張牌", 5, 2, 1, 3, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p1.getCardSet().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p1.setHandCard(addToCardSet(p1.getHandCard(), Card.copy(p1.getCardSet()[0])));
                        p1.setCardSet(removeCardFromCardSet(p1.getCardSet(), 0));

                    }

                }
            },
            new Card(6, "逼人懺悔的牧師\t", 2, "對手隨機捨棄一張手牌", 5, 2, 2, 3, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getHandCard().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int r = random(0, p2.getHandCard().length - 1);
                        p2.setCardOut(addToCardSet(p2.getCardOut(), p2.getHandCard()[r]));
                        p2.setHandCard(removeCardFromCardSet(p2.getHandCard(), r));


                    }

                }
            },
            new Card(7, "加持頭尾的法師\t", 2, "戰鬥區中第一張以及目前最後一張的牌數值都 * 2", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p1.getCardonDesk().length >= 2;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p1.getCardonDesk()[0].setPoint(p1.getCardonDesk()[0].getPoint() * 2);
                        p1.getCardonDesk()[p1.getCardonDesk().length - 2].setPoint(p1.getCardonDesk()[p1.getCardonDesk().length - 2].getPoint() * 2);

                    }

                }
            },
            new Card(8, "不認輸的武僧\t\t", 2, "目前分數若是低於對手，則分數的差額會變成這張牌的數值", 5, 2, 4, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    int sump1 = 0, sump2 = 0;
                    for (int i = 0; i < p1.getCardonDesk().length; i++) {
                        sump1 += p1.getCardonDesk()[i].getPoint();
                    }
                    for (int i = 0; i < p2.getCardonDesk().length; i++) {
                        sump2 += p2.getCardonDesk()[i].getPoint();
                    }
                    return sump1 < sump2;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int p1score = 0, p2score = 0;
                        for (int i = 0; i < p1.getCardonDesk().length; i++) {
                            p1score += p1.getCardonDesk()[i].getPoint();
                        }
                        for (int i = 0; i < p2.getCardonDesk().length; i++) {
                            p2score += p2.getCardonDesk()[i].getPoint();
                        }
                        p1.getCardonDesk()[p1.getCardonDesk().length - 1].setPoint(p2score - p1score);

                    }

                }
            },
            new Card(9, "遇強則強的戰士\t", 3, "目前分數若是低於對手，則抽一張牌", 5, 2, 1, 3, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    int sump1 = 0, sump2 = 0;
                    for (int i = 0; i < p1.getCardonDesk().length; i++) {
                        sump1 += p1.getCardonDesk()[i].getPoint();
                    }
                    for (int i = 0; i < p2.getCardonDesk().length; i++) {
                        sump2 += p2.getCardonDesk()[i].getPoint();
                    }
                    return sump1 < sump2;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p1.setHandCard(addToCardSet(p1.getHandCard(), Card.copy(p1.getCardSet()[0])));
                        p1.setCardSet(removeCardFromCardSet(p1.getCardSet(), 0));

                    }

                }

            },
            new Card(10, "三倍的牧師\t\t", 3, "對手抽一張牌，此牌分數 * 3", 5, 2, 2, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p2.setHandCard(addToCardSet(p2.getHandCard(), Card.copy(p2.getCardSet()[0])));
                        p2.setCardSet(removeCardFromCardSet(p2.getCardSet(), 0));
                        Card tmp = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                        tmp.setPoint(tmp.getPoint() * 3);

                    }

                }
            },
            new Card(11, "干擾對手的法師\t", 3, "對手戰鬥區中上一張牌以及上兩張牌數值都減少 2", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getCardonDesk().length >= 2;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p2.getCardonDesk()[p2.getCardonDesk().length - 1].setPoint(p2.getCardonDesk()[p2.getCardonDesk().length - 1].getPoint() - 2);
                        p2.getCardonDesk()[p2.getCardonDesk().length - 2].setPoint(p2.getCardonDesk()[p2.getCardonDesk().length - 2].getPoint() - 2);

                    }

                }
            },
            new Card(12, "照顧小弟的武僧\t", 3, "自己下一張牌以及下兩張牌的數值都加 1", 5, 2, 4, 1, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p1.addEffects(new Effect() {
                            int count = 2;

                            @Override
                            public void doBuff(Player p1, Player p2) {

                                if (count <= 0) {
                                    return;
                                }
                                Card a = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                                a.setPoint(a.getPoint() + 1);
                                count--;
                            }
                        });

                    }

                }

                @Override
                protected void actionForRemove(Player p1, Player p2, int index) {
                    p1.removeEffect(index);
                    {

                    }
                }
            },
            new Card(13, "針對人的戰士\t\t", 4, "對手戰鬥區中數值介於 3 ~ 6 之間的卡片數值 - 2", 5, 2, 1, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        for (int i = 0; i < p2.getCardonDesk().length; i++) {
                            if (p2.getCardonDesk()[i].getPoint() >= 3 && p2.getCardonDesk()[i].getPoint() <= 6) {
                                p2.getCardonDesk()[i].setPoint(p2.getCardonDesk()[i].getPoint() - 2);
                            }
                        }

                    }

                }
            },
            new Card(14, "加持強者的牧師\t", 4, "自己打出的數值介於 5 ~ 8 的卡片數值 + 1", 5, 2, 2, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        for (int i = 0; i < p1.getCardonDesk().length; i++) {
                            if (p1.getCardonDesk()[i].getPoint() >= 5 && p1.getCardonDesk()[i].getPoint() <= 8) {
                                p1.getCardonDesk()[i].setPoint(p1.getCardonDesk()[i].getPoint() + 1);
                            }
                        }

                    }

                }
            },
            new Card(15, "傳奇大法師-積掰郎\t", 4, "取消對手戰鬥區中上一張卡片的效果", 5, 2, 3, 3, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    if (p2.getCardonDesk().length == 0) {
                        return false;
                    }
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    //   p2.removeEffect(p2.getCardonDesk()[p2.getCardonDesk().length-1].getBuffIndex());
                }
            },
            new Card(16, "尋找弱者的武僧\t", 4, "若是我方戰鬥區中有兩張數值低於 3 的卡片，則此牌數值 + 2", 5, 2, 4, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    int count = 0;
                    for (int i = 0; i < p1.getCardonDesk().length; i++) {
                        if (p1.getCardonDesk()[i].getPoint() < 3) {
                            count++;
                        }
                    }
                    for (int i = 0; i < p2.getCardonDesk().length; i++) {
                        if (p2.getCardonDesk()[i].getPoint() < 3) {
                            count++;
                        }
                    }
                    return count >= 2;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        Card tmp = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                        tmp.setPoint(tmp.getPoint() + 2);

                    }

                }
            },
            new Card(17, "路過的劍士\t\t", 5, "無特殊效果", 5, 2, 1, 4, 1),
            new Card(18, "針對對手最弱者的牧師", 5, "對手戰鬥區中一張數值最低的卡片數值 - 2", 5, 2, 2, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        Card tmp = p2.getCardonDesk()[0];
                        int index = 0;
                        for (int i = 0; i < p2.getCardonDesk().length; i++) {
                            if (p2.getCardonDesk()[i].getPoint() < tmp.getPoint()) {
                                tmp = p2.getCardonDesk()[i];
                                index = i;
                            }
                        }
                        p2.getCardonDesk()[index].setPoint(p2.getCardonDesk()[index].getPoint() - 2);

                    }

                }
            },
            new Card(19, "照顧自己最弱者的法師", 5, "自己戰鬥區中一張數值最低的卡片數值 + 2", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p1.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        Card tmp = p1.getCardonDesk()[0];
                        int index = 0;
                        for (int i = 0; i < p1.getCardonDesk().length; i++) {
                            if (p1.getCardonDesk()[i].getPoint() < tmp.getPoint()) {
                                tmp = p1.getCardonDesk()[i];
                                index = i;
                            }
                        }
                        p1.getCardonDesk()[index].setPoint(p1.getCardonDesk()[index].getPoint() + 2);

                    }

                }
            },
            new Card(20, "隨便打一個的武僧\t", 5, "對手戰鬥區的卡片中隨機一張卡片數值 - 3", 5, 2, 4, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int r = random(0, p2.getCardonDesk().length - 1);
                        Card tmp = p2.getCardonDesk()[r];
                        tmp.setPoint(tmp.getPoint() - 3);

                    }

                }
            },
            new Card(21, "你手牌多就扣你的戰士", 6, "對手手牌大於等於 4 張時，對手戰鬥區中隨機一張牌數值減少 2", 5, 2, 1, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getHandCard().length >= 4 && p2.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int r = random(0, p2.getCardonDesk().length - 1);
                        Card tmp = p2.getCardonDesk()[r];
                        tmp.setPoint(tmp.getPoint() - 2);

                    }

                }
            },
            new Card(22, "無能的牧師\t\t", 6, "無特殊效果", 5, 2, 2, 4, 1),
            new Card(23, "愛小三的法師\t\t", 6, "自己手牌中數值小於 3 的牌全部 + 1", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p1.getHandCard().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        for (int i = 0; i < p1.getHandCard().length; i++) {
                            if (p1.getHandCard()[i].getPoint() < 3) {
                                Card tmp = p1.getHandCard()[i];
                                tmp.setPoint(tmp.getPoint() + 1);
                            }
                        }

                    }


                }
            },
            new Card(24, "跟你下一張說拜拜的武僧", 6, "將對手下一張打出的牌直接丟到棄牌區，效果不發動", 5, 2, 4, 1, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getHandCard().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p2.addEffects(new Effect() {
                            int count = 1;

                            @Override
                            public void doBuff(Player p1, Player p2) {
                                if (count <= 0) {
                                    return;
                                }
                                int index = p1.getCardonDesk().length - 1;
                                System.out.println("卡片編號:" + p1.getCardonDesk()[index].number + "被丟掉了");
                                p1.setCardOut(addToCardSet(p1.getCardOut(), p1.getCardonDesk()[index]));
                                p1.setCardonDesk(removeCardFromCardSet(p1.getCardonDesk(), index));
                                count--;
                            }
                        });


                    }

                }

                @Override
                protected void actionForRemove(Player p1, Player p2, int index) {
                    p2.removeEffect(index);
                    {

                    }
                }
            },
            new Card(25, "路過的鬍渣戰士\t", 7, "無特殊效果", 5, 2, 1, 4, 1),
            new Card(26, "複雜的牧師\t\t", 7, "對方戰鬥區的上一張卡片數值 – (對方目前卡片數值總和 / 10 的餘數)", 5, 2, 2, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p2.getCardonDesk().length - 1;
                        int sumPoint = 0;
                        for (int i = 0; i < position + 1; i++) {
                            sumPoint += p2.getCardonDesk()[i].getPoint();
                        }
                        p2.getCardonDesk()[position].setPoint(p2.getCardonDesk()[position].getPoint() - sumPoint % 10);


                    }

                }
            },
            new Card(27, "隨便的法師\t\t", 7, "對手戰鬥區隨機一張卡片數值 - 3", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p2.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p2.getCardonDesk().length - 1;
                        int index = random(0, position);

                        p2.getCardonDesk()[index].setPoint(p2.getCardonDesk()[index].getPoint() - 3);


                    }

                }
            },
            new Card(28, "亂來的武僧\t\t", 7, "自己戰鬥區隨機一張卡數值 + 3", 5, 2, 4, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return p1.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p1.getCardonDesk().length - 1;
                        int index = random(0, position);

                        p1.getCardonDesk()[index].setPoint(p1.getCardonDesk()[index].getPoint() + 3);


                    }

                }
            },
            new Card(29, "路過的超強戰士\t", 8, "無特殊效果", 5, 2, 1, 4, 1),
            new Card(30, "殉道的牧師\t\t", 8, "將自己戰鬥區第一張卡片送入棄牌區，也把對方戰鬥區中第一張卡片送入棄牌區", 5, 2, 2, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return ((p1.getCardonDesk().length > 0) && (p2.getCardonDesk().length > 0));
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        //自己先丟
                        System.out.println("卡片編號:" + p1.getCardonDesk()[0].number + "被丟掉了");
                        p1.setCardOut(addToCardSet(p1.getCardOut(), p1.getCardonDesk()[0]));
                        p1.setCardonDesk(removeCardFromCardSet(p1.getCardonDesk(), 0));
                        //換對手丟
                        System.out.println("卡片編號:" + p2.getCardonDesk()[0].number + "被丟掉了");
                        p2.setCardOut(addToCardSet(p1.getCardOut(), p2.getCardonDesk()[0]));
                        p2.setCardonDesk(removeCardFromCardSet(p2.getCardonDesk(), 0));


                    }

                }
            },
            new Card(31, "欺弱怕強的法師\t", 8, "若是目前自己的戰鬥區中數值總和低於 15 (不包含此牌)，則此牌數值 - 4", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    int sumPoint = 0;
                    for (int i = 0; i < p1.getCardonDesk().length - 1; i++) {
                        sumPoint += p1.getCardonDesk()[i].getPoint();
                    }
                    return sumPoint < 15;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p1.getCardonDesk().length - 1;

                        p1.getCardonDesk()[position].setPoint(p1.getCardonDesk()[position].getPoint() - 4);


                    }

                }
            },
            new Card(32, "害怕強者的武僧\t", 8, "打出此卡時，若是對手戰鬥區中的數值總和高於 15，則此牌數值 - 4", 5, 2, 4, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    int sumPoint = 0;
                    for (int i = 0; i < p2.getCardonDesk().length; i++) {
                        sumPoint += p2.getCardonDesk()[i].getPoint();
                    }
                    return sumPoint > 15;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p1.getCardonDesk().length - 1;

                        p1.getCardonDesk()[position].setPoint(p1.getCardonDesk()[position].getPoint() - 4);


                    }

                }
            },
            new Card(33, "君子復仇十年不晚的戰士", 9, "打出此卡時，若是自己棄牌區的卡片數量超過 10 張，則對手隨機一張卡片數值 - 5", 5, 2, 1, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {

                    return p1.getCardOut().length > 10;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p2.getCardonDesk().length - 1;
                        int index = random(0, position);

                        p2.getCardonDesk()[index].setPoint(p2.getCardonDesk()[index].getPoint() - 5);


                    }

                }
            },
            new Card(34, "你4我就4的牧師\t", 9, "打出此卡時，若是對手戰鬥區的卡片超過 4 張，則此卡片的數值為 4", 5, 2, 2, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {

                    return p2.getCardonDesk().length > 4;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p1.getCardonDesk().length - 1;

                        p2.getCardonDesk()[position].setPoint(4);


                    }

                }
            },
            new Card(35, "之後來的都減一的法師", 9, "對手之後出的每張卡片數值 - 1", 5, 2, 3, 1, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    return true;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        p2.addEffects(new Effect() {

                            @Override
                            public void doBuff(Player p1, Player p2) {

                                Card tmp = p1.getCardonDesk()[p1.getCardonDesk().length - 1];
                                tmp.setPoint(tmp.getPoint() - 1);
                            }
                        });


                    }

                }

                @Override
                protected void actionForRemove(Player p1, Player p2, int index) {
                    p2.removeEffect(index);
                    {

                    }
                }
            },
            new Card(36, "路過的少林寺方丈\t", 9, "無特殊效果", 5, 2, 4, 4, 1),
            new Card(37, "路過的戰士之王\t", 10, "無特殊效果", 5, 2, 1, 4, 1),
            new Card(38, "三八的牧師\t\t", 10, "若打出時自己牌組高於 10 張，則此牌的數值為 5", 5, 2, 2, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {

                    return p1.getCardSet().length > 10;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p1.getCardonDesk().length - 1;

                        p1.getCardonDesk()[position].setPoint(5);

                    }

                }
            },
            new Card(39, "懶惰的法師\t\t", 10, "自己戰鬥區前一張牌的數值若是大於 5，則此牌的數值為 7", 5, 2, 3, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {
                    if (p1.getCardonDesk().length > 1) {
                        int position = p1.getCardonDesk().length - 2;
                        return p1.getCardonDesk().length > 0 && p1.getCardonDesk()[position].getPoint() > 5;
                    }
                    return false;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p1.getCardonDesk().length - 1;

                        p1.getCardonDesk()[position].setPoint(7);


                    }

                }
            },
            new Card(40, "失誤殺人的武僧\t", 10, "對手戰鬥區隨機一張卡片數值變成 0", 5, 2, 4, 2, 1) {
                @Override
                public boolean canEffect(Player p1, Player p2) {

                    return p2.getCardonDesk().length > 0;
                }

                @Override
                protected void actionForAll(Player p1, Player p2) {
                    Card card = p1.getCardonDesk()[p1.getCardonDesk().length-1];
                    if (card.getEffectCount() > 0) {
                        int position = p2.getCardonDesk().length - 1;
                        int index = random(0, position);
                        p2.getCardonDesk()[index].setPoint(0);

                    }

                }
            },

    };


    /** 輸入職業編號 然後產生對應的 20 張牌組陣列
     * @param fate 職業的編號
     * @return 對應的 20 張牌組陣列
     */
    public Card[] setMyFirstCardSet(int fate) {
        // 產生 20 張牌組的陣列
        Card[] myFirstCardSet = new Card[20];
        // 紀錄 myFirstCardSet 的長度
        int index = 0;
        // 用迴圈跑過 40 張牌( AllWareHouse.length ) 找出符合職業的 10 張卡牌 並放進 myFirstCardSet 中
        for (int i = 0; i < AllWareHouse.length; i++) {
            // 如果卡牌的職業( AllWareHouse[i].job == 職業編號( fate ) )
            if (AllWareHouse[i].job == fate) {
                // 使用 Card.copy 將此牌( AllWareHouse[i] )複製一個新的實體到我的卡組陣列( myFirstCardSet )
                myFirstCardSet[index] = Card.copy(AllWareHouse[i]);
                // 增長 myFirstCardSet 的長度
                index++;
            }
        }

        // 用迴圈跑 10 次將放進 myFirstCardSet 的 10 張牌 再複製一次
        for (int i = 10; i < 20; i++) {
            // 第11 - 20 張牌是複製前 10 張牌
            myFirstCardSet[i] = Card.copy(myFirstCardSet[index - 1]);
            // 減少 myFirstCardSet 的長度
            index--;
        }
        // 回傳選擇該職業有的 20 張牌
        return myFirstCardSet;
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /** 輸入一個卡片陣列 並移除指定位置的卡牌
     * @param updateCardSet 需要更改的牌組陣列
     * @param position 要刪除卡的位置
     * @return 刪除指定卡牌後的新卡牌陣列
     */
    public static Card[] removeCardFromCardSet(Card[] updateCardSet, int position) {
        // 新的卡牌陣列 長度 - 1 (因為刪了一張牌)
        Card[] newCard = new Card[updateCardSet.length - 1];
        // 用迴圈找到指定牌的位置( position ) 並刪除那張牌
        for (int i = 0; i < updateCardSet.length - 1; i++) {
            // 如果是 刪除的牌 前面的牌 放置的位置都一樣 所以照般
            if (i < position) {
                newCard[i] = updateCardSet[i];
            }
            // 如果是 刪除的牌 後面的牌 用 i + 1 的位置去般
            else {
                newCard[i] = updateCardSet[i + 1];
            }
        }
        // 回傳刪除指定卡牌的卡牌陣列
        return newCard;
    }


    /** 輸入一個卡片陣列 並新增一張新的卡牌到卡牌陣列
     * @param originalCardSet 原始的卡牌陣列
     * @param newCard 要加的新卡
     * @return 加完卡的新卡牌陣列
     */
    public static Card[] addToCardSet(Card[] originalCardSet, Card newCard) {
        // 新的卡牌陣列 長度 + 1 (因為加了一張牌)
        Card[] newCardSet = new Card[originalCardSet.length + 1];
        // 前面的牌都一樣 用迴圈照般
        for (int i = 0; i < originalCardSet.length; i++) {
            newCardSet[i] = originalCardSet[i];
        }
        // 新的卡牌最後一格位置 放新的卡牌
        newCardSet[newCardSet.length - 1] = newCard;
        // 回傳新的卡牌陣列
        return newCardSet;
    }

}
