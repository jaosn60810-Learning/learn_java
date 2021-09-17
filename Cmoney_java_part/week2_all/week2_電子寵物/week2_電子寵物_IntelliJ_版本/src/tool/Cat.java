package tool;

public class Cat extends Animal {//用override改封裝等級，

    public Cat(String name) {
        super(name);
        type = 2;
        thing = 2;
        thingLine = 6;
        feedConsume = 1;
        feedMax = 3+3;
        feedLine = feedMax;//餵食血條 餵食頻率+飢餓頻率   餓死
        feedNumberMax = 5;//餵食後第5個動作，若是沒有清潔，累積到第3個排泄物，則會髒死
//        cleanTime = 3;
        cleanMax = 3;
        cleanLine = cleanMax;//清潔血條  排泄頻率+便便數量(餵食次數/便便累積量)   髒死
        walkMax = 10+9;
        walkLine = walkMax;//散步血條   散步頻率+無聊頻率   無聊死
//        connectTime = 3;
        connectMax = 3;//交配時間
        connectLine = connectMax;//交配血條
        sleepMax = 4;//睡眠持續時間
        sleepLine = 0;
        wakeMax = 8;//睡眠頻率，每醒著7個動作(7天)就會睡一次
        wakeLine = wakeMax;
    }
}