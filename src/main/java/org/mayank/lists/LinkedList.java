package org.mayank.lists;


public class LinkedList<T> {

    Node<T> front;
    Node<T> rear;

    //Inserts element at the head/front of the linked list
    public void insertAtFront(T value) {
        Node<T> node = new Node<T>(value);
        if (front == null && rear == null) {
            front = rear = node;
            return;
        }
        node.next = front;
        front = node;
        return;
    }

    //Inserts element at the rear/end of the linked list
    public void insertAtEnd(T value) {
        Node<T> node = new Node<T>(value);
        if (front == null && rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = rear.next;
        return;
    }

    /**
     * Prints the linkedList
     */
    public void printLinkedList() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public Node<T> getFront() {
        return front;
    }

    public Node<T> getRear() {
        return rear;
    }
}
