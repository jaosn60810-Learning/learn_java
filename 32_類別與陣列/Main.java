public class Main {

    public static void main(String[] args) {
        Rectangle[] rects = new Rectangle[2];
        rects[0] = new Rectangle(5,4);
        rects[1] = new Rectangle(1,2);

        System.out.println(rects[0].getArea());
        System.out.println(rects[1].getParameter());
        System.out.println(rects[0].compare(rects[1]));
    }
}

