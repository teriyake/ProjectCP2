import java.util.Arrays;
import java.util.HashMap;

public class Course {

    private int ID;
    private int time;
    private Room room;
    private int prof;
    private int enrollment;
    private int[] roster;
    //HashMap<Integer, Student> students = new HashMap<>();

    public Course(int id, int t, Room r, int p, int e, int n) {
        this.ID = id;
        this.time = t;
        this.room = r;
        this.prof = p;
        this.enrollment = e;
        this.roster = new int[n + 1];
    }

    public Course(int id, int n) {
        this(id, 0, null, 0, 0, n);
    }

    public int getID() {
        return this.ID;
    }
    public int getTime() {
        return this.time;
    }
    public Room getRoom() {
        return this.room;
    }
    public int getProf() {
        return this.prof;
    }
    public int getEnrollment() {
        return this.enrollment;
    } 
    public int[] getRoster() {
        return this.roster;
    }

    public String getRosterStr() {
        String ret = "";
        for (int i = 1; i < this.roster.length; i++) {
            if (roster[i] == 0) {
                break;
            } else {
                ret += roster[i] + " ";
            }
        }
        return ret;
    }

    /*
    public void enroll(int n) {
        this.enrollment = this.enrollment + n;
    }
    */

    public void enroll(int n) {

        this.enrollment = this.enrollment + 1;
        /*
        Student s = new Student(n);
        s.addCourse(this.getID());
        System.out.println(s);
        */
        roster[this.enrollment] = n;
        //return s.addTime(this.getTime());
        
        /*
        if (students.containsKey(n)) {

            Student s = students.get(n);
            
            Course[] c = students.get(n);
            for (int i = 0; i < 4; i++) {
                if (c[i] == null) {
                    c[i] = this;
                    break;
                }
            }
            
        } else {
            Course[] c = new Course[4];
            c[0] = this;
            students.put(n, c);
        }
        */
    }

    public void drop(int n) {
        for (int i = n; i > 0; i--) {
            roster[this.enrollment] = 0;
            this.enrollment--;
        }
    }

    /*
    public Student getStudentByID(int n) {
    }
    */

    public void assignRoom(Room r) {
        this.room = r;
    }

    public void assignTime(int t) {
        this.time = t;
    }

    public void assignProf(int p) {
        this.prof = p;
    }

    public String toString() {
        return String.format("Course ID: %d\nTime: %d\nRoom: %s\nProfessor: %d\nCurrent Enrollment: %d\n", 
                              this.ID, this.time, this.room, this.prof, this.enrollment);
    }

}
