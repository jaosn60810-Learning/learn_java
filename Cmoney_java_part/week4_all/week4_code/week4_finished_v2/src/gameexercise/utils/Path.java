package gameexercise.utils;

// img = IRC.instance().tryGetImage(new Imgs().actors().aircraft());   // 使用內部類繼承版本（需要先new 外部類別物件實體後，利用方法取得。
// 各類別的建構子都是private 只有留一個公開的方法取得（以傳入當前所在的位置） 這些公開方法是與他的上一層資料夾同級別（EX: actor的取得方法是放在imgs裡，而imgs則是放在Path裡
// Flow 跟 Resources 只是用於 讓路徑統一格式的傳回文字 跟 命名起始資料夾（根目錄 getClass().getResource() 之後的第一個資料夾）  
// 設計方式就是讓每個內部類別都是static 但裡面的資料(成員屬性及方法），不用static，透過最外層的資料夾，一直點進去。 

public class Path {
    public static abstract class Flow{  // 最父類別，把所有資料夾都變成Flow類型
        private String path;
        public Flow(String path){
            this.path = path;
        }
        public Flow(Flow flow, String path){
            this.path = flow.path + path;
        }
        @Override
        public String toString(){
            return path;
        }
    }
    private static class Resources extends Flow{ // 根目錄
        private Resources(){
            super("/resources");
        }
    }
    public static class Imgs extends Flow{  //第二層資料夾有 Imgs 跟 Sounds
        public Imgs(){
            super(new Resources(), "/imgs");
        }
        public static class Actors extends Flow{
            private Actors(Flow flow){
                super(flow, "/actors");
            }
            public String aircraft(){
                return this + "/airplane1.png"; // 這裡的this 也就Flow.toString 因為Object 碰到String會做toString
            }
            public String enemy(){
                return this + "/enemy1.png";
            }
            public String actors(){
                return this + "/actor1.png";
            }
        }
        public static class Objs extends Flow{
            private Objs(Flow flow){
                super(flow, "/objs");
            }
            public String boom(){
                return this + "/boom.png";
                // 可以改成匿名內部類別，回傳成類別，看自己的需求。
                /*
                public Flow Boom(){
                    return new Flow("/boom"){}
                }
                */
            }
            public String boom2(){
                return this + "/boom2.png";
            }
        }
        public static class Backgrounds extends Flow{
            private Backgrounds(Flow flow){
                super(flow, "/backgrounds");
            }
            public String sea(){
                return this + "/sea.png";
            }
            public String cloud(){
                return this + "/cloud.png";
            }
        }
        public Actors actors(){
            return new Actors(this);
        }
        public Objs objs(){
            return new Objs(this);
        }
        public Backgrounds backgrounds(){
            return new Backgrounds(this);
        }
    }
    public static class Sounds extends Flow{    //第二層資料夾有 Imgs 跟 Sounds
        private Sounds(){
            super(new Resources(), "/sounds");
        }
    }

    //讀取資料時先new 第一層的資料夾出來，在利用後續層數的資料夾的公開方法取得相關資料。
    public Imgs img(){
        return new Imgs();
    }
    public Sounds sound(){
        return new Sounds();
    }



}