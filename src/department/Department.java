package department;
import java.util.HashMap;
import java.util.ArrayList;
public class Department {

    private HashMap<String, Course> courseMap;
    private ArrayList<Professor> listOfProfs;

    public Department(ArrayList<Professor> listOfProfs) {
        this.courseMap = new HashMap<>();
        this.listOfProfs = listOfProfs;
    }

    // Getters and setters for courseMap and listOfProfs (optional)

    // Add methods specific to department functionality (optional)
}
