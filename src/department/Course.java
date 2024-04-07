package department;

public class Course {
        private int id;
        private String title;
        private String discipline;
        private byte numberOfHours;
        private byte numberOfGroups;

        private Course(){

        }
        public Course(int id, String title, String discipline, byte numberOfHours, byte numberOfGroups) {
                this.id = id;
                this.title = title;
                this.discipline = discipline;
                this.numberOfHours = numberOfHours;
                this.numberOfGroups = numberOfGroups;
        }

        public Course(Course c){
             this.id = c.id;
             this.title = c.title;
             this.discipline = c.discipline;
             this.numberOfHours = c.numberOfHours;
             this.numberOfGroups = c.numberOfGroups;
        }
}
