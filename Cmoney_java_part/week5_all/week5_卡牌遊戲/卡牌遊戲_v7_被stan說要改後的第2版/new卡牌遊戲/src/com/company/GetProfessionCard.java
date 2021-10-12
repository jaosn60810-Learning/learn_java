package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetProfessionCard {

    private static BufferedReader br;

    public static Card[] getProfessionAllCard(int fate) throws IOException {
        switch (fate) {
            case 1:
                return loadCardsData("warrior");
            case 2:
                return loadCardsData("priest");
            case 3:
                return loadCardsData("wizard");
            case 4:
                return loadCardsData("monk");
        }
        return null;
    }

    public static Card[] loadCardsData(String profession) throws IOException {
        br = new BufferedReader(new FileReader(profession + ".txt"));
        String loadData;
        ArrayList<String[]> loadDataSplit = new ArrayList<>();
        String[] temp;
        while (br.ready()) {
            loadData = br.readLine();
            temp = loadData.split(",");
            loadDataSplit.add(temp);
        }
        Card[] tmp = new Card[loadDataSplit.size()];

        for (int i = 0; i < loadDataSplit.size(); ++i) {
            String[] c = loadDataSplit.get(i);
            tmp[i] = new Card(Integer.parseInt(c[0]),
                    c[1],
                    Integer.parseInt(c[2]),
                    c[3],
                    Integer.parseInt(c[4]),
                    Integer.parseInt(c[5]),
                    Integer.parseInt(c[6]),
                    Integer.parseInt(c[7]));
        }
        return tmp;
    }

    public static Card getProfessionOneCard(int cardNum) throws IOException {
        br = new BufferedReader(new FileReader("allCard.txt"));
        String loadData;
        String[] loadDataSplit = null;
        String num = cardNum + "";
        while (br.ready()) {
            loadData = br.readLine();
            loadDataSplit = loadData.split(",");
            if (loadDataSplit[0].equals(num)) {
                break;
            }
        }
        String[] c = loadDataSplit;
        return new Card(Integer.parseInt(c[0]),
                c[1],
                Integer.parseInt(c[2]),
                c[3],
                Integer.parseInt(c[4]),
                Integer.parseInt(c[5]),
                Integer.parseInt(c[6]),
                Integer.parseInt(c[7]));
    }

    public static void printAllCard() throws IOException {
        br = new BufferedReader(new FileReader("allCard.txt"));
        String loadData;
        String[] loadDataSplit = null;
        while (br.ready()) {
            loadData = br.readLine();
            loadDataSplit = loadData.split(",");
            System.out.println("卡片編號:" + loadDataSplit[0]
                    + "  卡片名稱:" + loadDataSplit[1]
                    + "  卡片數值:" + loadDataSplit[2]
                    + "  卡片效果:" + loadDataSplit[3]);
        }
    }

    public static void printProfessionCard(int fate) throws IOException {
        switch (fate) {
            case 1:
                printCard("warrior");
                break;
            case 2:
                printCard("priest");
                break;
            case 3:
                printCard("wizard");
                break;
            case 4:
                printCard("monk");
        }
    }


    public static void printCard(String profession) throws IOException {
        br = new BufferedReader(new FileReader(profession + ".txt"));
        String loadData;
        String[] loadDataSplit = null;
        while (br.ready()) {
            loadData = br.readLine();
            loadDataSplit = loadData.split(",");
            System.out.println("卡片編號:" + loadDataSplit[0]
                    + "  卡片名稱:" + loadDataSplit[1]
                    + "  卡片數值:" + loadDataSplit[2]
                    + "  卡片效果:" + loadDataSplit[3]);
        }
    }
}

