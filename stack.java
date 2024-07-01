import java.util.*;

class Stack {
    private int top;
    private int[] a = new int[10];

    public Stack() {
        top = -1;
    }

    public void push(int data) {
        if (top == 9) {
            System.out.println("Stack is full!!");
        } else {
            top++;
            a[top] = data;

        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("stack is empty!!!");

        } else {
            System.out.println("the popped item it" + a[top]);
            top--;
        }
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.println("The item in the stack is " + a[i]);
        }
    }
}
