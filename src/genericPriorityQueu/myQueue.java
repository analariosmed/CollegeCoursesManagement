package genericPriorityQueu;
import java.util.List;

public class myQueue<E> {
    private int front;
    private int rear;
    private E[] myArr;
    private int size; // not the size of the array but the # of elements stored in the qeue

    public myQueue() {
        this.front = -1;
        this.rear = -1;
        this.myArr = (E[]) new Object[20];
    }

    public myQueue(List<E> elements) {
        this.front = -1;
        this.rear = -1;
        int listSize = elements.size();
        this.myArr = (E[]) new Object[2 * listSize]; // Double the size of the list
        this.size = 0;

        // Enqueue all elements from the list to the queue
        for (E element : elements) {
            enqueue(element);
        }
    }



    private boolean isEmpty(){
        return this.size == 0;
    }

    private boolean isFull(){
        return this.size == this.myArr.length;
    }

    private int getSize(){
        return this.size;
    }

    private void resize() {
        int currentSize = this.myArr.length;
        this.myArr = java.util.Arrays.copyOf(this.myArr, currentSize * 2);
    }

    public void enqueue(E element) {
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

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        E element = myArr[front];
        if (size == 1) {
            front = rear = -1; // Reset front and rear for single element
        } else {
            front = (front + 1) % myArr.length; // Handle wrap-around for front
        }
        size--;
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return myArr[front];
    }

    public void displayAllElements(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println(myArr[front]);
        } else if (front < rear) {
            for (int j = front; j <= rear; j++) {
                System.out.println(myArr[j]);
            }
        } else {
            for (int j=0; j <= rear; j++) {
                System.out.println(myArr[j]);
            }
            for (int j=front; j < myArr.length; j++) {
                System.out.println(myArr[j]);
            }
        }
    }
}
