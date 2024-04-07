import department.Professor;
import genericPriorityQueu.myQueue;

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

        q1.displayAllElements();
    }
}