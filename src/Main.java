import department.Professor;
import genericPriorityQueu.myQueue;
import genericPriorityQueu.myPriorityQueue;

import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        myQueue q1 = new myQueue();
        q1.enqueue(10);
        q1.enqueue(5);
        q1.enqueue(20);
        q1.enqueue(15);
        q1.enqueue(25);
        q1.enqueue(40);
        q1.enqueue(35);
        q1.enqueue(30);

        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();

        q1.enqueue(10);
        q1.enqueue(5);

        //q1.displayAllElements();

        myPriorityQueue<Integer> q2 = new myPriorityQueue<Integer>();
        q2.enqueue(10);
        q2.enqueue(5);
        q2.enqueue(20);
        q2.enqueue(15);
        q2.enqueue(25);
        q2.enqueue(40);
        q2.enqueue(35);
        q2.enqueue(30);


        q2.dequeue();

        q2.displayAllElements();

        //q2.displayHigherElements(16);


        Professor p1 = new Professor(11111, "Michelle", "Khalife", 3, "2017-23-01", <>);
    }
}