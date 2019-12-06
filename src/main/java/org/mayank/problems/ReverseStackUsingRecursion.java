package org.mayank.problems;

import java.util.Stack;

/**
 * Created by mayank.goel on 06/12/19.
 */
public class ReverseStackUsingRecursion {

    public Stack<Integer> stack;

    public ReverseStackUsingRecursion(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void reverseUsingRecursion(){
        if(!this.stack.isEmpty()){
            int element = this.stack.peek();
            this.stack.pop();
            reverseUsingRecursion();
            insertInStack(element);
        }
    }

    private void insertInStack(int element){
        if(this.stack.isEmpty()){
            this.stack.push(element);
        }
        else {
            int elem = this.stack.peek();
            this.stack.pop();
            insertInStack(element);
            this.stack.push(elem);
        }
    }

    public void printStack(){
        while (!this.stack.isEmpty()){
            System.out.println(this.stack.toString());
        }
    }

    public static void main(String[] args) {
        ReverseStackUsingRecursion reverseStackUsingRecursion = new ReverseStackUsingRecursion(new Stack<Integer>());
        reverseStackUsingRecursion.stack.push(2);
        reverseStackUsingRecursion.stack.push(3);
        reverseStackUsingRecursion.stack.push(4);
        reverseStackUsingRecursion.stack.push(5);
        reverseStackUsingRecursion.stack.push(6);
        reverseStackUsingRecursion.stack.push(7);
        reverseStackUsingRecursion.stack.push(8);
        reverseStackUsingRecursion.reverseUsingRecursion();
        reverseStackUsingRecursion.printStack();
    }
}
