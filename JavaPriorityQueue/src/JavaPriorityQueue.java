/**
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED,
 * can take place which are described below.
 *
 * ENTER: A student with some priority enters the queue to be served.
 * SERVED: The student with the highest priority is served (removed) from the queue.
 *
 * A unique id is assigned to each student entering the queue. The queue serves the students based on the following
 * criteria (priority criteria):
 *
 * The student having the highest Cumulative Grade Point Average (CGPA) is served first.
 * Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
 * Any students having the same CGPA and name will be served in ascending order of the id.
 *
 * Create the following two classes:
 *
 * The Student class should implement:
 * The constructor Student(int id, String name, double cgpa).
 * The method int getID() to return the id of the student.
 * The method String getName() to return the name of the student.
 * The method double getCGPA() to return the CGPA of the student.
 * The Priorities class should implement the method List<Student> getStudents(List<String> events) to process all
 * the given events and return all the students yet to be served in the priority order.
 *
 * Input Format
 *
 * The first line contains an integer, n, describing the total number of events. Each of the subsequent lines will be
 * of the following two forms:
 *
 * ENTER name CGPA id: The student to be inserted into the priority queue.
 * SERVED: The highest priority student in the queue was served.
 *
 * The locked stub code in the editor reads the input and tests the correctness of the Student and Priorities classes
 * implementation.
 *
 * Constraints
 * 2 <= n <= 1000
 * 0 <= CGPA <= 4.00
 * 1 <= id <= 10^5
 * 2 <= |name| <= 30
 *
 * Output Format
 * The locked stub code prints the names of the students yet to be served in the priority order. If there are no such
 * student, then the code prints EMPTY.
 *
 * Sample Input 0
 * 12
 * ENTER John 3.75 50
 * ENTER Mark 3.8 24
 * ENTER Shafaet 3.7 35
 * SERVED
 * SERVED
 * ENTER Samiha 3.85 36
 * SERVED
 * ENTER Ashley 3.9 42
 * ENTER Maria 3.6 46
 * ENTER Anik 3.95 49
 * ENTER Dan 3.95 50
 * SERVED
 *
 * Sample Output 0
 *
 * Dan
 * Ashley
 * Shafaet
 * Maria
 **/

import java.util.*;

class Student {
    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getName() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}


class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> student_queue = new PriorityQueue(Comparator.comparing(Student::getCgpa)
                .reversed().thenComparing(Student::getName).thenComparing(Student::getToken));

        List<Student> students = new ArrayList<Student>();

        for (String e : events) {
            Scanner in = new Scanner(e);
            String event = in.next();
            if (event.equals("ENTER")) {
                String name = in.next();
                float cgpa = in.nextFloat();
                int token = in.nextInt();

                Student student = new Student(token, name, cgpa);
                student_queue.add(student);
            } else if (event.equals("SERVED")) {
                Student first = student_queue.poll();
            }
            in.close();
        }
        Student first = student_queue.poll();
        if (first == null) {
            return students;
        } else {
            while (first != null) {

                students.add(first);
                first = student_queue.poll();

            }
            return students;
        }

    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}