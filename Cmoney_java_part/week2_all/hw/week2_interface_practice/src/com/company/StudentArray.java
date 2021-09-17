package com.company;

/** 創造學生陣列用，用來儲存學生物件
 *
 */
public class StudentArray {
    private Student[] arr;
    private int count;

    /** 比較器介面
     *
     */
    public interface Comparator {
        public int compare(Student s1, Student s2);
    }

    /** 篩選器介面
     *
     */
    public interface Filter {
        public boolean filter(Student student);
    }

    /**
     *  建構子
     */
    public StudentArray() {
        this.arr = new Student[2];
        this.count = 0;
    }

    /** 將學生物件加到學生陣列的最後一個
     * @param student  要加入的學生物件
     */
    public void add(Student student) {
        // 如果加入為 null
        if (student == null) {
            return;
        }
        // 如果加入時，學生陣列已經滿了，需要增加空間
        if (this.count == this.arr.length) {
            doubleArr();
        }
        // 將學生物件加到學生陣列中
        this.arr[count++] = student;
    }

    /** 使用 index 找到該位置的學生，並回傳此學生物件
     * @param index 要找的位置
     * @return Student 回傳學生物件
     */
    public Student getStudentByIndex(int index) {
        // 如果 index < 0 或大於現有的學生物件數量，則回傳 null
        if (index < 0 || index >= count) {
            return null;
        }
        // 回傳該位置的學生物件
        return this.arr[index];
    }

    /** 使用篩選器找到符合條件的學生，加到一個暫時的 StudentArray ，並回傳 StudentArray
     * @param filter 使用的篩選器
     * @return StudentArray 回傳 StudentArray
     */
    public StudentArray where(Filter filter) {
        // 創建一個暫時的學生陣列
        StudentArray tmpArr = new StudentArray();

        // 將符合篩選器的學生加入到暫時的學生陣列
        for (int i = 0; i < this.count; i++) {
            Student tmpStudent = this.arr[i];
            if (filter.filter(tmpStudent)) {
                tmpArr.add(tmpStudent);
            }
        }
        return tmpArr;
    }

    /** 使用比較器排序，並回傳 StudentArray
     * @param c 使用的比較器
     * @return StudentArray 回傳 StudentArray
     */
    public StudentArray sort(Comparator c) {
        // 創建一個暫時的學生陣列
        StudentArray tmpArr = new StudentArray();

        // 將遠本的學生陣列深度拷貝到暫時的學生陣列
        for (int i = 0; i < this.count; i++) {
            tmpArr.add(this.arr[i]);
        }

        // 將暫時的學生陣列進行泡沫排序
        for (int i = 0; i < this.count - 1; i++) {
            for (int j = 0; j < this.count - i - 1; j++) {
                if (c.compare(tmpArr.getStudentByIndex(j), tmpArr.getStudentByIndex(j + 1)) > 0) {
                    tmpArr.swap(j, j + 1);
                }
            }
        }
        return tmpArr;
    }

    /** 回傳現在有幾個學生
     * @return int 學生數量
     */
    public int length() {
        return this.count;
    }

    /** 將學生陣列空間乘以兩倍，並將東西轉移到新陣列
     *
     */
    private void doubleArr() {
        // 創建一個暫時的學生陣列
        Student[] tmpArr = new Student[arr.length * 2];

        // 將遠本的學生陣列深度拷貝到暫時的學生陣列
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = this.arr[i];
        }

        this.arr = tmpArr;
    }

    /** 將學生陣列的兩個學生物件互換位置
     * @param i1
     * @param i2
     */
    private void swap(int i1, int i2) {
        Student tmp = this.arr[i1];
        this.arr[i1] = this.arr[i2];
        this.arr[i2] = tmp;
    }

    // Getter and Setter
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
