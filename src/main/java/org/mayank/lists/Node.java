package org.mayank.lists;

/**
 * Created by mayank.goel on 22/11/19.
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }
}
