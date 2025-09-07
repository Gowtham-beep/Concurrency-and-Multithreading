package StudendDB;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

//Functional interface
@FunctionalInterface
interface StudentFilter{
    boolean test(Student s);
}


public class StudentDatabase implements Iterable<Student>, Serializable {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s){ students.add(s);}

    //StreamAPI
    public List<Student> filter(StudentFilter filter){
        return students.stream()
                        .filter(s->filter.test(s))
                        .collect(Collectors.toList());
    }
    public List<Student> sortByGrade(){
        return students.stream()
                        .sorted(Comparator.comparingDouble((Student s)->s.getGrade()).reversed())
                        .collect(Collectors.toList());
    }
    public Optional<Student> topScorer(){
        return students.stream()
                        .max(Comparator.comparingDouble((Student s)->s.getGrade()));
    }


    @Override
    public Iterator<Student> iterator(){
        return students.iterator();
    }

    public void saveToFile(String filename)throws IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(this);
        }
    }
    public static StudentDatabase loadFromFiles(String filename) throws IOException,ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            return (StudentDatabase) ois.readObject();
        }
    }
}
