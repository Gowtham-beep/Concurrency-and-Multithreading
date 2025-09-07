package StudendDB;

import java.io.IOException;

public class StudentDemo {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        StudentDatabase db = new StudentDatabase();
        db.addStudent(new Student("Alice", 20, 85));
        db.addStudent(new Student("Bob", 22, 91));
        db.addStudent(new Student("Charlie", 19, 72));

            System.out.println("All Students: ");
            for(Student s: db){
                System.out.println(s);
            }
            System.out.println("Student older than 20: ");
            db.filter(s->s.getAge()>20).forEach(System.out::println);

            System.out.println("Sorted by grades: ");
            db.sortByGrade().forEach(System.out::println);

            System.out.println("Top Scorer: ");
            db.topScorer().ifPresent(System.out::println);

            db.saveToFile("students.ser");
            StudentDatabase loaded = StudentDatabase.loadFromFiles("students.ser");
            System.out.println("Loaded from file: ");
            for(Student s : loaded){
                System.out.println(s);
            }
    }
}
