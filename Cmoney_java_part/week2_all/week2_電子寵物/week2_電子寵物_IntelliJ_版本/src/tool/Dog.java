package tool;

public class Dog extends Animal{//用override改封裝等級，

    public Dog(String name) {
        super(name);
        type = 1;
        thing = 1;
        thingLine = 5;
        feedConsume = 2;
        feedMax = 4+4;
        feedLine = feedMax;//餵食血條 餵食頻率+飢餓頻率   餓死
        feedNumberMax = 3;//餵食後第3個動作，若是沒有清潔，累積到第5個排泄物，則會髒死
//        cleanTime = 5;//
        cleanMax = 5;
        cleanLine = cleanMax;//清潔血條  排泄頻率+便便數量(餵食次數/便便累積量)   髒死
        walkMax = 3+6;
        walkLine = walkMax;//散步血條   散步頻率+無聊頻率   無聊死
//        connectTime = 2;
        connectMax = 2;//交配時間
        connectLine = connectMax;//交配血條
        sleepMax = 2;//睡眠持續時間
        sleepLine = 0;
        wakeMax = 7;//睡眠頻率，每醒著7個動作(7天)就會睡一次
        wakeLine = wakeMax;

    }
}