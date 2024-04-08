package genericPriorityQueu;

public class myPriorityQueue<T extends Comparable<T>> extends myQueue<T> {
//public class myPriorityQueue<T> extends myQueue<T> {

    @Override
    public void enqueue(T element) {
        super.enqueue(element);
        // only move here

        int i = size-1;//rear?
        while (i > 0 && element.compareTo(myArr[i-1])>0) {
            myArr[i] = myArr[i-1];
            i--;
        }
        myArr[i] = element;

    }

    public void displayElement(T element) {
        for (int i = 0; i < size; i++) {
            if (myArr[i] == element) {
                System.out.println(myArr[i]);
                return;
            }
        }
        System.out.println("Element not found");
    }

    public void displayHigherElements(T element) {
        for (int i = 0; i < size; i++) {
            if (myArr[i].compareTo(element) > 0) {
                System.out.println(myArr[i]);
            }
        }
    }

    public void displayLowerElements(T element) {
        for (int i = 0; i < size; i++) {
            if (myArr[i].compareTo(element) < 0) {
                System.out.println(myArr[i]);
            }
        }
    }
}