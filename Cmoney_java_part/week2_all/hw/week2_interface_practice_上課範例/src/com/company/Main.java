package com.company;

public class Main{

    public static void main(String[] args) {
        StudentArray arr = new StudentArray();

        // 自動產生 10 個學生
        for (int i = 0; i < 10; i++) {
            arr.add(new Student.Builder().
                    setSeat(Input.randomInputNum("自動產生", 1, 10)).
                    setName(Input.randomInputString("自動產生", 3, 3)).
                    setScore(Input.randomInputNum("自動產生", 0, 100)).
                    build());
        }
        System.out.println("--------------------------------");
        printAllStu(arr);

        // 篩選
        StudentArray.Filter filter = (Student student) -> student.getSeat() < 6;
        StudentArray filterResult = arr.where(filter);
        printAllStu(filterResult);

        // 排序
        StudentArray sortResult = arr.sort((Student s1, Student s2) -> s1.getName().compareTo(s2.getName()));
        printAllStu(sortResult);

        // 篩選加排序
        StudentArray result = arr
                .where((Student student) -> student.getSeat() < 5)
                .sort((Student s1, Student s2) -> s1.getScore() - s2.getScore());
        printAllStu(result);
    }

    public static void printAllStu(StudentArray studentArray) {
        for (int i = 0; i < studentArray.getCount(); i++) {
            System.out.println(studentArray.getStudentByIndex(i));
        }
        System.out.println("--------------------------------");
    }
}


