package com.lasalle.genericPriorityQueue;

import java.util.List;

public class MyQueue<T> {
    private int front;
    private int rear;
    T[] myArr;
    int size; // not the size of the array but the # of myArr stored in the qeue

    public MyQueue() {
        this.front = -1;
        this.rear = -1;
        this.myArr = (T[]) new Comparable[20];
    }

    public MyQueue(List<T> myArr) {
        this.front = -1;
        this.rear = -1;
        int listSize = myArr.size();
        this.myArr = (T[]) new Comparable[2 * listSize]; // Double the size of the list
        this.size = 0;

        // Enqueue all myArr from the list to the queue
        for (T element : myArr) {
            enqueue(element);
        }
    }


    private boolean isEmpty() {
        return this.size == 0;
    }

    boolean isFull() {
        return this.size == this.myArr.length;
    }

    private int getSize() {
        return this.size;
    }

    void resize() {
        T[] tempArr = (T[]) (new Comparable[myArr.length * 2]);
        int i = 0;
        int j = front;

        do {
            tempArr[i++] = myArr[j];
            j = (j + 1) % myArr.length;
            rear++;
        } while (j != front);

        front = 0;
        rear = size - 1;
        myArr = tempArr;
    } // order

    public void enqueue(T element) {
        if (isFull()) {
            resize();
        }
        if (isEmpty()) {
            front = 0; // Set front for the first element
        }
        rear = (rear + 1) % myArr.length; // Handle wrap-around for rear
        myArr[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T element = myArr[front];
        if (size == 1) {
            front = rear = -1; // Reset front and rear for single element
        } else {
            front = (front + 1) % myArr.length; // Handle wrap-around for front
        }
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return myArr[front];
    }


    public void displayAllElements() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println(myArr[front]);
        } else if (front < rear) {
            for (int j = front; j <= rear; j++) {
                System.out.println(myArr[j]);
            }
        } else {
            for (int j = 0; j <= rear; j++) {
                System.out.println(myArr[j]);
            }
            for (int j = front; j < myArr.length; j++) {
                System.out.println(myArr[j]);
            }
        }
    }
}
