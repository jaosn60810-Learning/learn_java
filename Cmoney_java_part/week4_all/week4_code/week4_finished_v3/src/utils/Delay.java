package utils;

public class Delay {

    private int count;
    private int countLimit;
    private boolean isPause;
    private boolean isLoop;

    public Delay(int countLimit){
        this.countLimit = countLimit;
        count = 0;
        isPause = true;
    }

    public void setLimit(int limit){
        this.countLimit = limit;
    }
    public void stop(){
        isPause = true;
        isLoop = false;
        count = 0;
    }
    public void pause(){
        isPause = true;
    }
    public void play(){
        isPause = false;
        isLoop = false;
    }
    public void loop(){
        isPause = false;
        isLoop = true;
    }

    public boolean count(){
        if(isPause){
            return false;
        }
        if (count >= countLimit){
            if (isLoop){   //如果是用在物件上，迴圈就會變成讓其一次只動一格（因為會等delay的時間）
                count = 0;
            }else{  // 如果這個沒設，就會變成只delay一次，然後就照原本的速度一直前進
                stop();
            }
            return true;
        }
        count++;
        return false;
    }

}