package card;

import com.company.*;

public class WarriorSet extends Set{

    public WarriorSet() {
        super("warrior");

    }

    public class cardNo1 extends Card implements Power{

        public cardNo1() {
            setNumber(1);
            setName("照顧新人的戰士\t");
            setEffect("自己之後打出的卡片數值 * 2");
            setPoint(1);
            setValue(5);
            setCost(2);
            setType(1);
            setEffectCount(1);
        }

        @Override
        public void exec(Player player , Player computer) {

        }
    }





}
