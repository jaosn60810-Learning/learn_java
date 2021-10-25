package com.company;

public interface Iterator<T> {

    public interface Filter<T>{
        public boolean filter(T t1);
    }

    public interface Map<T>{
        public void action(T t1);
    }

    public boolean hasNext();
    public T next();

}
