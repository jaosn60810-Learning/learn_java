package com.company;

import java.util.Scanner;

public class CLinkedListStudent implements Iterator {

    private static class Node {

        private Student data;
        private Node next;

        public Node() {

        }

        public Node(Student data) {
            this.data = data;
        }
    }

    private Node root;
    private int count;
    private Node current;

    public CLinkedListStudent() {
        current = root = new Node();
        count = 0;
    }

    private Student checkSituation(Student data) {
        Node p = root.next;
        while (p != null) {
            if (data.getStudentID() == p.data.getStudentID() || data.getStudentID() < 1) {
                System.out.println("座號重複請重新輸入!!!");
                return null;
            }
            if (data.getENScore() > 100 || data.getENScore() < 0) {
                System.out.println("英文成績有問題，請重新輸入!!!");
                return null;
            }
            if (data.getMATHScore() > 100 || data.getMATHScore() < 0) {
                System.out.println("數學成績有問題，請重新輸入!!!");
                return null;
            }
            p = p.next;
        }
        return data;
    }

    public void add(Student data) {
        Node tmp = root;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        data = checkSituation(data);
        if(data == null) {
            return;
        } else {
            tmp.next = new Node(data);
            count++;
        }
    }

    public void remove(Student student) {
        int number = student.getStudentID();
        Node p = root;
        while (p.next != null) {
            if (p.next.data.getStudentID() == number) {
                Node temp = p.next.next;
                p.next = temp;
                break;
            }
            p = p.next;
        }
    }


    public void printList() {
        Node currNode = root;
        System.out.println("SN\t\tENG.\tMATH.\tAVG.\t");
        System.out.println("--------------------------------");
        // Traverse through the LinkedList
        while (currNode != null) {
            if (currNode.data == null) {
                currNode = currNode.next;
                continue;
            }
            // Print the data at current node
            System.out.println(currNode.data);
            // Go to next node
            currNode = currNode.next;
        }
    }

    public void newStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入座號");
        int studentID =0;
        boolean check;
        do {
            studentID = sc.nextInt();
            check = false;
            Node tmp = root;
            while (tmp.next != null) {
                tmp = tmp.next;
                if (tmp.data.getStudentID() == studentID) {
                    System.out.println("還敢重複輸入啊 冰鳥");
                    check = true;
                }
            }
        } while (check);
        System.out.println("請輸入成績");
        int ENScore = sc.nextInt();
        int MATHScore = sc.nextInt();
        Student student = new Student(studentID, ENScore, MATHScore);
        add(student);
    }

    public Student get(int index) {
        if (index < 0 || index >= count) {
            return null;
        }

        Node tmp = root;
        for (int i = 0; i < index + 1; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void sort() {

        for (int i = 0; i < count - 1; i++) {
            Node p = root.next;
            for (int k = 0; k < count - i - 1; k++) {
                if (p.next == null) {
                    break;
                }
                if (p.next != null) {
                    if (p.data.getAvrScore() < p.next.data.getAvrScore()) {
                        swap(p);
                    } else {
                        p = p.next;
                    }
                }
            }

        }
    }

    public void swap(Node change) {
        Node p = root;
        if (change.next != null) {
            while (p.next != change) {
                p = p.next;
            }
            Node temp1 = change.next;
            Node temp2 = change.next.next;
            change.next = temp2;
            p.next = temp1;
            temp1.next = change;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        if (current.next == null) {
            current = root;
            return false;
        }
        return true;
    }

    @Override
    public Student next() {
        current = current.next;
        return current.data;
    }
}
