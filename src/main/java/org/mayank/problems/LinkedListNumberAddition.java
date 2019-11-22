package org.mayank.problems;


import org.mayank.lists.LinkedList;
import org.mayank.lists.Node;

/**
 * Source: https://leetcode.com/problems/add-two-numbers/
 * Source: https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 */
public class LinkedListNumberAddition {

    public void sum(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        if (linkedList1 == null && linkedList2 == null) {
            System.out.println("Nothing to add..");
        }
        if (linkedList1 == null) {
            if (linkedList2 != null) {
                linkedList2.printLinkedList();
            }
            return;
        }
        if (linkedList2 == null) {
            if (linkedList1 != null) {
                linkedList1.printLinkedList();
            }
            return;
        }
        int carry = 0;
        LinkedList<Integer> sum = new LinkedList<Integer>();
        Node<Integer> headLinkedList1 = linkedList1.getFront();
        Node<Integer> headLinkedList2 = linkedList2.getFront();
        while (headLinkedList1 != null && headLinkedList2 != null) {
            int sumOfElements = (headLinkedList1.getValue() + headLinkedList2.getValue() + carry) % 10;
            carry = (headLinkedList1.getValue() + headLinkedList2.getValue() + carry) / 10;
            sum.insertAtEnd(sumOfElements);
            headLinkedList1 = headLinkedList1.getNext();
            headLinkedList2 = headLinkedList2.getNext();
        }
        while (headLinkedList2 != null) {
            int sumOfElements = (headLinkedList2.getValue() + carry) % 10;
            carry = (headLinkedList2.getValue() + carry) / 10;
            sum.insertAtEnd(sumOfElements);
            headLinkedList2 = headLinkedList2.getNext();
        }
        while (headLinkedList1 != null) {
            int sumOfElements = (headLinkedList1.getValue() + carry) % 10;
            carry = (headLinkedList1.getValue() + carry) / 10;
            sum.insertAtEnd(sumOfElements);
            headLinkedList1 = headLinkedList1.getNext();
        }
        if (carry > 0) {
            sum.insertAtEnd(carry);
        }
        sum.printLinkedList();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedListNumber1 = new LinkedList<Integer>();
        LinkedList<Integer> linkedListNumber2 = new LinkedList<Integer>();
        //544
        linkedListNumber1.insertAtFront(5);
        linkedListNumber1.insertAtFront(4);
        linkedListNumber1.insertAtFront(4);

        //6565
        linkedListNumber2.insertAtFront(6);
        linkedListNumber2.insertAtFront(5);
        linkedListNumber2.insertAtFront(6);
        linkedListNumber2.insertAtFront(5);
        linkedListNumber1.printLinkedList();
        linkedListNumber2.printLinkedList();
        LinkedListNumberAddition linkedListNumberAddition = new LinkedListNumberAddition();
        linkedListNumberAddition.sum(linkedListNumber1, linkedListNumber2);
    }
}
