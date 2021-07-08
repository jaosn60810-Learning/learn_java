import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[2];
        int count = 0;
        Student student;
        do {
            student = null;
            System.out.println("請選擇功能");
//            int opt = input("請選擇功能", 1, 6, null, false);
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    int seat = input("請輸入座號", 1, 100, null, true);
                    String schoolClass = input("請輸入班級", 1, true);
                    String name = input("請輸入姓名", 3, true);
                    int score = input("請輸入成績", 1, 100, null, true);
                    if (students.length == count)
                        students = doubleArr(students);
                    students[count++] = new Student(seat, schoolClass, name, score);
                    break;
                case 2:
                    student = getStudent(sc.nextInt(), students, count);
                    if (student == null)
                        System.out.println("找不到");
                    else
                        student.print();
                    break;
                case 3:
                    sortByScore(students, count);
                    break;
                case 4:
                    sortBySeat(students, count);
                    break;
                case 5:
                    student = getStudent(sc.nextInt(), students, count);
                    if (student == null)
                        System.out.println("找不到");
                    else
                        student.setScore(sc.nextInt());
                    break;
                case 6:
                    System.exit(0);
                case 7:
                    printAll(students, count);

            }


        } while (true);

    }

    public static void sortBySeat(Student[] students, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getSeat() > students[j + 1].getSeat()) {
                    swap(students, j, j + 1);
                }
            }
        }
    }

    public static void sortByScore(Student[] students, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].compareTo(students[j + 1]) < 0) {
                    swap(students, j, j + 1);
                }
            }
        }
    }

    public static void swap(Student[] students, int i1, int i2) {
        Student tmp = students[i1];
        students[i1] = students[i2];
        students[i2] = tmp;
    }

    public static void printAll(Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            students[i].print();
        }
    }

    public static Student getStudent(int seat, Student[] students, int count) {
        for (int i = 0; i < count; i++) {
            if (students[i].getSeat() == seat)
                return students[i];
        }
        return null;
    }

    public static Student[] doubleArr(Student[] arr) {
        Student[] tmpArr = new Student[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i];
        }
        return tmpArr;
    }

    public static String input(String hint, int lengh, boolean isRandom) {
        Scanner sc = new Scanner(System.in);
        System.out.println(hint + ":");
        String str;
        if (isRandom) {
            str = "";
            for (int i = 0; i < lengh; i++) {
                str += (char) random(97, 122);
            }
            System.out.println("自動產生:" + str);
            return str;
        }
        do {
            System.out.print(hint + "(長度至少為" + lengh + "):");
            str = sc.nextLine();
            if (str.length() >= lengh) {
                return str;
            }
            System.out.println("請重新輸入");
        } while (true);
    }

    public static int input(String hint, int min, int max, int[] avs, boolean isRandom) {
        Scanner sc = new Scanner(System.in);
        System.out.println(hint + ":");
        int n;
        if (isRandom) {
            int r = random(min, max);
            System.out.println("自動產生" + r);
            return r;
        }
        return -1;
    }

    public static int random(int min, int max) {
        int num = (int) (Math.random() * (max - min + 1) + min);
        return num;
    }

}

