package tool;

public class Fish extends Animal{//用override改封裝等級，

    public Fish(String name) {
        super(name);
        type = 3;
        thing = 3;
        thingLine = 7;
        feedConsume = 1;
        feedMax = 5+3;
        feedLine = feedMax;//餵食血條 餵食頻率+飢餓頻率   餓死
        feedNumberMax = 2;//餵食後第2個動作，若是沒有清潔，累積到第20個排泄物，則會髒死
//        cleanTime = 2;
        cleanMax = 20;
        cleanLine = cleanMax;//清潔血條  排泄頻率+便便數量(餵食次數/便便累積量)   髒死
        walkMax = 999999999;//因為魚不會無聊，所以給他一個超大數值，讓牠怎麼跑都不會無聊死
        walkLine = walkMax;//散步血條   散步頻率+無聊頻率   無聊死
//        connectTime = 3;
        connectMax = 3;//交配時間
        connectLine = connectMax;//交配血條
        sleepMax = 1;//睡眠持續時間
        sleepLine = 0;
        wakeMax = 8;//睡眠頻率，每醒著7個動作(7天)就會睡一次
        wakeLine = wakeMax;
    }
}
