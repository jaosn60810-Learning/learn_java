package com.company;

import java.util.Arrays;

public class Music {
    private String musicName;
    private int[] releaseDate;
    private String musicType;
    private String musicSinger;

    private Music(Builder builder) {
        setMusicName(builder.musicName);
        setReleaseDate(builder.releaseDate);
        setMusicType(builder.musicType);
        setMusicSinger(builder.musicSinger);
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int[] getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int[] releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicName='" + musicName + '\'' +
                ", releaseDate=" + Arrays.toString(releaseDate) +
                ", musicType='" + musicType + '\'' +
                ", musicSinger='" + musicSinger + '\'' +
                '}';
    }

    public static final class Builder {
        private String musicName;
        private int[] releaseDate;
        private String musicType;
        private String musicSinger;

        public Builder() {
        }

        public Builder setMusicName(String val) {
            musicName = val;
            return this;
        }

        public Builder setReleaseDate(String val) {
            // 將格式 1970-01-01 轉換成 [1970, 1, 1]
            String[] newMusicreleaseDate = {};
            int[] numMusicreleaseDate = new int[3];
            newMusicreleaseDate = val.split("-");
            for (int i = 0; i < 3; i++) {
                numMusicreleaseDate[i] = Integer.parseInt(newMusicreleaseDate[i]);
            }
            releaseDate = numMusicreleaseDate;
            return this;
        }

        public Builder setReleaseDate(int[] val) {
            releaseDate = val;
            return this;
        }

        public Builder setMusicType(String val) {
            musicType = val;
            return this;
        }

        public Builder setMusicSinger(String val) {
            musicSinger = val;
            return this;
        }

        public Music build() {
            return new Music(this);
        }
    }
}
