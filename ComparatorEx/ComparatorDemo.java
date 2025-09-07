package ComparatorEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Charlie", 25));
        people.add(new Person("Bob", 35));
        people.add(new Person("David", 25));

        System.out.println("Original List:");
        people.forEach(System.out::println);
// -=-=-=-=-=-=-=----------=-=-=-=--------------------------
         Comparator<Person> byAgeComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1,Person p2){
            return Integer.compare(p1.getAge(), p1.getAge());
        }
    };
    Collections.sort(people,byAgeComparator);
    System.out.println("\nSorted by Age:");
    people.forEach(System.out::println);
// -=======================================================================   
    Comparator<Person> byNameComparator=(p1,p2)->p1.getName().compareTo(p2.getName());
    Collections.sort(people,byNameComparator);

    System.out.println("\nSorted by Name (Alphabetical):");
        people.forEach(System.out::println);
// -------------------------------------------------------------------------
    Comparator<Person> chaining = Comparator.comparing(Person::getAge)
                                            .thenComparing(Person::getName);
    Collections.sort(people, chaining);
        
        System.out.println("\nSorted by Age, then Name:");
        people.forEach(System.out::println);
    }  

}
    
