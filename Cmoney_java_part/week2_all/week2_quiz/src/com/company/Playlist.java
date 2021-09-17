package com.company;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private String playlistIntro;
    private String playlistTag;
    private ArrayList<Music> musics = new ArrayList<>();

    private Playlist(Builder builder) {
        setPlaylistName(builder.playlistName);
        setPlaylistIntro(builder.playlistIntro);
        setPlaylistTag(builder.playlistTag);
        setMusics(builder.musics);
    }

    // 加入歌曲
    public void addMusicToPlaylist(Music music) {
        if (this.musics.size() <= 5) {
            this.musics.add(music);
        } else {
            System.out.println("歌單最多不能超過5個");
        }
    }

    // 使用歌名篩選曲
    public void addMusicToPlaylistByMusicName(ArrayList<Music> musics, String musicName) {
        for (Music music : musics) {
            if (music.getMusicName().equals(musicName)) {
                addMusicToPlaylist(music);
            }
        }
    }

    // 使用歌名關鍵字篩選曲
    public void addMusicToPlaylistByMusicNameKeyWord(ArrayList<Music> musics, String musicNameKeyWord) {
        for (Music music : musics) {
            if (music.getMusicName().contains(musicNameKeyWord)) {
                addMusicToPlaylist(music);
            }
        }
    }

    // 使用歌曲類型篩選曲
    public void addMusicToPlaylistByMusicType(ArrayList<Music> musics, String musicType) {
        for (Music music : musics) {
            if (music.getMusicType().equals(musicType)) {
                addMusicToPlaylist(music);
            }
        }
    }

    // 使用歌手篩選曲
    public void addMusicToPlaylistByMusicSinger(ArrayList<Music> musics, String musicSinger) {
        for (Music music : musics) {
            if (music.getMusicSinger().equals(musicSinger)) {
                addMusicToPlaylist(music);
            }
        }
    }

    // 使用歌手關鍵字篩選曲
    public void addMusicToPlaylistByMusicSingerKeyWord(ArrayList<Music> musics, String musicSingerKeyWord) {
        for (Music music : musics) {
            if (music.getMusicSinger().contains(musicSingerKeyWord)) {
                addMusicToPlaylist(music);
            }
        }
    }

    // 使用出版日篩選曲
    public void addMusicToPlaylistByReleaseDate(ArrayList<Music> musics, String releaseDate) {
        // 將格式 1970-01-01 轉換成 [1970, 1, 1]
        String[] newMusicreleaseDate = {};
        int[] numMusicreleaseDate = new int[3];
        newMusicreleaseDate = releaseDate.split("-");
        for (int i = 0; i < 3; i++) {
            numMusicreleaseDate[i] = Integer.parseInt(newMusicreleaseDate[i]);
        }

        for (Music music : musics) {
            if (music.getReleaseDate()[0] == numMusicreleaseDate[0] &&
                    music.getReleaseDate()[1] == numMusicreleaseDate[1] &&
                    music.getReleaseDate()[2] == numMusicreleaseDate[2]
            ) {
                addMusicToPlaylist(music);
            }
        }
    }

    // 使用發行日期範圍篩選曲
    public void addMusicToPlaylistByReleaseDate(ArrayList<Music> musics, String startReleaseDate, String endReleaseDate) {
        // 將格式 1970-01-01 轉換成 [1970, 1, 1]
        String[] newMusicreleaseDate = {};
        int[] numStartReleaseDate = new int[3];
        int[] numEndReleaseDate = new int[3];
        // 轉換起始日格式
        newMusicreleaseDate = startReleaseDate.split("-");
        for (int i = 0; i < 3; i++) {
            numStartReleaseDate[i] = Integer.parseInt(newMusicreleaseDate[i]);
        }
        // 轉換結束日格式
        newMusicreleaseDate = endReleaseDate.split("-");
        for (int i = 0; i < 3; i++) {
            numEndReleaseDate[i] = Integer.parseInt(newMusicreleaseDate[i]);
        }
        for (Music music : musics) {
            if (music.getReleaseDate()[0] >= numStartReleaseDate[0] && music.getReleaseDate()[0] <= numEndReleaseDate[0] &&
                    music.getReleaseDate()[1] >= numStartReleaseDate[1] && music.getReleaseDate()[1] <= numEndReleaseDate[1] &&
                    music.getReleaseDate()[2] >= numStartReleaseDate[2] && music.getReleaseDate()[2] <= numEndReleaseDate[2]
            ) {
                addMusicToPlaylist(music);
            }
        }
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistIntro() {
        return playlistIntro;
    }

    public void setPlaylistIntro(String playlistIntro) {
        this.playlistIntro = playlistIntro;
    }

    public String getPlaylistTag() {
        return playlistTag;
    }

    public void setPlaylistTag(String playlistTag) {
        this.playlistTag = playlistTag;
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }

    public static final class Builder {
        private String playlistName;
        private String playlistIntro;
        private String playlistTag;
        private ArrayList<Music> musics = new ArrayList<>();
        ;

        public Builder() {
        }

        public Builder setPlaylistName(String val) {
            playlistName = val;
            return this;
        }

        public Builder setPlaylistIntro(String val) {
            playlistIntro = val;
            return this;
        }

        public Builder setPlaylistTag(String val) {
            playlistTag = val;
            return this;
        }

        public Builder setMusics(ArrayList<Music> val) {
            musics = val;
            return this;
        }

        public Playlist build() {
            return new Playlist(this);
        }
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", playlistIntro='" + playlistIntro + '\'' +
                ", playlistTag='" + playlistTag + '\'' +
                ", musics=" + musics +
                '}';
    }
}
