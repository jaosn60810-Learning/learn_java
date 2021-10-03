package controllers;

//單例模式 Singleton
import utils.Global;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class IRC {

    private static class KeyPair {

        private String path;
        private Image img;

        public KeyPair(String path, Image img) {
            this.path = path;
            this.img = img;
        }
    }// 用來包裝IRC的路徑及圖片 路徑拿來比對，圖片才是要的資料。

    //單例，確保整個程式只有一個IRC，目前沒辦法
    private IRC irc; // 原本是static 
    //內容
    private ArrayList<KeyPair> imgPairs; //用來存一堆路徑+圖片的實體

    public IRC() {
        imgPairs = new ArrayList<>();
    }//確保整個程式只有一個，所以建構子設private - new出ArrayList
    //但因為場景切換的問題，目前無法使用單例模式就完成場景切換

    public IRC instance() {
        if (irc == null) {
            irc = new IRC();
        }
        return irc;
    }//如果irc 不存在，建立一個，已經在的話直接傳回irc，不會重複創立

    public Image tryGetImage(String path) {
        KeyPair pair = findKeyPair(path);  // 依照路徑尋找images 裡的圖片
        if(pair == null){
            //找不到 => 創建並回傳
            return addImage(path);
        }
        //找到 => 直接回傳
        return pair.img;
    }//如果image 不存在，啟用addImage將圖片放入imgPairs裡面並傳回，已經在的話就直接取出，不會清單內圖片不會重複
    // -> getClass().getResource()寫在 addImage

    private Image addImage(String path) {
        try{
            if (Global.IS_DEBUG){
                System.out.println("Load img from: " + path);
            }
            Image img = ImageIO.read(getClass().getResource(path));
            //只要有IO的部分就會特別慢，路徑是URI的格式
            imgPairs.add(new KeyPair(path, img));
            return img;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private KeyPair findKeyPair(String path) {
        for (int i = 0; i < imgPairs.size(); i++) {
            KeyPair pair = imgPairs.get(i);
            if (pair.path.equals(path)){
                return pair;
            }
        }
        return null;
    }

    public void clear(){
        imgPairs.clear();
    }

    //作標記 -> 標記那些資源是這個場景開始後才載入的
}