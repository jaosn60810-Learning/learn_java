package com.company;

public class CArrayList implements Iterator {
    private int[] arr;
    private int count;
    private int current;

    public CArrayList() {
        arr = new int[2];
        count = 0;
        current = 0;
    }

    private void doubleArr() {
        int[] tmpArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i];
        }
        arr = tmpArr;
    }

    public void add(int data) {
        if (count == arr.length) {
            doubleArr();
        }
        arr[count++] = data;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return arr[index];
    }

    @Override
    public boolean hasNext() {
        if (current >= count) {
            current = 0;
            return false;
        }
        return true;
    }

    @Override
    public int next() {
        return arr[current++];
    }
}
