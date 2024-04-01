package genericPriorityQueu;

public class myQueue {
    private int front;
    private int rear;
    private int[] myArr;
    private int size; // not the size of the array but the # of elements stored in the qeue

    public myQueue(int front, int rear, int[] myArr, int size) {
        this.front = -1;
        this.rear = -1;
        this.myArr = new int[20];
        this.size = 0;
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

    public void enqueue(int element) {
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

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        int element = myArr[front];
        if (size == 1) {
            front = rear = -1; // Reset front and rear for single element
        } else {
            front = (front + 1) % myArr.length; // Handle wrap-around for front
        }
        size--;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return myArr[front];
    }
}
