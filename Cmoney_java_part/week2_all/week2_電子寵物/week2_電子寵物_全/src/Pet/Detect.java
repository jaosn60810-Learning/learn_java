package Pet;

public class Detect {

    Animal[] allAnimals;

    /** 將動物陣列傳入修改 */
    public Detect(Animal[] allAnimals){
        this.allAnimals = allAnimals;
    }

    /** 檢查完狀態後回傳更新的動物狀態 */
    public Animal[] checkStatus(){
        for(int i = 0; i < allAnimals.length; i++) {
            if(allAnimals[i]!=null){
                Animal thePet = allAnimals[i];
                //檢查是否餓死
                if(thePet.hungry <= 0) {
                    thePet.life = false;
                    thePet.die = 1;
                    continue;
                }
                //檢查是否無聊死
                if(thePet.bored <= 0){
                    thePet.life = false;
                    thePet.die = 2;
                    continue;
                }
                //檢查是否髒死
                if(thePet.shit <= 0){
                    thePet.life = false;
                    thePet.die = 3;
                    continue;

                }

                if(thePet.life) {
                    //檢查是否要睡覺
                    thePet.sleep--;
                    if(thePet.sleep != 0) {

                        //檢查是否需要餵食
                        thePet.feed--;
                        if(thePet.feed <= 0) {
                            thePet.feeling--;
                            System.out.println("警告："+thePet.name+"需要餵食！");
                            thePet.hungry--;
                            /** 過飽在這邊判斷 */
                        }

                        //檢查是否要散步
                        thePet.walk--;
                        if(thePet.walk <= 0) {
                            thePet.feeling--;
                            System.out.println("警告："+thePet.name+"需要散步！");
                            thePet.bored--;
                        }

                        //檢查是否有交配對象
                        if(thePet.binding != null) {
                            //檢查交配對象是否同種
                            if(thePet.type == thePet.binding.type){
                                thePet.bindingTime--;
                                if(thePet.bindingTime <= 0) {
                                    if(thePet.sex != thePet.binding.sex){
                                        int animalsAmount = 0;
                                        for(int k = 0; k < allAnimals.length; k++){
                                            if(allAnimals[i] != null) {
                                                animalsAmount++;
                                                continue;
                                            } else {
                                                allAnimals[i] = thePet.giveBirth();
                                                break;
                                            }
                                        }
                                        if(animalsAmount == allAnimals.length) {
                                            System.out.println("動物房間已滿，孩子生不下哩：）））再不買動物房啊");
                                        }
                                    }
                                    thePet.resetBindingTime();
                                }
                            } else {
                                //檢查是否無法交配死
                                thePet.notOkaySex--;
                                //不同種兩個都死掉
                                if (thePet.notOkaySex <= 0){
                                    thePet.life = false;
                                    thePet.binding.life = false;
                                    thePet.die = 4;
                                    thePet.binding.die = 4;
                                    continue;
                                }

                                /** 主角是貓 */
                                if(thePet.type == "Cat") {
                                    //不同情境A：貓＆魚
                                    if(thePet.binding.type == "Fish"){
                                        if(thePet.feed <= 0) {
                                            //貓在餓，魚會死
                                            thePet.binding.life = false;
                                            /** 要餵貓 */
//                                            ？？？？？？？？？？
                                            thePet.resetFeed();
                                        }
                                    }

                                    //不同情境B：貓＆昆蟲
                                    if(thePet.binding.type == "Insect"){
                                        if(thePet.bored <= 0) {
                                            //貓在無聊，昆蟲會死
                                            thePet.binding.life = false;
                                            /** 要帶貓散步 */
//                                        ？？？？？？？？
                                        }
                                    }

                                    //不同情境C：貓＆狗
                                    if(thePet.binding.type == "Dog"){
                                        if(thePet.bored <= 0 || thePet.binding.bored <= 0) {
                                            //貓在無聊，狗在無聊 好感度都-1
                                            thePet.feeling--;
                                            thePet.binding.feeling--;
                                        }
                                    }
                                }

                                /** 主角是狗 */
                                if(thePet.type == "Dog") {

                                    //不同情境A：狗＆昆蟲
                                    if(thePet.binding.type == "Insect"){
                                        if(thePet.bored <= 0) {
                                            //狗在無聊，昆蟲會死
                                            thePet.binding.life = false;
                                        }
                                    }

                                    //不同情境B：狗＆貓
                                    if(thePet.binding.type == "Cat"){
                                        if(thePet.bored <= 0 || thePet.binding.bored <= 0) {
                                            //狗在無聊，貓在無聊 好感度都-1
                                            thePet.feeling--;
                                            thePet.binding.feeling--;
                                        }
                                    }
                                }

                                /** 主角是昆蟲 */
                                if(thePet.type == "Insect") {

                                    //不同情境A：昆蟲＆狗
                                    if(thePet.binding.type == "Dog"){
                                        if(thePet.binding.bored <= 0) {
                                            //狗在無聊，昆蟲會死
                                            thePet.life = false;
                                        }
                                    }

                                    //不同情境B：昆蟲＆貓
                                    if(thePet.binding.type == "Cat"){
                                        if(thePet.binding.bored <= 0) {
                                            //狗在無聊，昆蟲會死
                                            thePet.life = false;
                                            /** 貓被散步一次 */
//                                        ？？？？？？？
                                        }
                                    }
                                }

                                /** 主角是魚 */
                                if(thePet.type == "Fish") {
                                    //不同情境A：魚&貓
                                    if(thePet.binding.type == "Cat"){
                                        if(thePet.binding.feed <= 0) {
                                            //貓在餓，魚會死
                                            thePet.life = false;
                                            /** 要餵貓 */
//                                        ？？？？？？？？
                                        }
                                    }
                                }

                            }
                        }

                        //檢查是否產出物品
                        thePet.production--;
                        if(thePet.production <= 0) {
                            thePet.product++;
                            thePet.resetProduction();
                        }

                    } else {
                        //檢查是否清醒
                        thePet.sleepLast--;
                        if(thePet.sleepLast <= 0){
                            thePet.resetSleep();
                        }
                    }
                }
            }
        }
        return allAnimals;
    }

    public Animal[] doubleArray(Animal[] originalArray){
        Animal[] newArray = new Animal[feList(originalArray.length)];
        for(int i = 0; i < originalArray.length; i++){
            newArray[i] = originalArray[i];
        }
        return newArray;
    }

    private int feList(int originalArray) {
        if(originalArray == 0) {
            return 1;
        }
        if(originalArray == 1) {
            return 2;
        }
        return (originalArray-1) + (originalArray-2);
    }
}
