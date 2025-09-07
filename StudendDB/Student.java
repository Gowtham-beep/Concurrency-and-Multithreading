package StudendDB;

import java.io.*;

class Student implements Serializable{
    private String name;
    private int age;
    private int grade;

    public Student(String name,int age,int grade){
        this.name=name;
        this.age=age;
        this.grade=grade;   
    }
    public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public int getGrade(){
            return grade;
        }
    @Override
    public String toString(){
        return name + " (Age: " + age + ", Grade: " + grade + ")";
    }
}
