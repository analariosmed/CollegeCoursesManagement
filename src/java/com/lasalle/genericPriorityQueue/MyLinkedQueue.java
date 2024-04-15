package com.lasalle.genericPriorityQueue;

import java.util.List;
import java.util.NoSuchElementException;

public class MyLinkedQueue<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size;

    // Constructor to create a queue from a list of elements
    public MyLinkedQueue(List<E> list) {
        this.front = null;
        this.rear = null;
        this.size = 0;

        // Enqueue all elements from the list to the queue
        for (E element : list) {
            enqueue(element);
        }
    }

    // check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to add an element to the rear of the queue
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    // Method to remove and return the element at the front of the queue
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E element = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return element;
    }

    // Node class for linked list
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

}
