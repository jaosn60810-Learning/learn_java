package com.company;

public class StudentArray {


    public interface Comparator {
        public int compare(Student s1, Student s2);
    }

    public interface Filter {
        public boolean filter(Student student);
    }

    private Student[] arr;
    private int count;

    public StudentArray() {
        this.arr = new Student[2];
        this.count = 0;
    }

    public void add(Student student) {
        if (student == null) {
            return;
        }
        if (this.count == this.arr.length) {
            doubleArr();
        }
        this.arr[count++] = student;
    }

    public Student getStudentByIndex(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        return this.arr[index];
    }

    public StudentArray where(Filter filter) {
        StudentArray tmpArr = new StudentArray();
        for (int i = 0; i < this.count; i++) {
            if (filter.filter(this.arr[i])) {
                tmpArr.add(this.arr[i]);
            }
        }
        return tmpArr;
    }

    public StudentArray sort(Comparator c) {
        StudentArray tmpArr = new StudentArray();
        for (int i = 0; i < this.count; i++) {
            tmpArr.add(this.arr[i]);
        }
        for (int i = 0; i < this.count - 1; i++) {
            for (int j = 0; j < this.count - i - 1; j++) {
                if (c.compare(tmpArr.getStudentByIndex(j), tmpArr.getStudentByIndex(j + 1)) > 0) {
                    tmpArr.swap(j, j + 1);
                }
            }
        }
        return tmpArr;
    }

    public int length() {
        return this.count;
    }

    private void doubleArr() {
        Student[] tmpArr = new Student[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = this.arr[i];
        }
        this.arr = tmpArr;
    }

    private void swap(int i1, int i2) {
        Student tmp = this.arr[i1];
        this.arr[i1] = this.arr[i2];
        this.arr[i2] = tmp;
    }

    public Student[] getArr() {
        return arr;
    }

    public void setArr(Student[] arr) {
        this.arr = arr;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
