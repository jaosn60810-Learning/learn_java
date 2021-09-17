package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Input input = new Input();
        // 建立歌曲庫
        ArrayList<Music> musics = new ArrayList<>();

        System.out.println("請決定此次程式進行為自動輸入1/手動輸入2");
        int chooseMode = sc.nextInt();
        sc.nextLine();

        System.out.println("請開始建立歌曲");
        if (chooseMode == 2) {
            System.out.println("請輸入:\n名稱\n發行日期\n音樂類型\n歌手\n");
            Music music = new Music.Builder().
                    setMusicName(sc.nextLine()).
                    setReleaseDate(sc.nextLine()).
                    setMusicType(sc.nextLine()).
                    setMusicSinger(sc.nextLine()).
                    build();
            musics.add(music);
        } else {
            for (int i = 0; i < 3; i++) {
                Music music = new Music.Builder().
                        setMusicName(input.randomInputString("自動輸入", 1, 2)).
                        setReleaseDate(input.randomInputDate("自動輸入歌曲出版日")).
                        setMusicType(input.randomInputString("自動輸入歌曲類別", 1, 2)).
                        setMusicSinger(input.randomInputString("自動輸入", 1, 2)).
                        build();
                System.out.println(music);
                musics.add(music);
            }
        }

        // 建立歌單庫
        ArrayList<Playlist> playlists = new ArrayList<>();

        System.out.println(musics);

        while (true) {
            System.out.println("請輸入功能");
            int opt = sc.nextInt();
            sc.nextLine();
            Playlist playlist = new Playlist.Builder().build();
            switch (opt) {
                case 1:
                    // 加入歌單
                    System.out.println("請開始建立歌單");
                    System.out.println("請輸入歌單名稱");
                    playlist.setPlaylistName(sc.nextLine());
                    System.out.println("請輸入歌單簡介");
                    playlist.setPlaylistIntro(sc.nextLine());
                    // 加入歌單庫
                    playlists.add(playlist);
                    // 依據篩選條件歌曲並加入歌單庫
                    System.out.println("請輸入篩選條件");
                    int filterCondition = sc.nextInt();
                    sc.nextLine();
                    addMusicToPlatListByFilter(playlists, musics, filterCondition);
                    break;
                case 2:
                    System.out.println("請輸入要找的歌單名稱");
                    playlist = findPlaylistByPlaylistName(playlists, sc.nextLine());
                    System.out.println("選擇子功能");
                    int subFunc = sc.nextInt();
                    sc.nextLine();
                    switch (subFunc) {
                        case 1:
                            // 依據篩選條件歌曲並加入歌單庫
                            System.out.println("請輸入篩選條件");
                            filterCondition = sc.nextInt();
                            sc.nextLine();
                            addMusicToPlatListByFilter(playlists, musics, filterCondition);
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 3:
                    printAllMusic(musics);
                    break;
                case 4:
                    System.exit(0);
            }
        }


    }

    public static void addMusicToPlatListByFilter(ArrayList<Playlist> playlists, ArrayList<Music> musics, int filterCondition) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = playlists.get(playlists.size() - 1);
        switch (filterCondition) {
            case 1:
                // 使用歌名篩選加入歌單
                System.out.println("請輸入歌名");
                playlist.addMusicToPlaylistByMusicName(musics, sc.nextLine());
                playlists.add(playlist);
                System.out.println(playlist);
                break;
            case 2:
                // 使用音樂類型篩選加入歌單
                System.out.println("請輸入音樂類型");
                playlist.addMusicToPlaylistByMusicType(musics, sc.nextLine());
                playlists.add(playlist);
                System.out.println(playlist);
                break;
            case 3:
                // 使用出版日篩選加入歌單
                System.out.println("請輸入出版日(例如: 2000-01-01)");
                playlist.addMusicToPlaylistByReleaseDate(musics, sc.nextLine());
                playlists.add(playlist);
                System.out.println(playlist);
                break;
            case 4:
                // 使用歌手篩選加入歌單
                System.out.println("請輸入歌手");
                playlist.addMusicToPlaylistByMusicSinger(musics, sc.nextLine());
                playlists.add(playlist);
                System.out.println(playlist);
                break;
            case 5:
                // 使用發行日期範圍篩選曲
                System.out.println("請輸入發行日期範圍起始日(例如: 2000-01-01)");
                String startReleaseDate = sc.nextLine();
                System.out.println("請輸入發行日期範圍結束日(例如: 2000-01-01)");
                String endReleaseDate = sc.nextLine();
                playlist.addMusicToPlaylistByReleaseDate(musics, startReleaseDate, endReleaseDate);
                playlists.add(playlist);
                System.out.println(playlist);
                break;
            case 6:
                // 使用歌名關鍵字篩選曲
                System.out.println("請輸入歌名關鍵字");
                playlist.addMusicToPlaylistByMusicNameKeyWord(musics, sc.nextLine());
                playlists.add(playlist);
                System.out.println(playlist);
                break;
            case 7:
                // 使用歌手關鍵字篩選曲
                System.out.println("請輸入歌手關鍵字");
                playlist.addMusicToPlaylistByMusicSingerKeyWord(musics, sc.nextLine());
                playlists.add(playlist);
                System.out.println(playlist);
                break;
        }
    }

    public static void printAllMusic(ArrayList<Music> musics) {
        for (Music music : musics) {
            System.out.println(music);
        }
    }

    public static Playlist findPlaylistByPlaylistName(ArrayList<Playlist> playlists, String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getPlaylistName().equals(playlistName)) {
                System.out.println(playlist);
                return playlist;
            }
        }
        System.out.println("查無此歌單");
        return null;
    }
}
