package utils;

public class Delay {
    private int count;
    private int countLimit;
    private boolean isPause;

    public Delay(int countLimit) {
        count = 0;
        this.countLimit = countLimit;
        isPause = true;
    }

    public void setLimit(int limit) {
        this.countLimit = limit;
    }

    public void stop() {
        isPause = true;
        count = 0;
    }

    public void pause() {
        isPause = true;

    }

    public void play() {
        isPause = false;
    }

    public boolean count() {
        return !isPause && count++ >= countLimit;
    }
}
