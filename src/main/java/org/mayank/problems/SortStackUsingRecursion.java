package org.mayank.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 *
 */
public class SortStackUsingRecursion {

    Stack<Integer> stack;

    public SortStackUsingRecursion(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void sortStack(){
        if(!this.stack.isEmpty()){
            int elementAtTop = this.stack.peek();
            this.stack.pop();
            this.sortStack();
            this.insertAtBottomInSortedOrder(elementAtTop);
        }
    }

    public void insertAtBottomInSortedOrder(int value){
        if(this.stack.isEmpty()){
            stack.push(value);
        }
        else {
            int elementAtTop = this.stack.peek();
            if(elementAtTop>value){
                this.stack.pop();
                insertAtBottomInSortedOrder(value);
                this.stack.push(elementAtTop);
            }
            else {
                stack.push(value);
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(20);
        stack.push(-1);
        stack.push(10);
        stack.push(2);
        stack.push(2);
        stack.push(30);
        SortStackUsingRecursion sortStackUsingRecursion = new SortStackUsingRecursion(stack);
        System.out.println(Arrays.toString(sortStackUsingRecursion.stack.toArray()));
        sortStackUsingRecursion.sortStack();
        System.out.println(Arrays.toString(sortStackUsingRecursion.stack.toArray()));
    }
}
