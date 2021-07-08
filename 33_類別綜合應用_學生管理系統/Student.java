public class Student {
    private int seat;
    private String schoolClass;
    private String name;
    private int score;


    public Student(int seat, String schoolClass, String name) {
        this(seat, schoolClass, name, 0);
    }

    public Student(int seat, String schoolClass, String name, int score) {
        setSeat(seat);
        this.schoolClass = schoolClass;
        this.name = name;
        setScore(score);

    }

    private void setSeat(int seat) {
        if (seat <= 0)
            this.seat = 1;
        this.seat = seat;

    }

    public int getSeat() {
        return this.seat;
    }

    public String getSchoolClass() {
        return this.schoolClass;
    }

    public String getName() {
        return this.name;
    }

    public void setScore(int score) {
        if (score < 0 || score > 100)
            this.score = 0;
        this.score = score;

    }

    public int getScore() {
        return this.score;
    }

    public void print() {
        System.out.println("班級: " + this.schoolClass + " 座號: " + this.seat + " 姓名: " + this.name + " 成績: " + this.score);
    }

    public int compareTo(Student student) {
        return this.score - student.score;
    }


}
