package com.company;

    public enum WarriorCard implements Effect{
        CARD1(1, "照顧新人的戰士\t", "自己之後打出的卡片數值 * 2", 1){
            @Override
            public boolean canEffect(Player p1, Player p2) {
                return true;
            }
            @Override
            public void actionForAll(Player p1, Player p2) {
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
            },
        CARD5(5, "多拿一把劍的戰士\t", "抽一張牌", 1, 2);

        public int number;
        // 卡片名稱
        private String name;
        // 卡片效果說明
        private String effect;
        // 卡片職業
        private int job;
        // 卡片數值
        private int point;


        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getEffect() {
            return effect;
        }

        public int getJob() {
            return job;
        }

        public int getPoint() {
            return point;
        }

        private WarriorCard(int number, String name, String effect, int job, int point){
            this.number = number;
            this.name = name;
            this.effect = effect;
            this.job = job;
            this.point = point;
        }

        @Override
        public void doBuff(Player p1, Player p2) {}

        public boolean canEffect(Player p1, Player p2) {return true;}

        public void actionForAll(Player p1, Player p2){}

    }

